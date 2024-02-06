package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.News;
import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/news/*")
public class NewsController extends BaseRestController<News, News, Long> {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/")
    public List<News> getList() {
        return newsService.getList();
    }
}
