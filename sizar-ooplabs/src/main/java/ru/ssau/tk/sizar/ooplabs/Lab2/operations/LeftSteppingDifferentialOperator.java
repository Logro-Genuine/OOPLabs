package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;

public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator{
    LeftSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction function) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (function.apply(x) - function.apply(x - step)) / step;
            }
        };
    }
}
