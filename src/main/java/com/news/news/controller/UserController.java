package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.UserAccount;
import com.news.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/users/*")
public class UserController extends BaseController<UserAccount> {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public UserAccount get(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/")
    public List<UserAccount> getList() {
        return userService.getList();
    }

    @PostMapping("/")
    public UserAccount create(UserAccount user) {
        return userService.create(user);
    }

    @PutMapping("/")
    public UserAccount update(UserAccount user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }
    public void analyze(){

    }
}
