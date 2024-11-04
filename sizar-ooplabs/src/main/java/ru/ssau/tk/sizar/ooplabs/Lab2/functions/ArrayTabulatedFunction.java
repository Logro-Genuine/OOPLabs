package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.InterpolationException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Insertable, Removable, Serializable {
    @Serial
    private static final long serialVersionUID = 982843010366960187L;

    double[] xValues;
    double[] yValues;


    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        count = xValues.length;
        checkLengthIsTheSame(xValues, yValues);
        if (xValues.length < 2){throw new IllegalArgumentException("Длина меньше минимальной!");}
        checkSorted(xValues);
        this.xValues = Arrays.copyOf(xValues, xValues.length);
        this.yValues = Arrays.copyOf(yValues, yValues.length);
    }

    ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count){
        if (count < 2){throw new IllegalArgumentException();}
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        this.count = count;
        xValues = new double[count];
        yValues = new double[count];

        xValues[0] = xFrom;
        xValues[count - 1] = xTo;

        if (xFrom == xTo) {
            for (int i = 0; i < count; i++) {
                xValues[i] = xFrom;
                yValues[i] = source.apply(xFrom);
            }
            return;
        }
        double step = (xTo - xFrom) / (count - 1);

        for (int i = 0; i < count; i++) {
            xValues[i] = xFrom + i * step;
            yValues[i] = source.apply(xValues[i]);
        }

    }

    // Метод получения количества табулированных значений:
    @Override
    public int getCount() {
        return count;
    }

    //Метод, получающий значение аргумента x по номеру индекса:
    @Override
    public double getX(int index) {
        return xValues[index];
    }

    //Метод, получающий значение аргумента y по номеру индекса:
    @Override
    public double getY(int index) {
        return yValues[index];
    }
    //Метод, задающий значение y по номеру индекса:
    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public void setX(int index, double value) { xValues[index] = value; }

    //Метод, возвращающий индекс первого вхождения аргумента x
    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //Метод, возвращающий индекс первого вхождения значения y
    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }

    //Метод, возвращающий самый левый x:
    @Override
    public double leftBound() {
        return xValues[0];
    }

    //Метод, возвращающий самый правый x:
    @Override
    public double rightBound() {
        return xValues[count - 1];
    }

    // Метод поиска индекса x
    @Override
    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            throw new IllegalArgumentException("Значение меньше левой границы");
        }
        if (x == xValues[count - 1]) {
            return count - 1;
        }
        for (int i = 0; i < count - 1; i++) {
            if (x < xValues[i + 1]) {
                return i;
            }
        }
        return count;
    }
    // Метод экстраполяции слева
    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }
    // Метод экстраполяции справа
    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, xValues[count - 2], xValues[count - 1], yValues[count - 2], yValues[count - 1]);
    }
    // Интерполяция
    @Override
    protected double interpolate(double x, int floorIndex) {
        if (x < xValues[floorIndex] || x > xValues[floorIndex+1]){throw new InterpolationException();}
        return interpolate(x, xValues[floorIndex], xValues[floorIndex + 1],yValues[floorIndex],yValues[floorIndex + 1]);
    }

    @Override
    public void insert(double x, double y) {
        for (int i = 0; i<count; ++i){
            if (xValues[i] == x){
                yValues[i] = y;
                return;
            }
            if (xValues[i]>x){
                //вставить элемент вот так Values[:i]+[x|y]+Values[i:]
                double[] newValuesX = new double[count+1];
                double[] newValuesY = new double[count+1];
                System.arraycopy(xValues,0, newValuesX,0, i);
                System.arraycopy(yValues,0, newValuesY,0, i);
                newValuesX[i] = x;
                newValuesY[i] = y;
                System.arraycopy(xValues, i, newValuesX,i+1, count-i);
                System.arraycopy(yValues, i, newValuesY,i+1, count-i);
                xValues = newValuesX;
                yValues = newValuesY;
                ++count;
                return;
            }
        }

        double[] newValuesX = new double[count+1];
        double[] newValuesY = new double[count+1];
        System.arraycopy(xValues,0, newValuesX,0, count);
        System.arraycopy(yValues,0, newValuesY,0, count);
        newValuesX[count] = x;
        newValuesY[count] = y;
        xValues = newValuesX;
        yValues = newValuesY;
        ++count;
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет больше элементов для итерации.");
                }
                Point point = new Point(xValues[index], yValues[index]);
                ++index;
                return point;
            }
        };
    }

    public void remove(int index) {
        double[] tempXValues = new double[count - 1];
        double[] tempYValues = new double[count - 1];
        // копируем в новый массив всё до index
        System.arraycopy(xValues, 0, tempXValues, 0, index);
        System.arraycopy(yValues, 0, tempYValues, 0, index);
        // копируем в новый массив всё после index
        System.arraycopy(xValues, index + 1, tempXValues, index, count - index - 1);
        System.arraycopy(yValues, index + 1, tempYValues, index, count - index - 1);
        this.xValues = tempXValues;
        this.yValues = tempYValues;
        --count;
    }
}
