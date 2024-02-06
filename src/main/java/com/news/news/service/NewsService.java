package com.news.news.service;

import com.news.news.entity.News;
import com.news.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NewsService extends BaseService<News, Long> {
    @Autowired
    private NewsRepository newsRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(newsRepository);
    }

    public List<News> getList() {
        return newsRepository.findAll();
    }

}
