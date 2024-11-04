package ru.ssau.tk.sizar.ooplabs.Lab2.concurrent;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.ConstantFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.sizar.ooplabs.Lab2.functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args){
        TabulatedFunction function = new LinkedListTabulatedFunction(new ConstantFunction(-1),1,1000,1000);
        ReadTask readTask = new ReadTask(function);
        WriteTask writeTask = new WriteTask(function, 0.5);
        new Thread(readTask).start();
        new Thread(writeTask).start();
    }
}
