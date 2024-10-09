package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ZeroFunctionTest {
    @Test
    void testApply(){
        ConstantFunction function = new ZeroFunction();
        Assertions.assertEquals(0, function.apply(0.0));
        Assertions.assertEquals(0, function.apply(-1.0));
        Assertions.assertEquals(0, function.apply(Double.POSITIVE_INFINITY));
        Assertions.assertEquals(0, function.apply(Double.NEGATIVE_INFINITY));
    }
}