package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.JWTCore;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.SigninRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.SignupRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.UserService;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class SecurityController {
    private UserRepo userRepo;
    private AuthenticationManager manager;
    private JWTCore jwtCore;
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager){
        this.manager = authenticationManager;
    }
    @Autowired
    public void setJwtCore(JWTCore jwtCore){
        this.jwtCore = jwtCore;
    }
    @Autowired
    void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin (@RequestBody SigninRequest signinRequest){
        Authentication authentication = null;
        try {
            System.out.println(signinRequest.getUsername()+" "+
                    signinRequest.getPassword());
            authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
                    signinRequest.getUsername(),
                    signinRequest.getPassword())
            );
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
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userService.register(signupRequest);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        if (!userRepo.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        this.userService.delete(username);
        return ResponseEntity.ok("User deleted successfully");
    }
}

