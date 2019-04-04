package com.itschool;

import com.itschool.Task1.Employee;
import com.itschool.Task1.EmployeeSalaried;
import com.itschool.Task1.EmployeeTimed;
import com.itschool.Task1.Exceptions.IDException;

import java.util.ArrayList;

public class Main {

    public static final void task1() throws IDException {
        EmployeeSalaried employeeSalaried = new EmployeeSalaried("New Salaried worker");
        System.out.println(employeeSalaried.toString());


        EmployeeTimed employeeTimed = null;
        try {
            employeeTimed = new EmployeeTimed(1234567890L, "New Timed Employee", 100);
//          employeeTimed = new EmployeeTimed(12345, "Timed Employee", 100);  // недостаточно цифр ИНН-кода
        } catch (IDException e) {
            e.printStackTrace();
        }
        System.out.println(employeeTimed.toString());

        System.out.println("Salary for usual employee: " + employeeSalaried.CalculateSalary());
        System.out.println("Salary for timed employee: " + employeeTimed.CalculateSalary());


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeSalaried("Employee1 fulltime", 10000));
        employees.add(new EmployeeTimed(1234567891, "Employee2 parttime", 70));
        employees.add(new EmployeeSalaried("Employee3 fulltime", 20000));
        employees.add(new EmployeeTimed(1234567891, "Employee4 parttime", 90));
        employees.add(new EmployeeSalaried("Employee5 fulltime", 30000));
        employees.add(new EmployeeTimed(1234567891, "Employee6 parttime", 110));

        System.out.println("\nEmployees: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) throws IDException {
        task1();
    }
}
