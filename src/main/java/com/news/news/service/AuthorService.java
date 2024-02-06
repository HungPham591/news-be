package com.news.news.service;

import com.news.news.entity.Author;
import com.news.news.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AuthorService extends BaseService<Author, Long> {
    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(authorRepository);
    }
}
