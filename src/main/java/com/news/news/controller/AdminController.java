package com.news.news.controller;

import com.news.news.common.annotation.ApiPrefix;
import com.news.news.component.filter.RequestResponseLoggingFilter;
import com.news.news.entity.Admin;
import com.news.news.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiPrefix
@RequestMapping("/v1/admins/*")
public class AdminController extends BaseController<AdminController> {
    private final static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/{id}")
    public Admin get(@PathVariable(name = "id") Long id) {
        return adminService.getById(id);
    }

    @GetMapping(value = "/")
    public List<Admin> getList() {
        return adminService.getList();
    }

    @PostMapping("/")
    public Admin create(Admin admin) {
        return adminService.create(admin);
    }

    @PutMapping("/")
    public Admin update(Admin admin) {
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        adminService.delete(id);
    }
    public void analyze(){

    }
}
