package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.sizar.ooplabs.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream1 = new FileInputStream("input/binary function.bin");
             BufferedInputStream bufferedInputStream1 = new BufferedInputStream(fileInputStream1);){
            TabulatedFunction tabulatedFunction = FunctionsIO.readTabulatedFunction(bufferedInputStream1, new ArrayTabulatedFunctionFactory());
            System.out.println(tabulatedFunction.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Введите размер и значения функции: ");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedInputStream = new BufferedReader(inputStreamReader);
            TabulatedFunction tabulatedFunction = FunctionsIO.readTabulatedFunction(bufferedInputStream, new LinkedListTabulatedFunctionFactory());
            System.out.println(new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory()).derive(tabulatedFunction).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
