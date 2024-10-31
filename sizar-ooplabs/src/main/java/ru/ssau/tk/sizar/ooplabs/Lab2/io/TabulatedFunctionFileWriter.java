package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3, 4, 5};
        double[] yValues = {1.5, 32.4, 56.2, 23, 1};
        try (FileWriter fileWriter1 = new FileWriter("output/array function.txt");
             FileWriter fileWriter2 = new FileWriter("output/linked list function.txt");
             BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
             BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);) {
            FunctionsIO.writeTabulatedFunction(bufferedWriter1, new ArrayTabulatedFunction(xValues, yValues));
            FunctionsIO.writeTabulatedFunction(bufferedWriter2, new LinkedListTabulatedFunction(xValues,yValues));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
