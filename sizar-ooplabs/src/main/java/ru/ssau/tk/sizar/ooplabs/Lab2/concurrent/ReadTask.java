package ru.ssau.tk.sizar.ooplabs.Lab2.concurrent;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

public class ReadTask implements Runnable{
    private final TabulatedFunction function;

    public ReadTask(TabulatedFunction function){
        this.function = function;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++){
            synchronized (function) {
                System.out.printf("After read: i = %d, x = %f, y = %f%n", i, function.getX(i), function.getY(i));
            }
        }
    }
}
