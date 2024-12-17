package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionEntityTest {
    @Test
    void MathFunctionEntityTest1(){
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity(1L, "MathFunctionTest", 5, -10.0, 10.0, null);

        assertEquals(mathFunctionEntity.getId(), 1L);
        assertEquals(mathFunctionEntity.getFuncName(), "MathFunctionTest");
        assertEquals(mathFunctionEntity.getPointsCount(), 5);
        assertEquals(mathFunctionEntity.getXFrom(), -10.0);
        assertEquals(mathFunctionEntity.getXTo(), 10.0);
        assertNull(mathFunctionEntity.getPointEntityList());

        mathFunctionEntity.setId(0L);
        assertEquals(mathFunctionEntity.getId(), 0L);

        mathFunctionEntity.setFuncName("FunctionMathTest");
        assertEquals(mathFunctionEntity.getFuncName(), "FunctionMathTest");

        mathFunctionEntity.setPointsCount(10);
        assertEquals(mathFunctionEntity.getPointsCount(), 10);

        mathFunctionEntity.setXFrom(7.5);
        assertEquals(mathFunctionEntity.getXFrom(), 7.5);

        mathFunctionEntity.setXTo(9.1);
        assertEquals(mathFunctionEntity.getXTo(), 9.1);

        List <PointEntity> pointEntityList = List.of(new PointEntity[]{
                new PointEntity(2L, 2.3, 1.3, mathFunctionEntity),
                new PointEntity(3L, 5.5, 6.6, mathFunctionEntity),
                new PointEntity(4L, 9.9, 30.0, mathFunctionEntity)
        });
        mathFunctionEntity.setPointEntityList(pointEntityList);
        assertIterableEquals(mathFunctionEntity.getPointEntityList(), pointEntityList);
    }
}