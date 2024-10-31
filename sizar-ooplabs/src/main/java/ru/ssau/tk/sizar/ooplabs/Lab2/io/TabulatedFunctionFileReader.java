package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try (FileReader fileReader1 = new FileReader("input/function.txt");
             FileReader fileReader2 = new FileReader("input/function.txt");
             BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
             BufferedReader bufferedReader2 = new BufferedReader(fileReader2);) {
            TabulatedFunction tabulatedFunction1 = FunctionsIO.readTabulatedFunction(bufferedReader1, new ArrayTabulatedFunctionFactory());
            TabulatedFunction tabulatedFunction2 = FunctionsIO.readTabulatedFunction(bufferedReader2, new LinkedListTabulatedFunctionFactory());

            System.out.println(tabulatedFunction1);
            System.out.println(tabulatedFunction2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
