package com.news.news.controller;

import com.news.news.entity.Author;
import com.news.news.service.BaseService;


public class AuthorController extends BaseController<Author, Author, Long> {

    public AuthorController(BaseService<Author, Long> service, Class<Author> responseClass, Class<Author> entityClass) {
        super(service, responseClass, entityClass);
    }
}
