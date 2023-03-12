package com.example.demo.util;

import com.example.demo.model.Role;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.service.role.RoleService;
import com.example.demo.service.role.RoleServiceImpl;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitClass {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public InitClass(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");

        roleService.add(role1);
        roleService.add(role2);

        Set<Role> roleAdmin = new HashSet<>();
        Set<Role> roleUser = new HashSet<>();
        roleUser.add(role1);
        roleAdmin.add(role2);

        User user = new User(1, 20, "User", "user", Status.ACTIVE, roleUser);
        User admin = new User(2, 30, "Admin", "admin", Status.ACTIVE, roleAdmin);

        userService.save(admin);
        userService.save(user);
    }
}
