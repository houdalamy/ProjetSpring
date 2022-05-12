package com.example.projetBackend.model.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private long idPost ;

    @Column(name = "message_post")
    private String message ;

    @Column(name = "date_post")
    @CreationTimestamp
    private Instant datePost ;






    public Post() {
    }

    public Post(String message) {
        this.message = message;
    }

    public Post(String message, Instant datePost) {
        this.message = message;
        this.datePost = datePost;
    }


    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDatePost() {
        return datePost;
    }

    public void setDatePost(Instant datePost) {
        this.datePost = datePost;
    }
}
