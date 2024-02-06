package com.news.news.service;

import com.news.news.entity.Comment;
import com.news.news.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CommentService extends BaseService<Comment, Long> {
    @Autowired
    private CommentRepository commentRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(commentRepository);
    }

    public List<Comment> getList() {
        return commentRepository.findAll();
    }


}
