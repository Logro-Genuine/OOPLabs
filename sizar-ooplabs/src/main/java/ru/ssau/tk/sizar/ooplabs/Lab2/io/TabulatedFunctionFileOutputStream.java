package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;


public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3, 4, 5};
        double[] yValues = {1.5, 32.4, 56.2, 23, 1};
        try (FileOutputStream fileOutput1 = new FileOutputStream("output/array function.bin");
             FileOutputStream fileOutput2 = new FileOutputStream("output/linked list function.bin");
             BufferedOutputStream bufferedOutput1 = new BufferedOutputStream(fileOutput1);
             BufferedOutputStream bufferedOutput2 = new BufferedOutputStream(fileOutput2);) {
            FunctionsIO.writeTabulatedFunction(bufferedOutput1, new ArrayTabulatedFunction(xValues, yValues));
            FunctionsIO.writeTabulatedFunction(bufferedOutput2, new LinkedListTabulatedFunction(xValues,yValues));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
