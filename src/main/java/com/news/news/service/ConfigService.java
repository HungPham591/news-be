package com.news.news.service;

import com.news.news.entity.ConfigApp;
import com.news.news.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService extends BaseService {
    @Autowired
    private ConfigRepository configRepository;

    public ConfigApp getById(Long id) {
        return configRepository.getOne(id);
    }

    public List<ConfigApp> getList() {
        return configRepository.findAll();
    }

    public ConfigApp create(ConfigApp config) {
        return configRepository.save(config);
    }

    public ConfigApp update(ConfigApp config) {
        return configRepository.save(config);
    }

    public void delete(Long id) {
        configRepository.deleteById(id);
    }
}
