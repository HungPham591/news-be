package com.news.news.controller;


import com.news.news.entity.Comment;
import com.news.news.entity.Config;
import com.news.news.service.CommentService;
import com.news.news.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConfigController extends BaseController<ConfigController> {
    @Autowired
    private ConfigService configService;

    @GetMapping(value = "/configs/{id}")
    public Config get(@PathVariable(name = "id") Long id) {
        return configService.getById(id);
    }

    @PutMapping("/configs")
    public Config update(Config config) {
        return configService.update(config);
    }

}
