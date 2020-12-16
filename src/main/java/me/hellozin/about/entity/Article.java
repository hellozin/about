package me.hellozin.about.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Author author;

    private String content;

    protected Article() {
    }

    public Article(Author author, String content) {
        this.author = author;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

}
