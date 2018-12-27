package com.itschool.Task1;

import com.itschool.Task1.Exceptions.IDException;

abstract public class Employee implements IEmployee {
    private long ID;
    private String name;
    private static int counter = 0;

    public Employee() {
        this.name = "NoName_" + counter;
    }

    public Employee(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) throws IDException {
/*
        ИНН (индивидуальный налоговый номер) в Украине состоит из 10 цифр. В нём зашифрованы:
        - дата рождения (первые пять цифр образуют число, равное количеству дней от 01.01.1900 до даты рождения владельца ИНН);
        - пол (чётность девятой цифры: четная цифра – женский, нечетная – мужской);
        - checksum, т.е. контрольное число (последняя цифра)
*/
        if ((ID < 1000000000L) || (ID > 9999999999L))
            throw new IDException();
        else
            this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(long ID) throws IDException {
        this.setID(ID);
    }

    public Employee(long ID, String name) throws IDException {
        this.setID(ID);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee: " + this.name + (this.ID > 0 ? ", " + this.ID : "");
    }
}