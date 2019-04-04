package com.itschool;

public interface IEmployee {
    double minimalMonthSalary = 4123;   //  минимальная месячная зарплата в Украине на 1.01.2019
    double minimalHourSalary = 24.78;   //  минимальная почасовая оплата в Украине на 1.01.2019
    double typicalsMonthDays = 20.8;    //
    double hoursPerDay = 8;             //

    double CalculateSalary();
}
