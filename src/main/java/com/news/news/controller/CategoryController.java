package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.Category;
import com.news.news.service.BaseService;
import com.news.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/categories/*")
public class CategoryController extends BaseController<Category, Category, Long> {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(@Qualifier("categoryService") BaseService<Category, Long> service, Class<Category> responseClass, Class<Category> entityClass) {
        super(service, responseClass, entityClass);
    }

    @GetMapping(value = "/")
    public List<Category> getList() {
        return categoryService.getList();
    }

}
