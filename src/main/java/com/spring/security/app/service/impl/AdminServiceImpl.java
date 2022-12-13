package com.spring.security.app.service.impl;


import com.spring.security.app.service.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdmin() {
        System.out.println("Doing by admin");
    }
}
