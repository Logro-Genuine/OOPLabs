package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.SignupRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.UserData;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserData.build(user);
    }

    @Transactional
    public UserEntity register(SignupRequest signupRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setRole(signupRequest.getRole());

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        return userRepository.save(user);
    }

    @Transactional
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }
}
