package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;

import static org.junit.jupiter.api.Assertions.*;

class RightSteppingDifferentialOperatorTest {
    RightSteppingDifferentialOperator operator;
    final double step = 0.0001;
    @Test
    void deriveTest1() {
        operator = new RightSteppingDifferentialOperator(step);
        MathFunction constantFunction = x -> 5;
        MathFunction derivative = operator.derive(constantFunction);
        assertEquals(0, derivative.apply(1), 0.1);
    }

    @Test
    void deriveTest2() {
        operator = new RightSteppingDifferentialOperator(step);
        MathFunction constantFunction = x -> x*x;
        MathFunction derivative = operator.derive(constantFunction);
        assertEquals(-4, derivative.apply(-2), 0.1);
    }

    @Test
    void deriveTest3() {
        operator = new RightSteppingDifferentialOperator(step);
        MathFunction constantFunction = x -> 2*x-3*x*x;
        MathFunction derivative = operator.derive(constantFunction);
        assertEquals(-28, derivative.apply(5), 0.1);
    }
}