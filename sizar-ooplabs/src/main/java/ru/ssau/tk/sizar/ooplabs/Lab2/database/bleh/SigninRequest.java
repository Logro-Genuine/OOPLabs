package ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninRequest {
    private String username;
    private String password;
}
