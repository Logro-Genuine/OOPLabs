package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.JWTCore;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.SigninRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.SignupRequest;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.UserData;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserRole;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.UserRepo;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
class SecurityControllerTest {
    @Mock
    private UserRepo userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager manager;

    @Mock
    private JWTCore jwtCore;

    @Mock
    private UserService userService;

    @InjectMocks
    private SecurityController securityController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSignin_Success() {
        // Создаем мок-объект UserData
        UserData userData = mock(UserData.class);
        when(userData.getUsername()).thenReturn("user");

        // Создаем мок-объект Authentication
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(userData);

        // Настраиваем AuthenticationManager для возврата мок-объекта Authentication
        when(manager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtCore.generateToken(authentication)).thenReturn("jwt-token");

        // Создаем объект SigninRequest
        SigninRequest signinRequest = new SigninRequest("user", "password");

        // Выполняем тестируемый метод
        ResponseEntity<?> response = securityController.signin(signinRequest);

        // Проверяем результат
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("jwt-token", response.getBody());
    }

    @Test
    void testSignin_BadCredentials() {
        SigninRequest signinRequest = new SigninRequest("user", "wrong-password");
        when(manager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenThrow(new BadCredentialsException(""));

        ResponseEntity<?> response = securityController.signin(signinRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    void testSignup_Success() {
        SignupRequest signupRequest = new SignupRequest("newuser", "password", UserRole.USER);
        when(userRepo.existsByUsername(signupRequest.getUsername())).thenReturn(false);
        when(passwordEncoder.encode(signupRequest.getPassword())).thenReturn("hashed-password");

        ResponseEntity<?> response = securityController.signup(signupRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Success", response.getBody());
        verify(userService).register(any(SignupRequest.class));
    }

    @Test
    void testSignup_UsernameExists() {
        SignupRequest signupRequest = new SignupRequest("existinguser", "password", UserRole.ADMIN);
        when(userRepo.existsByUsername(signupRequest.getUsername())).thenReturn(true);

        ResponseEntity<?> response = securityController.signup(signupRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Choose different name", response.getBody());
    }

    @Test
    void testDeleteUser_Success() {
        String username = "user";
        when(userRepo.existsByUsername(username)).thenReturn(true);

        ResponseEntity<?> response = securityController.deleteUser(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully", response.getBody());
        verify(userService).delete(username);
    }

    @Test
    void testDeleteUser_NotFound() {
        String username = "nonexistentuser";
        when(userRepo.existsByUsername(username)).thenReturn(false);

        ResponseEntity<?> response = securityController.deleteUser(username);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }
}
