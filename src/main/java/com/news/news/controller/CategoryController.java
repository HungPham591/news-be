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
public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public Category get(@PathVariable(name = "id") Long id) {
        return categoryService.getById(id);
    }

    @GetMapping(value = "/")
    public List<Category> getList() {
        return categoryService.getList();
    }

    @PostMapping("/")
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/")
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
    }
    public void analyze(){

    }
}
