package com.news.news.service;

import com.news.news.entity.Profile;
import com.news.news.entity.User;
import com.news.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService extends BaseService<User, Long> {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        super.setRepository(userRepository);
    }

    public List<User> getList() {
        return userRepository.findAll();
    }


}
