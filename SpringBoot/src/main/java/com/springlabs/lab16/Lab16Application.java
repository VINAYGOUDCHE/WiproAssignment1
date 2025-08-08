package com.springlabs.lab16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab16Application implements CommandLineRunner {

    @Autowired
    private JsonPlaceholderService jsonPlaceholderService;

    public static void main(String[] args) {
        SpringApplication.run(Lab16Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- GET all posts ---");
        jsonPlaceholderService.getAllPosts().forEach(post -> System.out.println(post.getTitle()));

        System.out.println("\n--- GET post by ID (1) ---");
        Post post = jsonPlaceholderService.getPostById(1L);
        System.out.println(post);

        System.out.println("\n--- POST a new post ---");
        Post newPost = new Post();
        newPost.setUserId(1L);
        newPost.setTitle("My New Post Title");
        newPost.setBody("This is the body of my new post.");
        Post createdPost = jsonPlaceholderService.createPost(newPost);
        System.out.println("Created Post: " + createdPost);

        System.out.println("\n--- PUT (update) an existing post (1) ---");
        Post updatedPost = new Post();
        updatedPost.setId(1L);
        updatedPost.setTitle("Updated Title for Post 1");
        updatedPost.setBody("Updated body content.");
        jsonPlaceholderService.updatePost(1L, updatedPost);
        System.out.println("Post with ID 1 has been updated.");

        System.out.println("\n--- DELETE post (1) ---");
        jsonPlaceholderService.deletePost(1L);
        System.out.println("Post with ID 1 has been deleted.");
    }
}