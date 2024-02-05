package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.Comment;
import com.news.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/comments/*")
public class CommentController extends BaseController<Comment> {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/{id}")
    public Comment get(@PathVariable(name = "id") Long id) {
        return commentService.getById(id);
    }

    @GetMapping(value = "/")
    public List<Comment> getList() {
        return commentService.getList();
    }

    @PostMapping("/")
    public Comment create(Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("/")
    public Comment update(Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        commentService.delete(id);
    }
    public void analyze(){

    }
}
