package com.news.news.service;

import com.news.news.entity.News;
import com.news.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService extends BaseService {
    @Autowired
    private NewsRepository newsRepository;

    public News getById(Long id) {
        return newsRepository.getOne(id);
    }

    public List<News> getList() {
        return newsRepository.findAll();
    }

    public News create(News news) {
        return newsRepository.save(news);
    }

    public News update(News news) {
        return newsRepository.save(news);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
