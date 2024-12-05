package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionDTOTest {
    @Test
    void MathFunctionDTOTest(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(3L,"MathFunctionTest", 5, -10.0, 10.0);

        assertEquals(mathFunctionDTO.getId(), 3L);
        assertEquals(mathFunctionDTO.getFuncName(), "MathFunctionTest");
        assertEquals(mathFunctionDTO.getPointsCount(), 5);
        assertEquals(mathFunctionDTO.getXFrom(), -10.0);
        assertEquals(mathFunctionDTO.getXTo(), 10.0);

        mathFunctionDTO.setId(0L);
        assertEquals(mathFunctionDTO.getId(), 0L);
        mathFunctionDTO.setFuncName("FunctionMathTest");
        assertEquals(mathFunctionDTO.getFuncName(), "FunctionMathTest");
        mathFunctionDTO.setPointsCount(10);
        assertEquals(mathFunctionDTO.getPointsCount(), 10);
        mathFunctionDTO.setXFrom(7.5);
        assertEquals(mathFunctionDTO.getXFrom(), 7.5);
        mathFunctionDTO.setXTo(9.1);
        assertEquals(mathFunctionDTO.getXTo(), 9.1);
    }
}