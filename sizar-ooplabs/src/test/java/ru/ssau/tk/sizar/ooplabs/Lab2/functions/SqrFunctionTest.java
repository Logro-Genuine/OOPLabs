package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SqrFunctionTest {
    @Test
    void testApply() {
        SqrFunction function = new SqrFunction();
        Assertions.assertEquals(0.0, function.apply(0.0), 0000.1);
        Assertions.assertEquals(1.0, function.apply(-1.0), 0000.1);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, function.apply(Double.POSITIVE_INFINITY));
        Assertions.assertEquals(Double.POSITIVE_INFINITY, function.apply(Double.NEGATIVE_INFINITY));
    }
}