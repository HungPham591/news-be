package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.Comment;
import com.news.news.service.BaseService;
import com.news.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/comments/*")
public class CommentController extends BaseController<Comment, Comment, Long> {
    @Autowired
    private CommentService commentService;

    public CommentController(@Qualifier("commentService") BaseService<Comment, Long> service, Class<Comment> responseClass, Class<Comment> entityClass) {
        super(service, responseClass, entityClass);
    }

    @GetMapping(value = "/")
    public List<Comment> getList() {
        return commentService.getList();
    }
}
