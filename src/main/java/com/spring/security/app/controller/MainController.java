package com.spring.security.app.controller;

import com.spring.security.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdmin();
        return "admin";
    }
}
