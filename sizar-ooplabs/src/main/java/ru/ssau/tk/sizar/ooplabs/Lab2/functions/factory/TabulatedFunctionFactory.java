package ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
}
