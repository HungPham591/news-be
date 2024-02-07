package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.NewsDto;
import com.news.news.entity.ConfigApp;
import com.news.news.entity.News;
import com.news.news.service.NewsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/news/*")
public class NewsController extends BaseRestController<NewsDto, News, Long> {
    @Autowired
    private NewsService newsService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(News.class);
        super.setResponseClass(NewsDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(newsService);
        super.setObjectMapper(new ObjectMapper());
    }

    @GetMapping(value = "/")
    public List<News> getList() {
        return newsService.getList();
    }
}
