package me.hellozin.about.mock;

import java.util.List;
import me.hellozin.about.entity.Author;
import me.hellozin.about.request.ArticlePublishRequest;
import me.hellozin.about.request.SignUpRequest;
import me.hellozin.about.service.ArticleService;
import me.hellozin.about.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockDataGenerator implements CommandLineRunner {

    private final AuthorService authorService;
    private final ArticleService articleService;

    public MockDataGenerator(AuthorService authorService, ArticleService articleService) {
        this.authorService = authorService;
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) {
        final int numOfAuthor = 5;
        for (int i = 0; i < numOfAuthor; i++) {
            SignUpRequest signUpRequest = new SignUpRequest();
            signUpRequest.setName("user" + i);
            authorService.signUp(signUpRequest);
        }

        final int articleCountPerAuthor = 10;
        List<Author> authors = authorService.getAllAuthor();
        for (Author author : authors) {
            for (int i = 0; i < articleCountPerAuthor; i++) {
                ArticlePublishRequest articlePublishRequest = new ArticlePublishRequest();
                articlePublishRequest.setAuthorId(author.getId());
                articlePublishRequest.setContent("content" + i);
                articleService.publish(articlePublishRequest);
            }
        }
    }
}
