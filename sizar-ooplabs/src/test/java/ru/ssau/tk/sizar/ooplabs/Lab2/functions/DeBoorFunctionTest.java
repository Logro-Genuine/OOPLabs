package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeBoorFunctionTest {
    @Test
    void applyTest1() {
        double[] nodes = {3, 3, 3, 3, 4, 5, 6, 7, 7, 7, 7};
        double[] controlPoints = {1, 2, 3, 4, 5, 6, 7};
        int splineDegree = 3;
        int index = 6;
        MathFunction deBoorFunction = new DeBoorFunction(nodes, controlPoints, index, splineDegree);
        double x = 6.5;
        double result = deBoorFunction.apply(x);
        assertEquals(5.822916, result, 0.000001);
    }
    @Test
    void applyTest2(){
        double[] nodes = {5, 5, 5, 5, 10, 15, 20, 25, 25, 25, 25};
        double[] controlPoints = { 9, 8, 7, 6, 5, 6, 7};
        int splineDegree = 3;
        int index = 5;
        MathFunction deBoorFunction = new DeBoorFunction(nodes, controlPoints, index, splineDegree);
        double x = 17;
        double result = deBoorFunction.apply(x);
        assertEquals(5.626666, result, 0.000001);
    }
    @Test
    void applyTest3(){
        double[] nodes = {1, 1, 1, 1, 10, 100, 1000, 10000, 10000, 10000, 10000};
        double[] controlPoints = {3, 4, 5, 5, 4, 3, 2};
        int splineDegree = 3;
        int index = 4;
        MathFunction deBoorFunction = new DeBoorFunction(nodes, controlPoints, index, splineDegree);
        double x = 25;
        double result = deBoorFunction.apply(x);
        assertEquals(4.521728, result, 0.000001);
    }
}
