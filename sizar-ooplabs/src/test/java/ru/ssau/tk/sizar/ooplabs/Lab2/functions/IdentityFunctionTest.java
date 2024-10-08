package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentityFunctionTest {
    void testApply() {
        IdentityFunction function = new IdentityFunction();
        if (0.0 == function.apply(0.0)){
            System.out.println("Test 1 passed");
        }
        if (1.0 == function.apply(1.0)){
            System.out.println("Test 2 passed");
        }
        if (-1.0 == function.apply(-1.0)){
            System.out.println("Test 3 passed");
        }
        if (Double.POSITIVE_INFINITY == function.apply(Double.POSITIVE_INFINITY)){
            System.out.println("Test 4 passed");
        }
        if (Double.NEGATIVE_INFINITY == function.apply(Double.NEGATIVE_INFINITY)){
            System.out.println("Test 5 passed");
        }
        if (Double.NaN == function.apply(Double.NaN)){
            System.out.println("Test 6 passed");
        }
    }
}
