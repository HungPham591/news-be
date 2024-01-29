package com.news.news.service;

import com.news.news.entity.Category;
import com.news.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getById(Long id) {
        return categoryRepository.getOne(id);
    }

    public List<Category> getList() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
