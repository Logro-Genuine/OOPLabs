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
import java.util.Optional;

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

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
