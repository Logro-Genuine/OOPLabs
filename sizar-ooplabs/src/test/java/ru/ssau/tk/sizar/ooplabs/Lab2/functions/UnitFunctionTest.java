package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitFunctionTest {
    @Test
    void testApply(){
        ConstantFunction function = new UnitFunction();
        Assertions.assertEquals(1, function.apply(0.0));
        Assertions.assertEquals(1, function.apply(-1.0));
        Assertions.assertEquals(1, function.apply(Double.POSITIVE_INFINITY));
        Assertions.assertEquals(1, function.apply(Double.NEGATIVE_INFINITY));
    }
}