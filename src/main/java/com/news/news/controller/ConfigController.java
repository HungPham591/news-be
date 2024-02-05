package com.news.news.controller;


import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.ConfigApp;
import com.news.news.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiPrefix
@RequestMapping("/v1/config/*")
public class ConfigController extends BaseController<ConfigController> {
    @Autowired
    private ConfigService configService;

    @GetMapping(value = "/{id}")
    public ConfigApp get(@PathVariable(name = "id") Long id) {
        return configService.getById(id);
    }

    @PutMapping("/{id}")
    public ConfigApp update(ConfigApp config) {
        return configService.update(config);
    }

}
