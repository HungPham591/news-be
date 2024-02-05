package com.news.news.service;

import com.news.news.entity.UserAccount;
import com.news.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;

    public UserAccount getById(Long id) {
        return userRepository.getOne(id);
    }

    public List<UserAccount> getList() {
        return userRepository.findAll();
    }

    public UserAccount create(UserAccount user) {
        return userRepository.save(user);
    }

    public UserAccount update(UserAccount user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
