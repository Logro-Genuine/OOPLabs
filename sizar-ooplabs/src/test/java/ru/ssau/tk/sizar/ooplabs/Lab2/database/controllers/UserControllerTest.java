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
        when(principal.getName()).thenReturn("testUser");

        String result = userController.userAccess(principal);

        assertEquals("testUser", result);
    }

    @Test
    void testUserAccess_WithoutPrincipal() {
        String result = userController.userAccess(null);

        assertNull(result);
    }
}
