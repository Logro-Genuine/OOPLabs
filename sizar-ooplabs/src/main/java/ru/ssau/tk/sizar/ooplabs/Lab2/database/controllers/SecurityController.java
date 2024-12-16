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
import ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh.SigninRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh.SignupRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;

@RestController
@RequestMapping("api/auth")
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

    @PostMapping("/signin")
    public ResponseEntity<?> signin (@RequestBody SigninRequest signinRequest){
        Authentication authentication = null;
        try {
            authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),
                    signinRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody SignupRequest signupRequest){
        if (userRepo.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different name");
        }
        String hashed = passwordEncoder.encode(signupRequest.getPassword());
        UserEntity user = new UserEntity();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(hashed);
        userRepo.save(user);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        if (!userRepo.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        userRepo.deleteByUsername(username);
        return ResponseEntity.ok("User deleted successfully");
    }
}

