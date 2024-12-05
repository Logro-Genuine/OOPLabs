package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointEntityTest {
    @Test
    void PointEntityTest(){
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity();
        PointEntity PointEntity = new PointEntity(7L, 7.0, 0.9, mathFunctionEntity);

        assertEquals(PointEntity.getId(), 7L);
        assertEquals(PointEntity.getXValue(), 7.0);
        assertEquals(PointEntity.getYValue(), 0.9);
        assertEquals(PointEntity.getFunc_ent(), mathFunctionEntity);

        PointEntity.setId(6L);
        assertEquals(PointEntity.getId(), 6L);
        PointEntity.setXValue(-0.3);
        assertEquals(PointEntity.getXValue(), -0.3);
        PointEntity.setYValue(-1000.1);
        assertEquals(PointEntity.getYValue(), -1000.1);

        MathFunctionEntity otherMathFunctionEntity = new MathFunctionEntity();
        PointEntity.setFunc_ent(otherMathFunctionEntity);
        assertEquals(PointEntity.getFunc_ent(), otherMathFunctionEntity);
    }

}