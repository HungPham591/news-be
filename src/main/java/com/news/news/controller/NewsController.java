package com.news.news.controller;

import com.news.news.entity.Comment;
import com.news.news.entity.News;
import com.news.news.service.CommentService;
import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewsController extends BaseController<NewsController> {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news/{id}")
    public News get(@PathVariable(name = "id") Long id) {
        return newsService.getById(id);
    }

    @GetMapping(value = "/news/")
    public List<News> getList() {
        return newsService.getList();
    }

    @PostMapping("/news")
    public News create(News news) {
        return newsService.create(news);
    }

    @PutMapping("/news")
    public News update(News news) {
        return newsService.update(news);
    }

    @DeleteMapping("/news/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        newsService.delete(id);
    }
    public void analyze(){

    }
}
