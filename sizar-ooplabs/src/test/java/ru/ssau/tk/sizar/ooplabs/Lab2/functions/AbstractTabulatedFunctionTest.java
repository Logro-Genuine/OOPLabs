package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.DifferentLengthOfArraysException;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTabulatedFunctionTest {

    @Test
    public void testCheckLengthIsTheSame_DifferentLengths() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0};
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
        });
    }

    @Test
    public void testCheckLengthIsTheSame_SameLengths() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0};
        AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
    }

    @Test
    public void testCheckSorted_NotSorted() {
        double[] xValues = {1.0, 3.0, 2.0};
        assertThrows(ArrayIsNotSortedException.class, () -> {
            AbstractTabulatedFunction.checkSorted(xValues);
        });
    }

    @Test
    public void testCheckSorted_Sorted() {
        double[] xValues = {1.0, 2.0, 3.0};
        AbstractTabulatedFunction.checkSorted(xValues);
    }

    @Test
    public void testCheckSorted_EqualValues() {
        double[] xValues = {1.0, 1.0, 1.0};
        AbstractTabulatedFunction.checkSorted(xValues);
    }

    @Test
    void testToString() {
        double[] x = {0, 1, 2, 3};
        double[] y = {1, 2, 3, 5};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(x,y);
        System.out.println(function.toString());
    }
}