package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.repo.RoleRepo;
import com.springbootacademy.security_jwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        return userRepo.save(user);
    }

    // predefined inbuilt roles
    public void initRoleAndUser() {
        Role adminRole = new Role();
        Role userRole = new Role();
        if (!roleRepo.existsById("Admin")) {
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin role");
            roleRepo.save(adminRole);
        }
        if (!roleRepo.existsById("User")) {
            userRole.setRoleName("User");
            userRole.setRoleDescription("User role");
            roleRepo.save(userRole);
        }

        if (!userRepo.existsById("admin123")) {
            User user = new User();
            user.setUserName("admin123");
            user.setUserPassword(getEncodedPassword("admin@123"));
            user.setUserFirstName("kavindu");
            user.setUserLastName("sankalpa");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            user.setRole(adminRoles);
            userRepo.save(user);
        }
        if (!userRepo.existsById("user123")) {
            User user = new User();
            user.setUserName("user123");
            user.setUserPassword(getEncodedPassword("user@123"));
            user.setUserFirstName("jinani");
            user.setUserLastName("hansani");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            user.setRole(userRoles);
            userRepo.save(user);
        }
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
