package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/user")
    public String userAccess(Principal principal){
        if (principal==null){
            return null;
        }
        return principal.getName();
    }
}
