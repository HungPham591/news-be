package com.news.news.service;

import com.news.news.entity.ConfigApp;
import com.news.news.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ConfigService extends BaseService<ConfigApp, Long> {
    @Autowired
    private ConfigRepository configRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(configRepository);
    }

    public List<ConfigApp> getList() {
        return configRepository.findAll();
    }


}
