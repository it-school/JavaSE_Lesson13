package com.itschool;

import com.itschool.Task1.Employee;
import com.itschool.Task1.EmployeeSalaried;
import com.itschool.Task1.EmployeeTimed;
import com.itschool.Task1.Exceptions.IDException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final void task1() throws IDException {
        EmployeeSalaried employeeSalaried = new EmployeeSalaried("New Salaried worker");
        System.out.println(employeeSalaried.toString());

        EmployeeTimed employeeTimed = null;
        try {
            employeeTimed = new EmployeeTimed(1234567890L, "Иван Почасовщик", 100);
            employeeTimed = new EmployeeTimed(12345, "Мария Почасовка", 100);  // недостаточно цифр ИНН-кода
        } catch (IDException e) {
            System.out.println(e.what);
        }
        System.out.println(employeeTimed.toString());

        System.out.println("Salary for usual employee: " + employeeSalaried.CalculateSalary());
        System.out.println("Salary for timed employee: " + employeeTimed.CalculateSalary());


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeSalaried("Андрей Полноставочник", 12000));
        employees.add(new EmployeeTimed(1234567891, "Борис Почасовщик", 70));
        employees.add(new EmployeeSalaried("Зиновий Полноставочник", 20000));
        employees.add(new EmployeeTimed(1234567891, "Надежда Почасовка", 90));
        employees.add(new EmployeeSalaried("Николай Полноставочник", 5000));
        employees.add(new EmployeeTimed(1234567891, "Яков Почасовщик", 110));

        System.out.println("\nEmployees: ");
        for (Employee employee : employees)
            System.out.println(employee);

        // Collections.sort(…)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
        System.out.println("\nEmployees sorted by NAME ascending: ");
        for (Employee employee : employees)
            System.out.println(employee);


        List<Employee> list = employees;

        Collections.sort(list, Employee.ByName);
        System.out.println("\nEmployees sorted by NAME:");
        for (Employee employee : employees)
            System.out.println(employee);

        Collections.sort(list, Employee.BySalary);
        System.out.println("\nEmployees sorted by SALARY:");
        for (Employee employee : employees)
            System.out.println(employee);

        Collections.sort(list, (employee1, employee2) -> (employee2.getName().compareTo(employee1.getName())));
        System.out.println("\nEmployees sorted by NAME descending:");
        for (Employee employee : employees)
            System.out.println(employee);
    }

    public static void main(String[] args) throws IDException {
        task1();
    }
}
