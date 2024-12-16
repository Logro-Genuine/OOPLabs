package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private Principal principal;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserAccess_WithPrincipal() {
        // Настраиваем мок-объект Principal
        when(principal.getName()).thenReturn("testUser");

        // Вызываем метод userAccess
        String result = userController.userAccess(principal);

        // Проверяем результат
        assertEquals("testUser", result);
    }

    @Test
    void testUserAccess_WithoutPrincipal() {
        // Вызываем метод userAccess с null
        String result = userController.userAccess(null);

        // Проверяем результат
        assertNull(result);
    }
}
