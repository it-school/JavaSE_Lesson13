package com.itschool;

public interface IEmployee {
    double minimalMonthSalary = 3723;   //  минимальная месячная зарплата в Украине на 01.12.2018
    double minimalHourSalary = 22.5;    //  минимальная почасовая оплата в Украине на 1.05.2018
    double typicalsMonthDays = 20.8;    //
    double hoursPerDay = 8;             //

    double CalculateSalary();
}
