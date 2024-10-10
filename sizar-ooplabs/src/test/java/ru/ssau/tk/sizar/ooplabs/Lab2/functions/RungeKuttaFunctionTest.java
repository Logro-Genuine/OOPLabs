package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RungeKuttaFunctionTest {
    @Test
    void testRungeKuttaMethodTest() {

        SqrFunction sqr = new SqrFunction();

        RungeKuttaFunction f = new RungeKuttaFunction((x, y) -> x * y, 0, 1);
        assertEquals(1.645833333, f.apply(1.0), 0.00001);

    }
}