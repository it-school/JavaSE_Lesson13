package com.itschool.Task1.Exceptions;

public class IDException extends Exception {
    public String what;

    public IDException() {
        this.what = "Некорректно указан ИНН";
    }
}
