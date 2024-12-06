package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionEntityTest {
    @Test
    void MathFunctionEntityTest1(){
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity(1L, "MathFunctionTest", 5, -10.0, 10.0, null);

        assertEquals(mathFunctionEntity.getId(), 1L);
        assertEquals(mathFunctionEntity.getFunc_name(), "MathFunctionTest");
        assertEquals(mathFunctionEntity.getPoints_count(), 5);
        assertEquals(mathFunctionEntity.getX_from(), -10.0);
        assertEquals(mathFunctionEntity.getX_to(), 10.0);
        assertNull(mathFunctionEntity.getPointEntityList());

        mathFunctionEntity.setId(0L);
        assertEquals(mathFunctionEntity.getId(), 0L);

        mathFunctionEntity.setFunc_name("FunctionMathTest");
        assertEquals(mathFunctionEntity.getFunc_name(), "FunctionMathTest");

        mathFunctionEntity.setPoints_count(10);
        assertEquals(mathFunctionEntity.getPoints_count(), 10);

        mathFunctionEntity.setX_from(7.5);
        assertEquals(mathFunctionEntity.getX_from(), 7.5);

        mathFunctionEntity.setX_to(9.1);
        assertEquals(mathFunctionEntity.getX_to(), 9.1);

        List <PointEntity> pointEntityList = List.of(new PointEntity[]{
                new PointEntity(2L, 2.3, 1.3, mathFunctionEntity),
                new PointEntity(3L, 5.5, 6.6, mathFunctionEntity),
                new PointEntity(4L, 9.9, 30.0, mathFunctionEntity)
        });
        mathFunctionEntity.setPointEntityList(pointEntityList);
        assertIterableEquals(mathFunctionEntity.getPointEntityList(), pointEntityList);
    }
}