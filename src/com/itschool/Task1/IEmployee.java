package com.itschool.Task1;

public interface IEmployee {
    double MINIMAL_MONTH_SALARY = 4123;   //  минимальная месячная зарплата в Украине на 01.1.2019
    double MINIMAL_HOUR_SALARY = 24.78;   //  минимальная почасовая оплата в Украине на 01.01.2019
    double TYPICALS_MONTH_DAYS = 20.8;    //  среднее кол-во дней в месяце для расчёта зарплаты
    double HOURS_PER_DAY = 8;             //  кол-во рабочих часов в день

    double CalculateSalary();

    String getName();
}
