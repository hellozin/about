package me.hellozin.about.service;

import java.util.List;
import me.hellozin.about.entity.Article;
import me.hellozin.about.repository.ArticleRepository;
import me.hellozin.about.request.ArticlePublishRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article publish(ArticlePublishRequest articlePublishRequest) {
        long authorId = articlePublishRequest.getAuthorId();
        String content = articlePublishRequest.getContent();

        Article article = new Article(authorId, content);

        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> getAllArticlesByAuthorId(long authorId) {
        return articleRepository.findAllByAuthorId(authorId);
    }

}
