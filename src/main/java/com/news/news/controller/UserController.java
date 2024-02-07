package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.UserDto;
import com.news.news.entity.Profile;
import com.news.news.entity.User;
import com.news.news.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/*")
public class UserController extends BaseRestController<UserDto, User, Long> {
    @Autowired
    private UserService userService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(User.class);
        super.setResponseClass(UserDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(userService);
        super.setObjectMapper(new ObjectMapper());
    }

    @GetMapping(value = "/")
    public List<User> getList() {
        return userService.getList();
    }
}
