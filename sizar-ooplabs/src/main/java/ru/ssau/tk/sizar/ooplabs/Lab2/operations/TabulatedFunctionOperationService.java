package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.InconsistentFunctionsException;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.Point;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.TabulatedFunctionFactory;

public class TabulatedFunctionOperationService {
    TabulatedFunctionFactory factory;
    TabulatedFunctionOperationService(TabulatedFunctionFactory factory){
        this.factory = factory;
    }
    TabulatedFunctionOperationService(){
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        Point[] points = new Point[tabulatedFunction.getCount()];
        int i = 0;

        for (Point point : tabulatedFunction) {
            points[i] = point;
            ++i;
        }

        return points;
    }

    private interface BiOperation{
        double apply(double u, double v);
    }


    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation){
        if (a.getCount() != b.getCount()){ throw new DifferentLengthOfArraysException();}
        TabulatedFunction newFunc;
        Point[] ap = asPoints(a);
        Point[] bp = asPoints(b);
        int length = a.getCount();
        double[] xValues = new double[length];
        double[] yValues = new double[length];
        for (int k = 0; k < a.getCount(); k++) {
            if (ap[k].x != bp[k].x) {
                throw new InconsistentFunctionsException();
            }
            xValues[k] = ap[k].x;
            yValues[k] = operation.apply(ap[k].y, bp[k].y);
        }
        return factory.create(xValues, yValues);
    }
    public TabulatedFunction addition(TabulatedFunction a, TabulatedFunction b) {return doOperation(a, b, (u, v) -> u + v);}
    public TabulatedFunction subtraction(TabulatedFunction a, TabulatedFunction b) {return doOperation(a, b, (u, v) -> u - v);}
    public TabulatedFunction multiplication(TabulatedFunction a, TabulatedFunction b) {return doOperation(a, b, (u, v) -> u * v);}
    public TabulatedFunction division(TabulatedFunction a, TabulatedFunction b) {return doOperation(a, b, (u, v) -> u / v);}
}
