package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionDTOTest {
    @Test
    void MathFunctionDTOTest1(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(3L,"MathFunctionTest", 5, -10.0, 10.0);

        assertEquals(mathFunctionDTO.getId(), 3L);
        assertEquals(mathFunctionDTO.getFunc_name(), "MathFunctionTest");
        assertEquals(mathFunctionDTO.getPoints_count(), 5);
        assertEquals(mathFunctionDTO.getX_from(), -10.0);
        assertEquals(mathFunctionDTO.getX_to(), 10.0);

        mathFunctionDTO.setId(0L);
        assertEquals(mathFunctionDTO.getId(), 0L);
        mathFunctionDTO.setFunc_name("FunctionMathTest");
        assertEquals(mathFunctionDTO.getFunc_name(), "FunctionMathTest");
        mathFunctionDTO.setPoints_count(10);
        assertEquals(mathFunctionDTO.getPoints_count(), 10);
        mathFunctionDTO.setX_from(7.5);
        assertEquals(mathFunctionDTO.getX_from(), 7.5);
        mathFunctionDTO.setX_to(9.1);
        assertEquals(mathFunctionDTO.getX_to(), 9.1);
    }
}