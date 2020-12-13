package me.hellozin.about.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private long id;

    private long authorId;

    private String content;

    protected Article() {
    }

    public Article(long authorId, String content) {
        this.authorId = authorId;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

}
