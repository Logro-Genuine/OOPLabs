package ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

import java.util.Arrays;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory{
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        double[] xValuesCopy = Arrays.copyOf(xValues, xValues.length);
        double[] yValuesCopy = Arrays.copyOf(yValues, yValues.length);
        return new LinkedListTabulatedFunction(xValuesCopy, yValuesCopy);
    }
}
