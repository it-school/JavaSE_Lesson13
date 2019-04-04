package com.itschool.Task1;

public interface IEmployee {
    double minimalMonthSalary = 4123;   //  минимальная месячная зарплата в Украине на 01.1.2019
    double minimalHourSalary = 24.78;   //  минимальная почасовая оплата в Украине на 01.01.2019
    double typicalsMonthDays = 20.8;    //  среднее кол-во дней в месяце для расчёта зарплаты
    double hoursPerDay = 8;             //  кол-во рабочих часов в день

    double CalculateSalary();

    String getName();
}
