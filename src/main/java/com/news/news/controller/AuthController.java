package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiPrefix
@RequestMapping("/v1/auth/*")
public class AuthController extends BaseRestController {

    @PostMapping("/login")
    public void login() {

    }
    @PostMapping("/logout")
    public void logout() {

    }
    @PostMapping("/sign-up")
    public void signUp() {

    }
    @PostMapping("/refresh")
    public void refresh(){

    }
    @PostMapping("/reset-password")
    public void resetPassword(){

    }
}
