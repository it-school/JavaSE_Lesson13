package com.itschool;

import com.itschool.Task1.Employee;
import com.itschool.Task1.EmployeeSalaried;
import com.itschool.Task1.EmployeeTimed;
import com.itschool.Task1.Exceptions.IDException;
import com.itschool.Task2.CustomList;
import com.itschool.Task3.CustomMap;

import java.util.*;

public class Main
{

	public static void main(String[] args) throws IDException
	{
		task1();
		// task2();
		// task3();
	}

	public static final void task1() throws IDException
	{
		EmployeeSalaried employeeSalaried = new EmployeeSalaried("New Salaried worker");
		System.out.println(employeeSalaried.toString());

		EmployeeTimed employeeTimed = null;
		try {
			employeeTimed = new EmployeeTimed(2975812345L, "Иван Почасовщик", 100, new GregorianCalendar(1981, 6, 24));
			// employeeTimed = new EmployeeTimed(12345, "Мария Почасовка", 100);  // недостаточно цифр ИНН-кода
		}
		catch (IDException e) {
			System.out.println(e.what);
		}
		System.out.println(employeeTimed.toString());

		System.out.println("Salary for usual employee: " + employeeSalaried.CalculateSalary());
		System.out.println("Salary for timed employee: " + employeeTimed.CalculateSalary());

		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new EmployeeSalaried("Андрей Полноставочник", 12000));
		employees.add(new EmployeeSalaried("Зиновий Полноставочник", 20000));
		employees.add(new EmployeeTimed(2975823456L, "Надежда Почасовка", 90, new GregorianCalendar(1981, 6, 24)));
		employees.add(new EmployeeTimed(2975834567L, "Борис Почасовщик", 70, new GregorianCalendar(1981, 6, 24)));
		employees.add(new EmployeeSalaried("Николай Полноставочник", 5000));
		employees.add(new EmployeeTimed(2975856789L, "Яков Почасовщик", 110, new GregorianCalendar(1981, 6, 24)));

		System.out.println("\nEmployees: ");
		for (Employee employee : employees) { System.out.println(employee); }

		// Collections.sort(…)
		Collections.sort(employees, new Comparator<Employee>()
		{
			@Override
			public int compare(Employee employee1, Employee employee2)
			{
				return employee1.getName().compareTo(employee2.getName());
			}
		});

		System.out.println("\nEmployees sorted by NAME ascending: ");
		for (Employee employee : employees) { System.out.println(employee); }


		List<Employee> list = employees;

		Collections.sort(list, Employee.ByNameAscending);
		System.out.println("\nEmployees sorted by NAME ascending:");
		for (Employee employee : employees) { System.out.println(employee); }

		Collections.sort(list, Employee.ByNameDescending);
		System.out.println("\nEmployees sorted by NAME descending:");
		for (Employee employee : employees) { System.out.println(employee); }

		Collections.sort(list, Employee.BySalary);
		System.out.println("\nEmployees sorted by SALARY:");
		for (Employee employee : employees) { System.out.println(employee); }

		Collections.sort(list, (employee1, employee2) -> (employee2.getName().compareTo(employee1.getName())));
		System.out.println("\nEmployees sorted by NAME descending:");
		for (Employee employee : employees) { System.out.println(employee); }
	}

	private static void task3()
	{
		System.out.println("\nHashMapTest");
		HashMap hashMaTest = new HashMap<String, Integer>();
		hashMaTest.put("micro", 1234566);
		hashMaTest.put("micro2", 1234567);
		hashMaTest.put("micro3", 1234568);
		hashMaTest.put("micro4", 1234569);
		hashMaTest.put("micro5", 12345610);
		hashMaTest.put("micro6", 12345611);
		hashMaTest.put("micro6", 1111111111);
		System.out.println(hashMaTest.get("micro6"));
		System.out.println(hashMaTest.get("micro3"));
		System.out.println(hashMaTest.get("micro4"));
		System.out.println(hashMaTest.get("micro5"));
		System.out.println(hashMaTest.get("micro2345"));


		System.out.println("\nCustom Map Test");
		CustomMap<String, Integer> customMap = new CustomMap();
		customMap.put("Test1", 10);
		customMap.put("Test2", 12);
	}

	private static void task2()
	{
		CustomList customList = new CustomList();
		for (int i = 0; i < 10; i++) {
			customList.add(i);
		}
		System.out.println(customList);
		System.out.println("test get " + customList.get(8));
		customList.remove(5);
	}
}
