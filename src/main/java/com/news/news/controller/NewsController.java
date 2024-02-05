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
public class NewsController extends BaseController<NewsController> {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/{id}")
    public News get(@PathVariable(name = "id") Long id) {
        return newsService.getById(id);
    }

    @GetMapping(value = "/")
    public List<News> getList() {
        return newsService.getList();
    }

    @PostMapping("/")
    public News create(News news) {
        return newsService.create(news);
    }

    @PutMapping("/")
    public News update(News news) {
        return newsService.update(news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        newsService.delete(id);
    }
    public void analyze(){

    }

}
