package ru.ssau.tk.sizar.ooplabs.Lab2.database.config;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;

import java.util.Collection;
import java.util.List;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class UserData implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    public static UserData build(UserEntity user) {
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("Role_" + user.getRole().name()));

        return new UserData(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities
        );
    }
}
