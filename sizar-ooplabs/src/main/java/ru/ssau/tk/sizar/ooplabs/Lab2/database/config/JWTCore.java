package ru.ssau.tk.sizar.ooplabs.Lab2.database.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTCore {
    @Value("${ru.ssau.tk.sizar.ooplabs.secret}")
    private String secret;

    @Value("${ru.ssau.tk.sizar.ooplabs.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserData userData = (UserData) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userData.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwt(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}
