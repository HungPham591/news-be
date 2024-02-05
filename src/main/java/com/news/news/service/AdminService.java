package com.news.news.service;

import com.news.news.entity.Admin;
import com.news.news.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService extends BaseService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getById(Long id) {
        return adminRepository.getOne(id);
    }

    public List<Admin> getList() {
        return adminRepository.findAll();
    }

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin update(Admin admin) {
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

}
