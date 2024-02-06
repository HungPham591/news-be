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
public class CommentController extends BaseRestController<Comment, Comment, Long> {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/")
    public List<Comment> getList() {
        return commentService.getList();
    }
}
