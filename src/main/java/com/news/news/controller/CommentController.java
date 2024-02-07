package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.CommentDto;
import com.news.news.entity.Category;
import com.news.news.entity.Comment;
import com.news.news.service.CommentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments/*")
public class CommentController extends BaseRestController<CommentDto, Comment, Long> {
    @Autowired
    private CommentService commentService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(Comment.class);
        super.setResponseClass(CommentDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(commentService);
        super.setObjectMapper(new ObjectMapper());
    }

    @GetMapping(value = "/")
    public List<Comment> getList() {
        return commentService.getList();
    }
}
