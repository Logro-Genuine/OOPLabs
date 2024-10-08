package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantFunctionTest {
    @Test
    void testApply(){
        MathFunction function = new ConstantFunction(4.3);
        Assertions.assertEquals(4.3, function.apply(0.0));
        Assertions.assertEquals(4.3, function.apply(Double.POSITIVE_INFINITY));
        Assertions.assertEquals(4.3, function.apply(Double.NEGATIVE_INFINITY));

    }

}