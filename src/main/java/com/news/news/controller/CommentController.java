package com.news.news.controller;

import com.news.news.entity.Comment;
import com.news.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController extends BaseController<Comment> {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comments/{id}")
    public Comment get(@PathVariable(name = "id") Long id) {
        return commentService.getById(id);
    }

    @GetMapping(value = "/comments/")
    public List<Comment> getList() {
        return commentService.getList();
    }

    @PostMapping("/comments")
    public Comment create(Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("/comments")
    public Comment update(Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        commentService.delete(id);
    }
    public void analyze(){

    }
}
