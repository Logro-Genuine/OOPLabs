package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        try {
            UserEntity createdUser = userService.register(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // 409 Conflict
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDetails> getUser(@PathVariable String username) {
        UserDetails user = userService.loadUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.delete(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}
