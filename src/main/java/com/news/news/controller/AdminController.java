package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.component.filter.RequestResponseLoggingFilter;
import com.news.news.entity.Admin;
import com.news.news.service.AdminService;
import com.news.news.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/admins/*")
public class AdminController extends BaseController<Admin, Admin, Long> {
    private final static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Autowired
    private AdminService adminService;

    public AdminController(@Qualifier("adminService")  BaseService<Admin, Long> service, Class<Admin> responseClass, Class<Admin> entityClass) {
        super(service, responseClass, entityClass);
    }


    @GetMapping(value = "/")
    public List<Admin> getList() {
        return adminService.getList();
    }

}
