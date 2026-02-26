package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.controllers;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController
{
    private final PostService postService;

    @GetMapping
    private ResponseEntity<List<PostDTO>> getAllPosts()
    {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    private PostDTO getPostById(@PathVariable Long postId)
    {
        return postService.getPostById(postId);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO inputPost)
    {
        return ResponseEntity.ok(postService.createNewPost(inputPost));
    }

}
