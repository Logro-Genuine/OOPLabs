package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.MathFunction;

public abstract class SteppingDifferentialOperator implements DifferentialOperator<MathFunction>{
    protected double step;
    SteppingDifferentialOperator(double step){
        if ((step <= 0) || Double.isInfinite(step) || Double.isNaN(step)){throw new IllegalArgumentException();}
        this.step = step;}

    public void setStep(double step) {
        if ((step <= 0) || Double.isInfinite(step) || Double.isNaN(step)){throw new IllegalArgumentException();}
        this.step = step;
    }

    public double getStep() {
        return step;
    }

    @Override
    public abstract MathFunction derive(MathFunction function);

    @Override
    public double apply(double x) {
        throw new UnsupportedOperationException();
    }
}
