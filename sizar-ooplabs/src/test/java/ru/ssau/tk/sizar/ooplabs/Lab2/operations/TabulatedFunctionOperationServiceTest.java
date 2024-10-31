package ru.ssau.tk.sizar.ooplabs.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.Point;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionOperationServiceTest {
    ArrayTabulatedFunctionFactory arrayTabulatedFunctionFactory = new ArrayTabulatedFunctionFactory();
    LinkedListTabulatedFunctionFactory listTabulatedFunctionFactory = new LinkedListTabulatedFunctionFactory();
    TabulatedFunctionOperationService service = new TabulatedFunctionOperationService();

    double[] x1 = {1, 2, 3, 4, 5};
    double[] y1 = {1, 2, 3, 4, 5};

    double[] x2 = {1, 2, 3, 4, 5};
    double[] y2 = {2, 4, 6, 8, 10};
    @Test
    void asPointsTest() {
        double[] x = {1, 2, 5, 10 ,11};
        double[] y = {-4, 2, 3, 4, 4};
        TabulatedFunction func = listTabulatedFunctionFactory.create(x,y);
        Point[] points = TabulatedFunctionOperationService.asPoints(func);

        int i = 0;
        for (Point point : func) {
            System.out.println(point.x + " " + point.y);
            assertEquals(points[i].x,point.x);
            assertEquals(points[i].y,point.y);
            ++i;
        }
    }

    @Test
    void additionTest() {
        TabulatedFunction func1 = arrayTabulatedFunctionFactory.create(x1,y1);
        TabulatedFunction func2 = listTabulatedFunctionFactory.create(x2,y2);

        TabulatedFunction func3  = service.addition(func1,func2);
        int i = 0;
        for (Point point : func3){
            assertEquals(y1[i]+y2[i],point.y);
            i++;
        }
    }

    @Test
    void subtractionTest() {
        TabulatedFunction func1 = arrayTabulatedFunctionFactory.create(x1,y1);
        TabulatedFunction func2 = listTabulatedFunctionFactory.create(x2,y2);

        TabulatedFunction func3  = service.subtraction(func1,func2);
        int i = 0;
        for (Point point : func3){
            assertEquals(y1[i]-y2[i],point.y);
            i++;
        }
    }

    @Test
    void multiplicationTest() {
        TabulatedFunction func1 = arrayTabulatedFunctionFactory.create(x1,y1);
        TabulatedFunction func2 = arrayTabulatedFunctionFactory.create(x2,y2);

        TabulatedFunction func3  = service.multiplication(func1,func2);
        int i = 0;
        for (Point point : func3){
            assertEquals(y1[i]*y2[i],point.y);
            i++;
        }
    }

    @Test
    void divisionTest() {
        TabulatedFunction func1 = listTabulatedFunctionFactory.create(x1,y1);
        TabulatedFunction func2 = arrayTabulatedFunctionFactory.create(x2,y2);

        TabulatedFunction func3  = service.division(func1,func2);
        int i = 0;
        for (Point point : func3){
            assertEquals(y1[i]/y2[i],point.y);
            i++;
        }
    }
}