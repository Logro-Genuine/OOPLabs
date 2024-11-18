package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.TabulatedFunctionFactory;

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

    @Test
    void testGetFactoryTest() {
        LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator(factory);
        assertEquals(factory, operator.getFactory());
    }

    @Test
    void testSetFactory() {
        LinkedListTabulatedFunctionFactory factory1 = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator(factory1);
        TabulatedFunctionFactory factory2 = new ArrayTabulatedFunctionFactory();
        operator.setFactory(factory2);
        assertEquals(factory2, operator.getFactory());
    }

    @Test
    void testDeriveSynchronouslyForLinearFunction() {
        double[] xValues = {1.0, 2.0, 3.0, 4.0};
        double[] yValues = {2.0, 4.0, 6.0, 8.0};

        TabulatedFunction linearFunction = new ArrayTabulatedFunctionFactory().create(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());

        TabulatedFunction derivedFunction = differentialOperator.deriveSynchronously(linearFunction);

        for (int i = 0; i < derivedFunction.getCount(); i++) {
            assertEquals(2.0, derivedFunction.getY(i), 1e-9);
        }
    }

}