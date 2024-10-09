package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

public class DeBoorFunction implements MathFunction{
    double[] nodes;
    double[] controlPoints;
    int index; //k
    int splineDegree; //p
    DeBoorFunction (double[] nodes, double[] controlPoints, int index, int splineDegree){
        this.nodes = nodes;
        this.controlPoints = controlPoints;
        this.index = index;
        this.splineDegree = splineDegree;
    }
    @Override
    public double apply(double x){ //x в данном случае - точка, для которой нужно вычислить B-сплайн
        double[] d = new double[splineDegree+1];
        double alpha = 0;
        System.arraycopy(controlPoints, index - splineDegree, d, 0, splineDegree + 1);
        for (int i = 1; i <= splineDegree; i++){
            for (int j = splineDegree; j >= i; j--){
                alpha = (x - nodes[j + index - splineDegree]) /
                        (nodes[j + 1 + index - i] - nodes[j + index - splineDegree]);
                d[j] = (1.0 - alpha) * d[j-1] + alpha * d[j];
            }
        }
        return d[splineDegree];
    }
}