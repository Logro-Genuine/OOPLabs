package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.MathFunctionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MathFunctionControllerTest {

    @Mock
    private MathFunctionService mathFunctionService;

    @InjectMocks
    private MathFunctionController mathFunctionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFunctions_Success() {
        MathFunctionDTO functionDTO = new MathFunctionDTO();
        functionDTO.setFuncName("Test Function");
        when(mathFunctionService.findFunctions(null)).thenReturn(List.of(functionDTO));

        ResponseEntity<List<MathFunctionDTO>> response = mathFunctionController.getFunctions(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Test Function", response.getBody().get(0).getFuncName());
    }

    @Test
    void testGetFunctions_NotFound() {
        when(mathFunctionService.findFunctions(any())).thenThrow(new RuntimeException());

        ResponseEntity<List<MathFunctionDTO>> response = mathFunctionController.getFunctions(null);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateFunction() {
        MathFunctionDTO functionDTO = new MathFunctionDTO();
        functionDTO.setFuncName("New Function");
        when(mathFunctionService.create(any())).thenReturn(functionDTO);

        ResponseEntity<MathFunctionDTO> response = mathFunctionController.createFunction(functionDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("New Function", response.getBody().getFuncName());
    }

    @Test
    void testDeleteFunction_Success() {
        doNothing().when(mathFunctionService).delete(1L);

        ResponseEntity<Void> response = mathFunctionController.deleteFunction(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteFunction_NotFound() {
        doThrow(new EntityNotFoundException()).when(mathFunctionService).delete(1L);

        ResponseEntity<Void> response = mathFunctionController.deleteFunction(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateFunction() {
        MathFunctionDTO updatedFunction = new MathFunctionDTO();
        updatedFunction.setFuncName("Updated Function");
        when(mathFunctionService.update(any())).thenReturn(updatedFunction);

        ResponseEntity<MathFunctionDTO> response = mathFunctionController.updateFunction(updatedFunction);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Function", response.getBody().getFuncName());
    }

    @Test
    void testReadFunction_Success() {
        MathFunctionDTO functionDTO = new MathFunctionDTO();
        functionDTO.setFuncName("Read Function");
        when(mathFunctionService.read(1L)).thenReturn(functionDTO);

        ResponseEntity<MathFunctionDTO> response = mathFunctionController.readFunction(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Read Function", response.getBody().getFuncName());
    }

    @Test
    void testReadFunction_NotFound() {
        when(mathFunctionService.read(1L)).thenThrow(new EntityNotFoundException());

        ResponseEntity<MathFunctionDTO> response = mathFunctionController.readFunction(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
