package com.news.news.controller;

import com.news.news.entity.Admin;
import com.news.news.entity.Category;
import com.news.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories/{id}")
    public Category get(@PathVariable(name = "id") Long id) {
        return categoryService.getById(id);
    }

    @GetMapping(value = "/categories/")
    public List<Category> getList() {
        return categoryService.getList();
    }

    @PostMapping("/categories")
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/categories")
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
    }
    public void analyze(){

    }
}
