package me.hellozin.about.repository;

import java.util.List;
import me.hellozin.about.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByAuthorId(long authorId);

}
