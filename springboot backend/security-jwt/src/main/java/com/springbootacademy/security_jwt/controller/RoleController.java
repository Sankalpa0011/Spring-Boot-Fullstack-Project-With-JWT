package com.springbootacademy.security_jwt.controller;

import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create-new-role")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
