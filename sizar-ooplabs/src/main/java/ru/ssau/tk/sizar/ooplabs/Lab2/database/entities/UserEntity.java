package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    @NotNull
    private String username;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Size(min = 6, max = 255)
    private String password;

    @Column(nullable = false)
    @NotNull
    private UserRole role;
}
