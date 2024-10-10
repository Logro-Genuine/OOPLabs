package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {
    @Test
    void testApply(){
        MathFunction firstFunction = new IdentityFunction();
        MathFunction secondFunction = new SqrFunction();
        CompositeFunction compositeFunction = new CompositeFunction(firstFunction, secondFunction);

        CompositeFunction doubleCompositeFunction = new CompositeFunction(compositeFunction, secondFunction);
        Assertions.assertEquals(4096, doubleCompositeFunction.apply(8));
        Assertions.assertEquals(0, doubleCompositeFunction.apply(0));
    }
}