package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction{
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
}
