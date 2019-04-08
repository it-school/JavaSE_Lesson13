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
            employeeTimed = new EmployeeTimed(1234567890L, "New Timed Employee", 100);
//          employeeTimed = new EmployeeTimed(12345, "Timed Employee", 100);  // недостаточно цифр ИНН-кода
        } catch (IDException e) {
            e.printStackTrace();
        }
        System.out.println(employeeTimed.toString());

        System.out.println("Salary for usual employee: " + employeeSalaried.CalculateSalary());
        System.out.println("Salary for timed employee: " + employeeTimed.CalculateSalary());


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeSalaried("DEmployee1 fulltime", 12000));
        employees.add(new EmployeeTimed(1234567891, "Employee2 parttime", 70));
        employees.add(new EmployeeSalaried("ZEmployee3 fulltime", 20000));
        employees.add(new EmployeeTimed(1234567891, "Employee4 parttime", 90));
        employees.add(new EmployeeSalaried("Amployee5 fulltime", 5000));
        employees.add(new EmployeeTimed(1234567891, "Employee6 parttime", 110));

        System.out.println("\nEmployees: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Collections.sort(…)
        List<Employee> list = employees;
        Collections.sort(list, new Comparator<Employee>()
        {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                // return (o1.CalculateSalary() > o2.CalculateSalary() ? 1 : o1.CalculateSalary() < o2.CalculateSalary() ? -1 : 0 );
                return (int) (o1.CalculateSalary() - o2.CalculateSalary());
            }
        });

        System.out.println("\nSorted by name Employees: ");
        for (Employee employee : list)
        {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) throws IDException {
        task1();
    }
}
