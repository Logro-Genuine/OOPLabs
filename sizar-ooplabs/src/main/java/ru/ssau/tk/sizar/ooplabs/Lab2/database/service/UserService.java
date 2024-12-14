package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepo userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = UserRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserService.build(user);
    }

    @Transactional
    public UserEntity register(UserEntity user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        user.setPassword((user.getPassword());
        return userRepository.save(user);
    }

    @Transactional
    public void delete(String username) {
        userRepository.deleteByUsername(username); // Удаляем из базы
    }
}
