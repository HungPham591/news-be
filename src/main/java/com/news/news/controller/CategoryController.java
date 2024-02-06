package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.Category;
import com.news.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/categories/*")
public class CategoryController extends BaseRestController<Category, Category, Long> {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public List<Category> getList() {
        return categoryService.getList();
    }

}
