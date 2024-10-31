package ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

class LinkedListTabulatedFunctionFactoryTest {

    @Test
    void createTest() {
        double[] x = {1, 2, 5, 10 ,11};
        double[] y = {-4, 2, 3, 4, 4};

        Assertions.assertInstanceOf(LinkedListTabulatedFunction.class, new LinkedListTabulatedFunctionFactory().create(x, y));
    }
}