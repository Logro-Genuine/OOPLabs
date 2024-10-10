package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTabulatedFunctionTest {
    @Test
    void floorIndexOfX() {
        double[] x = {1, 1.5, 2.5, 10, 11};
        double[] y = {2, 2, 3, 4, -5};
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x,y);
        Assertions.assertEquals(2, test.floorIndexOfX(3.1));
    }

    @Test
    void extrapolateLeft() {
        double[] x = {1, 2, 2.5, 10, 11};
        double[] y = {2, 4, 3, 4,-5};
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x,y);
        Assertions.assertEquals(-2, test.extrapolateLeft(-1));
    }

    @Test
    void extrapolateRight() {
        double[] x = {0, 1, 2, 3, 4, 5};
        double[] y = {0, 2, 1, 2, 16, 20};
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x,y);
        Assertions.assertEquals(24, test.extrapolateRight(6));
    }

    @Test
    void interpolate() {
        double[] x = {1, 2, 5, 10 ,11};
        double[] y = {2, 4, 3, 4, -4};
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x,y);
        Assertions.assertEquals(3, test.interpolate(5,test.floorIndexOfX(5)));
    }

    @Test
    void getCount() {
        MathFunction func = new SqrFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,10,10);
        Assertions.assertEquals(10, test.getCount());
    }

    @Test
    void getX() {
        MathFunction func = new SqrFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,10);
        Assertions.assertEquals(5, test.getX(9), 0.001);
    }

    @Test
    void getY() {
        MathFunction func = new SqrFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,9);
        Assertions.assertEquals(25, test.getY(8));
    }

    @Test
    void setY() {
        MathFunction func = new SqrFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,9);
        test.setY(2,10);
        Assertions.assertEquals(10, test.getY(2));
    }

    @Test
    void indexOfX() {
        double[] x = {1, 1.5, 2.5, 10, 11};
        double[] y = {2, 2, 3, 4,-5};
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x,y);
        Assertions.assertEquals(1, test.indexOfX(1.5));
    }

    @Test
    void indexOfY() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);
        Assertions.assertEquals(1, test.indexOfY(1));
    }

    @Test
    void leftBound() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,5);
        Assertions.assertEquals(0, test.leftBound());
    }

    @Test
    void rightBound() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,5);
        Assertions.assertEquals(5, test.rightBound());
    }

    @Test
    void insert1() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);
        test.insert(2.5, 22222);
        Assertions.assertEquals(22222, test.getY(3));
    }
    @Test
    void insert2() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);
        test.insert(-1, 22222);
        Assertions.assertEquals(-1, test.getX(0));
    }
    @Test
    void insert3() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);
        test.insert(6, 22222);
        Assertions.assertEquals(22222, test.getY(6));
    }
    @Test
    void insert4() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);
        test.insert(5, 22222);
        Assertions.assertEquals(22222, test.getY(5));
    }
    @Test
    void insert5() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);

        int oldCount = test.getCount();

        test.insert(2.5, 22222);

        Assertions.assertEquals(oldCount+1, test.getCount());
    }
    @Test
    void insert6() {
        MathFunction func = new IdentityFunction();
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(func,0,5,6);

        int oldCount = test.getCount();

        test.insert(5, 22222);//x=5 существует

        Assertions.assertEquals(oldCount, test.getCount());
    }

    @Test
    void remove1() {
        double[] x = {1, 2, 5, 10 ,11};
        double[] y = {2, 4, 3, 4, -4};
        int index = 2;
        ArrayTabulatedFunction test = new ArrayTabulatedFunction(x, y);
        double removed_obj = test.getX(index+1);
        test.remove(index);
        Assertions.assertEquals(removed_obj, test.getX(index));
    }
}