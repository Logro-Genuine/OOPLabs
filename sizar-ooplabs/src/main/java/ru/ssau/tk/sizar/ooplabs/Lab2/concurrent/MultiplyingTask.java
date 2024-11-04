package ru.ssau.tk.sizar.ooplabs.Lab2.concurrent;

import ru.ssau.tk.sizar.ooplabs.Lab2.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable{
    private final TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++){
            function.setY(i, function.getY(i) * 2);
        }
        System.out.printf("Thread %s has completed the task.%n", Thread.currentThread().getName());

    }
}
