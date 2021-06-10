package com.culnou.mumu.my_way.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.culnou.mumu.my_way.temp.entity.mongo.Comment;
import com.culnou.mumu.my_way.temp.service.CommentMongoService;


@RestController
public class CommentController {
	
	@Autowired
    private CommentMongoService commentService;

    @GetMapping("/comments")
    public ResponseEntity< List< Comment >> getAllComment() {
        return ResponseEntity.ok().body(commentService.getAllComment());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity < Comment > getCommentById(@PathVariable String id) {
        return ResponseEntity.ok().body(commentService.getCommentById(id));
    }

    @PostMapping("/comments")
    public ResponseEntity < Comment > createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok().body(this.commentService.createComment(comment));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity < Comment > updateComment(@PathVariable String id, @RequestBody Comment comment) {
        comment.setId(id);
        return ResponseEntity.ok().body(this.commentService.updateComment(comment));
    }

    @DeleteMapping("/comments/{id}")
    public HttpStatus deleteComment(@PathVariable String id) {
        this.commentService.deleteComment(id);
        return HttpStatus.OK;
    }

}
