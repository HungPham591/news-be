package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.entity.UserAccount;
import com.news.news.service.BaseService;
import com.news.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/users/*")
public class UserController extends BaseController<UserAccount, UserAccount, Long> {
    @Autowired
    private UserService userService;

    public UserController(@Qualifier("userService") BaseService<UserAccount, Long> service, Class<UserAccount> responseClass, Class<UserAccount> entityClass) {
        super(service, responseClass, entityClass);
    }

    @GetMapping(value = "/")
    public List<UserAccount> getList() {
        return userService.getList();
    }
}
