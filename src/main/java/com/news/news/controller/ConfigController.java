package com.news.news.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.ConfigAppDto;
import com.news.news.entity.Comment;
import com.news.news.entity.ConfigApp;
import com.news.news.service.ConfigService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/config/*")
public class ConfigController extends BaseRestController<ConfigAppDto, ConfigApp, Long> {
    @Autowired
    private ConfigService configService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(ConfigApp.class);
        super.setResponseClass(ConfigAppDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(configService);
        super.setObjectMapper(new ObjectMapper());
    }
}
