package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AndThenTest {
    @Test
    void testAndThen(){
        MathFunction firstFunction = new IdentityFunction();
        MathFunction secondFunction = new SqrFunction();
        double result= firstFunction.andThen(secondFunction).apply(8);
        Assertions.assertEquals(64, result);
    }
    @Test
    void testAndThen2(){
        MathFunction firstFunction = new IdentityFunction();
        MathFunction secondFunction = new SqrFunction();
        double result= firstFunction.andThen(secondFunction).andThen(secondFunction).apply(8);
        Assertions.assertEquals(4096, result);
    }

}