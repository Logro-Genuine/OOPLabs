package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

public class CompositeFunction implements MathFunction{
    //Объявление полей первой функции и второй функции
    private final MathFunction firstFunction;
    private final MathFunction secondFunction;

    //Конструктор
    public CompositeFunction(MathFunction firstFunction, MathFunction secondFunction){
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

    //Наследованная функция apply из MathFunction для использования вложенных функций g(f(x))
    @Override
    //h(x) = g(f(x)) -> h(x) = secondFunction(firstFunction(x))
    public double apply(double x) {
        return secondFunction.apply(firstFunction.apply(x));
    }
}
