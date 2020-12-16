package me.hellozin.about.service;

import java.util.List;
import me.hellozin.about.entity.Article;
import me.hellozin.about.entity.Author;
import me.hellozin.about.repository.ArticleRepository;
import me.hellozin.about.repository.AuthorRepository;
import me.hellozin.about.request.ArticlePublishRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;

    public ArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public Article publish(ArticlePublishRequest articlePublishRequest) {
        long authorId = articlePublishRequest.getAuthorId();
        String content = articlePublishRequest.getContent();

        Author author = authorRepository.findById(authorId).orElseThrow(RuntimeException::new);
        Article article = new Article(author, content);

        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> getAllArticlesByAuthorId(long authorId) {
        return articleRepository.findAllByAuthorId(authorId);
    }

}
