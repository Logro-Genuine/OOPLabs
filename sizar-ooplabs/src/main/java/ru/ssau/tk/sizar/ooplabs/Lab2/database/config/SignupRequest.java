package ru.ssau.tk.sizar.ooplabs.Lab2.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserRole;

@Data
@AllArgsConstructor
public class SignupRequest {
    private String username;
    private String password;
    private UserRole role;
}
