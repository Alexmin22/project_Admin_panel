package com.example.demo.controller;

import com.example.demo.services.AdminService;
import com.example.demo.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private final AdminService adminService;
    private final Converter modelMapperUser;

    @Autowired
    public HelloController(AdminService adminService, Converter modelMapperUser) {
        this.adminService = adminService;
        this.modelMapperUser = modelMapperUser;
    }

//    public UserDTO merge(UserDTO userDTO) {
//        adminService.merge(modelMapperUser.convertToUser(userDTO));
//    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();
        return "admin";
    }
}
