package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.CategoryDto;
import com.news.news.entity.Author;
import com.news.news.entity.Category;
import com.news.news.service.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories/*")
public class CategoryController extends BaseRestController<CategoryDto, Category, Long> {
    @Autowired
    private CategoryService categoryService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(Category.class);
        super.setResponseClass(CategoryDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(categoryService);
        super.setObjectMapper(new ObjectMapper());
    }

    @GetMapping(value = "/")
    public List<Category> getList() {
        return categoryService.getList();
    }

}
