package com.news.news.service;

import com.news.news.entity.Category;
import com.news.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CategoryService extends BaseService<Category, Long> {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(categoryRepository);
    }

    public List<Category> getList() {
        return categoryRepository.findAll();
    }

}
