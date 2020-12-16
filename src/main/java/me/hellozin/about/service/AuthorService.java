package me.hellozin.about.service;

import java.util.List;
import java.util.Optional;
import me.hellozin.about.entity.Author;
import me.hellozin.about.repository.AuthorRepository;
import me.hellozin.about.request.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author signUp(SignUpRequest signUpRequest) {
        String name = signUpRequest.getName();

        Author author = new Author(name);

        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(long authorId) {
        return authorRepository.findById(authorId);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
