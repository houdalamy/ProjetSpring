package com.example.projetBackend.model.repository;

import com.example.projetBackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByMessage(String message);

    @Query(value = "SELECT * FROM post p WHERE LENGTH(p.message_post) > 20",
            nativeQuery = true)
    List<Post> findLongPosts();





}
