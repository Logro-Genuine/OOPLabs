package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointDTOTest {
    @Test
    void PointDTOTest1(){
        PointDTO pointDTO = new PointDTO(7L, 7.0, 0.9, 9L);

        assertEquals(pointDTO.getId(), 7L);
        assertEquals(pointDTO.getXValue(), 7.0);
        assertEquals(pointDTO.getYValue(), 0.9);
        assertEquals(pointDTO.getFunc(), 9L);

        pointDTO.setId(6L);
        assertEquals(pointDTO.getId(), 6L);
        pointDTO.setXValue(-0.3);
        assertEquals(pointDTO.getXValue(), -0.3);
        pointDTO.setYValue(-1000.1);
        assertEquals(pointDTO.getYValue(), -1000.1);
        pointDTO.setFunc(1234L);
        assertEquals(pointDTO.getFunc(), 1234L);
    }

}