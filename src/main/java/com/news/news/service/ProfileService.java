package com.news.news.service;

import com.news.news.entity.Profile;
import com.news.news.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProfileService extends BaseService<Profile, Long> {
    @Autowired
    private ProfileRepository profileRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(profileRepository);
    }

    public List<Profile> getList() {
        return profileRepository.findAll();
    }


}
