package com.news.news.controller;

import com.news.news.entity.UserAccount;
import com.news.news.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "User", description = "API")
public class UserController extends BaseController<UserAccount> {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{id}")
    public UserAccount get(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/users/")
    public List<UserAccount> getList() {
        return userService.getList();
    }

    @PostMapping("/users")
    public UserAccount create(UserAccount user) {
        return userService.create(user);
    }

    @PutMapping("/users")
    public UserAccount update(UserAccount user) {
        return userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }
    public void analyze(){

    }
}
