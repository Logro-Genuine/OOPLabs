package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.PointService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PointControllerTest {

    @Mock
    private PointService pointService;

    @InjectMocks
    private PointController pointController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePoint() {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setXValue(1.0);
        pointDTO.setYValue(2.0);
        when(pointService.create(any())).thenReturn(pointDTO);

        ResponseEntity<PointDTO> response = pointController.createPoint(pointDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(pointDTO, response.getBody());
    }

    @Test
    void testReadPoint_Success() {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setId(1L);
        pointDTO.setXValue(1.0);
        pointDTO.setYValue(2.0);
        when(pointService.read(1L)).thenReturn(pointDTO);

        ResponseEntity<PointDTO> response = pointController.readPoint(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pointDTO, response.getBody());
    }

    @Test
    void testReadPoint_NotFound() {
        when(pointService.read(1L)).thenReturn(null);

        ResponseEntity<PointDTO> response = pointController.readPoint(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdatePoint() {
        PointDTO updatedPoint = new PointDTO();
        updatedPoint.setId(1L);
        updatedPoint.setXValue(3.0);
        updatedPoint.setYValue(4.0);
        when(pointService.update(any())).thenReturn(updatedPoint);

        ResponseEntity<PointDTO> response = pointController.updatePoint(1L, updatedPoint);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPoint, response.getBody());
    }

    @Test
    void testDeletePoint_Success() {
        doNothing().when(pointService).delete(1L);

        ResponseEntity<Void> response = pointController.deletePoint(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeletePoint_NotFound() {
        doThrow(new RuntimeException()).when(pointService).delete(1L);

        ResponseEntity<Void> response = pointController.deletePoint(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testGetPointsByFunction_Success() {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setXValue(1.0);
        pointDTO.setYValue(2.0);
        when(pointService.findByFunction(1L)).thenReturn(List.of(pointDTO));

        ResponseEntity<List<PointDTO>> response = pointController.getPointsByFunction(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(pointDTO, response.getBody().get(0));
    }

    @Test
    void testGetPointsByFunction_NotFound() {
        when(pointService.findByFunction(1L)).thenReturn(Collections.emptyList());

        ResponseEntity<List<PointDTO>> response = pointController.getPointsByFunction(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
