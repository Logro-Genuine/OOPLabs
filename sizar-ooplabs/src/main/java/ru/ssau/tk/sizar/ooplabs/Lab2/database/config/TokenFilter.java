package ru.ssau.tk.sizar.ooplabs.Lab2.database.config;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh.JWTCore;

import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {
    private JWTCore jwtCore;
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = null;
        String username = null;
        UserDetails userDetails = null;
        UsernamePasswordAuthenticationFilter passwordAuthenticationFilter = null;
        try {
            String header = request.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer *")){
                jwt = header.substring(7);
            }
            if (jwt != null) {
                try {
                    username = jwtCore.getNameFromJwt(jwt);
                } catch (ExpiredJwtException e) {

                }
            }
        }
    }
}