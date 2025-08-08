package com.springlabs.lab16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class JsonPlaceholderService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    public JsonPlaceholderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> getAllPosts() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(BASE_URL, Post[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public Post getPostById(Long id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, Post.class);
    }

    public Post createPost(Post newPost) {
        return restTemplate.postForObject(BASE_URL, newPost, Post.class);
    }

    public void updatePost(Long id, Post updatedPost) {
        String url = BASE_URL + "/" + id;
        restTemplate.put(url, updatedPost);
    }

    public void deletePost(Long id) {
        String url = BASE_URL + "/" + id;
        restTemplate.delete(url);
    }
}