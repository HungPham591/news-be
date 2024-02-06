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
public class UserController extends BaseRestController<UserAccount, UserAccount, Long> {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<UserAccount> getList() {
        return userService.getList();
    }
}
