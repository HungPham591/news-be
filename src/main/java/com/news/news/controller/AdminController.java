package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.common.annotation.ApiPrefix;
import com.news.news.dto.response.AdminDto;
import com.news.news.entity.Admin;
import com.news.news.service.AdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admins/*")
public class AdminController extends BaseRestController<AdminDto, Admin, Long> {

    @Autowired
    private AdminService adminService;

    @PostConstruct
    private void postConstruct(){
        super.setEntityClass(Admin.class);
        super.setResponseClass(AdminDto.class);
        super.setLogger(LoggerFactory.getLogger(this.getClass()));
        super.setService(adminService);
        super.setObjectMapper(new ObjectMapper());
    }



    @GetMapping(value = "/")
    public List<Admin> getList() {
        return adminService.getList();
    }

}
