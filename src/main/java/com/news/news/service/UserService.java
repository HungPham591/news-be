package com.news.news.service;

import com.news.news.entity.User;
import com.news.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> getList() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
