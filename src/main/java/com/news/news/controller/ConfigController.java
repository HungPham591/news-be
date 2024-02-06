package com.news.news.controller;


import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.ConfigApp;
import com.news.news.service.BaseService;
import com.news.news.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiPrefix
@RequestMapping("/v1/config/*")
public class ConfigController extends BaseController<ConfigApp, ConfigApp, Long> {
    @Autowired
    private ConfigService configService;

    public ConfigController(@Qualifier("configService") BaseService<ConfigApp, Long> service, Class<ConfigApp> responseClass, Class<ConfigApp> entityClass) {
        super(service, responseClass, entityClass);
    }

}
