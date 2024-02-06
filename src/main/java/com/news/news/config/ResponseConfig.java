package com.news.news.config;

import com.news.news.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseConfig {
    @Bean
    public Class<Admin> adminClass() {
        return Admin.class;
    }
    @Bean
    public Class<Category> categoryClass() {
        return Category.class;
    }
    @Bean
    public Class<Comment> commentClass() {
        return Comment.class;
    }
    @Bean
    public Class<ConfigApp> configAppClass() {
        return ConfigApp.class;
    }
    @Bean
    public Class<News> newsClass() {
        return News.class;
    }
    @Bean
    public Class<UserAccount> userAccountClass() {
        return UserAccount.class;
    }
}
