package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

public class ConstantFunction implements MathFunction{

    private final double constNum;

    public ConstantFunction(double constNum) {
        this.constNum = constNum;
    }

    public double apply(double x) {
        return constNum;
    }
}
