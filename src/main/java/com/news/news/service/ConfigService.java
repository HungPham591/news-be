package com.news.news.service;

import com.news.news.entity.Config;
import com.news.news.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService extends BaseService {
    @Autowired
    private ConfigRepository configRepository;

    public Config getById(Long id) {
        return configRepository.getOne(id);
    }

    public List<Config> getList() {
        return configRepository.findAll();
    }

    public Config create(Config config) {
        return configRepository.save(config);
    }

    public Config update(Config config) {
        return configRepository.save(config);
    }

    public void delete(Long id) {
        configRepository.deleteById(id);
    }
}
