package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.Point;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction>{
    TabulatedFunctionFactory factory;
    TabulatedDifferentialOperator(TabulatedFunctionFactory factory){
        this.factory = factory;
    }
    TabulatedDifferentialOperator(){
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        int length = points.length;
        double[] xValues = new double[length-1];
        double[] yValues = new double[length-1];
        for (int k = 0; k < (length-1); k++){
            xValues[k] = points[k].x;
            yValues[k] = (points[k+1].y-points[k].y)/(points[k+1].x-points[k].x);
        }
        return factory.create(xValues, yValues);
    }

    @Override
    public double apply(double x) {
        throw new UnsupportedOperationException();
    }
}
