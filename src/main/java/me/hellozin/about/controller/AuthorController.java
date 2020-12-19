package me.hellozin.about.controller;

import me.hellozin.about.entity.Author;
import me.hellozin.about.request.SignUpRequest;
import me.hellozin.about.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{authorId}")
    public Author getAuthorById(@PathVariable long authorId) {
        return authorService.getAuthorById(authorId).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/author")
    public Author signUp(SignUpRequest signUpRequest) {
        final String authorName = signUpRequest.getName();

        return authorService.signUp(authorName);
    }
}
