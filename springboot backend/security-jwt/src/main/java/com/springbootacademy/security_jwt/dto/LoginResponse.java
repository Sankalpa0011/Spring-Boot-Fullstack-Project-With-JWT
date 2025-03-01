package com.springbootacademy.security_jwt.dto;

import com.springbootacademy.security_jwt.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
    private User user;
    private String jwtToken;
}
