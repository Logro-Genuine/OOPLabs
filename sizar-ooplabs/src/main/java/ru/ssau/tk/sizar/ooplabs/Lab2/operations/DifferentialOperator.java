package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;

public interface DifferentialOperator<T> extends MathFunction {
    T derive(T function);
}
