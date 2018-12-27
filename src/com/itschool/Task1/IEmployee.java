package com.itschool.Task1;

public interface IEmployee {
    double minimalMonthSalary = 3723;   //  минимальная месячная зарплата в Украине на 01.12.2018
    double minimalHourSalary = 22.41;   //  минимальная почасовая оплата в Украине на 1.05.2018
    double typicalsMonthDays = 20.8;    //  среднее кол-во дней в месяце для расчёта зарплаты
    double hoursPerDay = 8;             //  кол-во рабочих часов в день

    double CalculateSalary();

    String getName();
}
