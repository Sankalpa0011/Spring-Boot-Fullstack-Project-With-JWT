package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.dto.LoginRequest;
import com.springbootacademy.security_jwt.dto.LoginResponse;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.repo.UserRepo;
import com.springbootacademy.security_jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException(username + " not found");
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        for (Role role: user.getRole()) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        }
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }


    public LoginResponse createJwtToken(LoginRequest loginRequest) throws Exception {
        String username = loginRequest.getUsername();
        String userPassword = loginRequest.getUserPassword();

        authenticate(username, userPassword);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userRepo.findById(username).get();

        LoginResponse loginResponse = new LoginResponse(
                user,
                newGeneratedToken
        );
        return loginResponse;
    }

//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (BadCredentialsException e) {
//            throw new Exception("Invalid Credentials", e);
//        }
//    }

    private void authenticate(String username, String password) throws Exception {
        try {
//            System.out.println("Authenticating user: " + username);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            System.out.println("Authentication successful for user: " + username);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Credentials for user: " + username);
            throw new Exception("Invalid Credentials", e);
        }
    }
}
