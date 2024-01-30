package com.news.news.controller;

import org.hibernate.JDBCException;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;

@Controller
public class AdminController extends BaseController {
    public void login() {
        throw new JDBCException("", new SQLException());
    }

    public void logout() {

    }

}
