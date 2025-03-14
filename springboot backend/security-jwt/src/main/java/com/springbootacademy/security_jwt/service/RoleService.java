package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}
