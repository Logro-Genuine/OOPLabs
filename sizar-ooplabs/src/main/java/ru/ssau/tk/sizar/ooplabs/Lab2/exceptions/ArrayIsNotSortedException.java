package ru.ssau.tk.sizar.ooplabs.Lab2.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {
    public ArrayIsNotSortedException(){}
    public ArrayIsNotSortedException(String message){
        super(message);
    }
}
