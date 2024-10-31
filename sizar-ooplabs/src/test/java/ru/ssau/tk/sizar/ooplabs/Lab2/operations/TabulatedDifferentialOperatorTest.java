package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedDifferentialOperatorTest {

    TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();
    double[] xValues = {1.0, 2.0, 3.0};
    double[] yValues = {2.0, 4.0, 6.0};
    ArrayTabulatedFunctionFactory arrayTabulatedFunctionFactory = new ArrayTabulatedFunctionFactory();
    LinkedListTabulatedFunctionFactory listTabulatedFunctionFactory = new LinkedListTabulatedFunctionFactory();
    @Test
    public void testDerive1() {
        TabulatedFunction function = arrayTabulatedFunctionFactory.create(xValues, yValues);
        TabulatedFunction derivative = operator.derive(function);
        assertEquals(2.0, derivative.getY(0), 0.001);
        assertEquals(2.0, derivative.getY(1), 0.001);
    }

    @Test
    public void testDerive2() {
        TabulatedFunction function = listTabulatedFunctionFactory.create(xValues, yValues);
        TabulatedFunction derivative = operator.derive(function);
        assertEquals(2.0, derivative.getY(0), 0.001);
        assertEquals(2.0, derivative.getY(1), 0.001);
    }
}