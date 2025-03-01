package com.springbootacademy.security_jwt.configuration;

import com.springbootacademy.security_jwt.service.JwtService;
import com.springbootacademy.security_jwt.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         final String requestTokenHeader = request.getHeader("Authorization");

         String username = null;
         String jwtToken = null;

         if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
             jwtToken = requestTokenHeader.substring(7);
             try {
                 username = jwtUtil.getUsernameFromToken(jwtToken); //username = jwtToken.split(":")[0];
             } catch (IllegalArgumentException e) {
                 System.out.println("Invalid JWT token" + e.getMessage());
             } catch (ExpiredJwtException e) {
                 System.out.println("Expired JWT token" + e.getMessage());
             }
         } else {
             System.out.println("JWT token header is missing");
         }

         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
             UserDetails userDetails = jwtService.loadUserByUsername(username);

             if (jwtUtil.validateToken(jwtToken, userDetails)) {
                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                         userDetails,
                         null,
                         userDetails.getAuthorities()
                 );
                 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
             }
         }
         filterChain.doFilter(request, response);
    }
}
