package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("output/serialized linked list functions.bin");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {
            double[] xValues = {0, 1, 2, 3, 4, 5, 6};
            double[] yValues = {0, 1, 2, 3, 4, 5, 6};
            TabulatedFunction function1 = new LinkedListTabulatedFunction(xValues,yValues);
            TabulatedFunction function2 = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory()).derive(function1);
            TabulatedFunction function3 = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory()).derive(function2);

            FunctionsIO.serialize(bufferedOutputStream, function1);
            FunctionsIO.serialize(bufferedOutputStream, function2);
            FunctionsIO.serialize(bufferedOutputStream, function3);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("output/serialized linked list functions.bin");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);){
            TabulatedFunction function1 = FunctionsIO.deserialize(bufferedInputStream);
            System.out.println(function1.toString());
            TabulatedFunction function2 = FunctionsIO.deserialize(bufferedInputStream);
            System.out.println(function2.toString());
            TabulatedFunction function3 = FunctionsIO.deserialize(bufferedInputStream);
            System.out.println(function3.toString());
        } catch (IOException |  ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
