package ru.ssau.tk.sizar.ooplabs.Lab2.io;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.Point;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.factory.TabulatedFunctionFactory;

import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class FunctionsIO {
    private FunctionsIO(){throw new UnsupportedOperationException();}
    static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function){
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());
        for (Point point : function) {
            printWriter.printf("%f %f%n", point.x, point.y);
        }
        printWriter.flush();
    };
    static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        dataOutputStream.writeInt(function.getCount());
        for (Point point : function) {
            dataOutputStream.writeDouble(point.x);
            dataOutputStream.writeDouble(point.y);
        }
        dataOutputStream.flush();
    }
    static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        NumberFormat numberFormatter = NumberFormat.getInstance(Locale.forLanguageTag("ru"));
        for (int k = 0; k < count; ++k){
            String[] strings = reader.readLine().split(" ");
            try {
                xValues[k] = numberFormatter.parse(strings[0]).doubleValue();
                yValues[k] = numberFormatter.parse(strings[1]).doubleValue();
            }
            catch (ParseException e) {
                throw new IOException(e);
            }
        }
        return factory.create(xValues, yValues);
    }

    static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        int count = dataInputStream.readInt();
        double[] xValues = new double[count];
        double[] yValues = new double[count];

        for (int k = 0; k < count; ++k){
            xValues[k] = dataInputStream.readDouble();
            yValues[k] = dataInputStream.readDouble();
        }
        return factory.create(xValues, yValues);
    }
    static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(function);
        stream.flush();
    }
    static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        return (TabulatedFunction) objectInputStream.readObject();
    }


}
