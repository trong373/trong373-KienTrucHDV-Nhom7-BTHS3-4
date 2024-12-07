package com.example.bths2.middleware;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.bths2.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
    
        // Bỏ qua kiểm tra token cho /hello
        if ("/hello".equals(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
    
        // Kiểm tra token nếu yêu cầu
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (JwtUtil.validateToken(token, "username")) { // Kiểm tra token
                filterChain.doFilter(request, response);
                return;
            }
        }
    
        // Nếu không có token hợp lệ, trả về lỗi Unauthorized
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
}    