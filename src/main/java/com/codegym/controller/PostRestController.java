package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.post.IPostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostRestController {
    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> findAllPosts(){
        List<Post> posts = (List<Post>) postService.findAll();
        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findOnePost(@PathVariable Long id){
        Optional<Post> postOptional = postService.findById(id);
        if(!postOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post){
        Post post1 = postService.save(post);
        return new ResponseEntity<>(post1,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updateCategory(@PathVariable Long id, @RequestBody Post post){
        Optional<Post> postOptional = postService.findById(id);
        if(!postOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        post.setId(id);
        post.setDate(postService.getCurrentDateTime());
        return new ResponseEntity<>(postService.save(post),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deleteCategory(@PathVariable Long id){
        Optional<Post> postOptional = postService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(postOptional.get(), HttpStatus.NO_CONTENT);
    }
}
