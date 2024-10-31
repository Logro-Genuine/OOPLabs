package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;

public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator{
    RightSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction function) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (function.apply(x + step) - function.apply(x)) / step;
            }
        };
    }
}
