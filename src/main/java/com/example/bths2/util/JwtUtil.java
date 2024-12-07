package com.example.bths2.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Sinh JWT token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Token có hiệu lực 1 giờ
                .signWith(key)
                .compact();
    }

    // Xác thực token
    public static boolean validateToken(String token, String username) {
        String tokenUsername = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
        return (username.equals(tokenUsername) && !isTokenExpired(token));
    }

    // Kiểm tra token đã hết hạn
    private static boolean isTokenExpired(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}
