package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.DifferentLengthOfArraysException;

public abstract class AbstractTabulatedFunction implements TabulatedFunction{
    static void checkLengthIsTheSame(double[] xValues, double[] yValues){
        if (xValues.length != yValues.length){ throw new DifferentLengthOfArraysException();}
    }
    static void checkSorted(double[] xValues){
        for (int i = 1; i < xValues.length; i++)
        {
            if (xValues[i] < xValues[i-1]){ throw new ArrayIsNotSortedException();}
        }
    }
    protected int count;
    // Метод поиска индекса x
    protected abstract int floorIndexOfX(double x);
    // Метод экстраполяции слева
    protected abstract double extrapolateLeft(double x);
    // Метод экстраполяции справа
    protected abstract double extrapolateRight(double x);
    // Метод интерполяции с указанием индекса интервала
    protected abstract double interpolate(double x, int floorIndex);
    // Интерполяция
    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY){
        return leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX);
    }

    @Override
    public double apply(double x){
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else {
            int index = indexOfX(x);
            if (index != -1) {
                return getY(index);
            } else {
                int floorIndex = floorIndexOfX(x);
                return interpolate(x, floorIndex);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append(" size = ").append(getCount()).append("\n");
        double lastX = this.getX(getCount()-1);
        for (Point point : this) {
            builder.append("[").append(point.x).append("; ").append(point.y).append("]");
            if (point.x != lastX){
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
