package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

public class DeBoorFunction implements MathFunction{
    public double apply(int k, int degree, int i, double x, double[] knots, double[] Points){
        if (k==0){
            return Points[i];
        }
        else
        {
            double alpha = (x-knots[i]) / (knots[i+degree+1-k]-knots[i]);
            return (this.apply(k-1,degree,i-1, x, knots, Points)*(1-alpha)+this.apply(k-1,degree, i, x, knots, Points)*alpha);
        }
    }

    @Override
    public double apply(double x) {
        return 0;
    }
}