package ru.ssau.tk.sizar.ooplabs.Lab2.concurrent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.Point;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {
    TabulatedFunction tabulatedFunctionLL;
    TabulatedFunction tabulatedFunctionA;
    SynchronizedTabulatedFunction synchronizedTabulatedFunctionLL;
    SynchronizedTabulatedFunction synchronizedTabulatedFunctionA;
    double[] xValues = {1.42, 2.69, 3.52, 4.20};
    double[] yValues = {1.24, 2.96, 3.52, 4.02};
    @BeforeEach
    void beforeEach(){
        tabulatedFunctionLL = new LinkedListTabulatedFunction(xValues, yValues);
        tabulatedFunctionA = new ArrayTabulatedFunction(xValues, yValues);
        synchronizedTabulatedFunctionLL = new SynchronizedTabulatedFunction(tabulatedFunctionLL);
        synchronizedTabulatedFunctionA = new SynchronizedTabulatedFunction(tabulatedFunctionA);
    }
    @Test
    void iteratorTestA() {
        Iterator<Point> iterator = synchronizedTabulatedFunctionA.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1.42, iterator.next().x);
        assertEquals(2.96, iterator.next().y);
        assertEquals(3.52, iterator.next().x);
        assertEquals(4.02, iterator.next().y);
        assertFalse(iterator.hasNext());

    }

    @Test
    void iteratorTestLL() {
        Iterator<Point> iterator = synchronizedTabulatedFunctionLL.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1.42, iterator.next().x);
        assertEquals(2.96, iterator.next().y);
        assertEquals(3.52, iterator.next().x);
        assertEquals(4.02, iterator.next().y);
        assertFalse(iterator.hasNext());
    }

    @Test
    void getCountTest() {
        assertEquals(4, synchronizedTabulatedFunctionA.getCount());
        assertEquals(4, synchronizedTabulatedFunctionLL.getCount());
    }

    @Test
    void getXTest() {
        assertEquals(1.42, synchronizedTabulatedFunctionA.getX(0));
        assertEquals(2.69, synchronizedTabulatedFunctionA.getX(1));
        assertEquals(3.52, synchronizedTabulatedFunctionA.getX(2));
        assertEquals(4.20, synchronizedTabulatedFunctionA.getX(3));
    }

    @Test
    void getYTest() {
        assertEquals(1.24, synchronizedTabulatedFunctionA.getY(0));
        assertEquals(2.96, synchronizedTabulatedFunctionA.getY(1));
        assertEquals(3.52, synchronizedTabulatedFunctionA.getY(2));
        assertEquals(4.02, synchronizedTabulatedFunctionA.getY(3));
    }

    @Test
    void setYTest() {
        synchronizedTabulatedFunctionA.setY(0, 8800);
        synchronizedTabulatedFunctionA.setY(1, 555);
        synchronizedTabulatedFunctionA.setY(2, 35);
        synchronizedTabulatedFunctionA.setY(3, 35);
        assertEquals(8800, synchronizedTabulatedFunctionA.getY(0));
        assertEquals(555, synchronizedTabulatedFunctionA.getY(1));
        assertEquals(35, synchronizedTabulatedFunctionA.getY(2));
        assertEquals(35, synchronizedTabulatedFunctionA.getY(3));
    }

    @Test
    void setXTest() {
        synchronizedTabulatedFunctionA.setX(0, 8800);
        synchronizedTabulatedFunctionA.setX(1, 555);
        synchronizedTabulatedFunctionA.setX(2, 35);
        synchronizedTabulatedFunctionA.setX(3, 35);
        assertEquals(8800, synchronizedTabulatedFunctionA.getX(0));
        assertEquals(555, synchronizedTabulatedFunctionA.getX(1));
        assertEquals(35, synchronizedTabulatedFunctionA.getX(2));
        assertEquals(35, synchronizedTabulatedFunctionA.getX(3));
    }

    @Test
    void indexOfXTest() {
        assertEquals(0, synchronizedTabulatedFunctionA.indexOfX(1.42));
        assertEquals(1, synchronizedTabulatedFunctionA.indexOfX(2.69));
        assertEquals(2, synchronizedTabulatedFunctionA.indexOfX(3.52));
        assertEquals(3, synchronizedTabulatedFunctionA.indexOfX(4.20));
        assertEquals(0, synchronizedTabulatedFunctionLL.indexOfX(1.42));
        assertEquals(1, synchronizedTabulatedFunctionLL.indexOfX(2.69));
        assertEquals(2, synchronizedTabulatedFunctionLL.indexOfX(3.52));
        assertEquals(3, synchronizedTabulatedFunctionLL.indexOfX(4.20));
    }

    @Test
    void indexOfYTest() {
        assertEquals(0, synchronizedTabulatedFunctionA.indexOfY(1.24));
        assertEquals(1, synchronizedTabulatedFunctionA.indexOfY(2.96));
        assertEquals(2, synchronizedTabulatedFunctionA.indexOfY(3.52));
        assertEquals(3, synchronizedTabulatedFunctionA.indexOfY(4.02));
        assertEquals(0, synchronizedTabulatedFunctionLL.indexOfY(1.24));
        assertEquals(1, synchronizedTabulatedFunctionLL.indexOfY(2.96));
        assertEquals(2, synchronizedTabulatedFunctionLL.indexOfY(3.52));
        assertEquals(3, synchronizedTabulatedFunctionLL.indexOfY(4.02));
    }

    @Test
    void leftBoundTest() {
        assertEquals(1.42, synchronizedTabulatedFunctionLL.leftBound());
        assertEquals(1.42, synchronizedTabulatedFunctionA.leftBound());
    }

    @Test
    void rightBoundTest() {
        assertEquals(4.20, synchronizedTabulatedFunctionLL.rightBound());
        assertEquals(4.20, synchronizedTabulatedFunctionA.rightBound());
    }

    @Test
    void applyTest() {
        assertEquals(1.24, synchronizedTabulatedFunctionA.apply(1.42), 0.001);
        assertEquals(2.96, synchronizedTabulatedFunctionA.apply(2.69), 0.001);
        assertEquals(3.52, synchronizedTabulatedFunctionA.apply(3.52), 0.001);
        assertEquals(4.02, synchronizedTabulatedFunctionA.apply(4.20), 0.001);
    }
}