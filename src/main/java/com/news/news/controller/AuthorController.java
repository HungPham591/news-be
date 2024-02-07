package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.dto.response.AuthorDto;
import com.news.news.entity.Admin;
import com.news.news.entity.Author;
import com.news.news.service.AdminService;
import com.news.news.service.AuthorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("/api/v1/authors/*")
public class AuthorController extends BaseRestController<AuthorDto, Author, Long> {

    @Autowired
    private AuthorService authorService;
    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(Author.class);
        super.setResponseClass(AuthorDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(authorService);
        super.setObjectMapper(new ObjectMapper());
    }
}
