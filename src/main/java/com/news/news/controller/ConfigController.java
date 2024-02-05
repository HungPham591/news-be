package com.news.news.controller;


import com.news.news.entity.ConfigApp;
import com.news.news.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ConfigController extends BaseController<ConfigController> {
    @Autowired
    private ConfigService configService;

    @GetMapping(value = "/configs/{id}")
    public ConfigApp get(@PathVariable(name = "id") Long id) {
        return configService.getById(id);
    }

    @PutMapping("/configs")
    public ConfigApp update(ConfigApp config) {
        return configService.update(config);
    }

}
