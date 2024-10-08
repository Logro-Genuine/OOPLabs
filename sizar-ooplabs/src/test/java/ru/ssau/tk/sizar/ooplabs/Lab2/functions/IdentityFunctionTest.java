package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IdentityFunctionTest {
    @Test
    void testApply() {
        IdentityFunction function = new IdentityFunction();
        Assertions.assertEquals(0.0, function.apply(0.0));
        Assertions.assertEquals(-1.0, function.apply(-1.0));
        Assertions.assertEquals(Double.POSITIVE_INFINITY, function.apply(Double.POSITIVE_INFINITY));
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, function.apply(Double.NEGATIVE_INFINITY));
    }
}
