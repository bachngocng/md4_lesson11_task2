package com.codegym.model;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Varchar(50)")
    private String author;

    @Column(columnDefinition = "Varchar(50)")
    private String title;

   @Column(columnDefinition = "LONGTEXT")
    private String content;

   @Column(columnDefinition = "DATETIME")
    private String date;

   @ManyToOne
   private Category category;

    public Post() {

    }

    public Post(Long id, String author, String title, String content, String date, Category category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Post(String author, String title, String content, String date, Category category) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
