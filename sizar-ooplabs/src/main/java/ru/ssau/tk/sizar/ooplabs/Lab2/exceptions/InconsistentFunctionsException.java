package ru.ssau.tk.sizar.ooplabs.Lab2.exceptions;

public class InconsistentFunctionsException extends RuntimeException{
    public InconsistentFunctionsException(){}
    public InconsistentFunctionsException(String message){
        super(message);
    }
}
