package com.itschool.Task1;

public interface IEmployee {
   double MINIMAL_MONTH_SALARY = 6000;   //  минимальная месячная зарплата в Украине на 01.1.2021
   double MINIMAL_HOUR_SALARY = 36.0577; //  минимальная почасовая оплата в Украине на 01.01.2021
   double AVG_DAYS_IN_MONTH = 20.8;    //  среднее кол-во дней в месяце для расчёта зарплаты
   double WORK_HOURS_PER_DAY = 8;             //  кол-во рабочих часов в день

   double CalculateSalary();

   String getName();
}
