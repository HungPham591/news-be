package com.news.news.service;

import com.news.news.entity.Comment;
import com.news.news.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment getById(Long id) {
        return commentRepository.getOne(id);
    }

    public List<Comment> getList() {
        return commentRepository.findAll();
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
