package me.hellozin.about.controller;

import java.util.List;
import me.hellozin.about.entity.Article;
import me.hellozin.about.request.ArticlePublishRequest;
import me.hellozin.about.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/article")
    public Article publishArticle(ArticlePublishRequest article) {
        return articleService.publish(article);
    }

    @GetMapping("/article/list")
    public List<Article> getArticleList() {
        return articleService.getAllArticles();
    }

}
