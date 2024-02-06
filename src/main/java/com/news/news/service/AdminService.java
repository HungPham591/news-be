package com.news.news.service;

import com.news.news.entity.Admin;
import com.news.news.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AdminService extends BaseService<Admin, Long> {
    @Autowired
    private AdminRepository adminRepository;

    @PostConstruct
    private void postConstruct(){
        super.setRepository(adminRepository);
    }


    public List<Admin> getList() {
        return adminRepository.findAll();
    }


}
