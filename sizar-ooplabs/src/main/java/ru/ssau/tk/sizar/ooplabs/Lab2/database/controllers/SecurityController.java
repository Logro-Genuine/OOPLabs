package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh.JWTCore;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager manager;
    private final JWTCore jwtCore;

    public SecurityController(UserRepo userRepo, PasswordEncoder passwordEncoder, AuthenticationManager manager, JWTCore jwtCore) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.manager = manager;
        this.jwtCore = jwtCore;
    }

    //@PostMapping("signin")

    //@PostMapping("signup")

    //@DeleteMapping("delete/{username}")
}

