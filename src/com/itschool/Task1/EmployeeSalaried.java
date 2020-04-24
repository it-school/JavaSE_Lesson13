package com.itschool.Task1;


public class EmployeeSalaried extends Employee implements IEmployee
{
	private double typicalSalary = MINIMAL_MONTH_SALARY;

	public EmployeeSalaried(String name)
	{
		super(name);
	}

	public EmployeeSalaried(double typicalSalary)
	{
		this.typicalSalary = typicalSalary;
	}

	public EmployeeSalaried(String name, double typicalSalary)
	{
		super(name);
		this.typicalSalary = typicalSalary;
	}

	public double getTypicalSalary()
	{
		return typicalSalary;
	}

	public void setTypicalSalary(double typicalSalary)
	{
		this.typicalSalary = (typicalSalary < MINIMAL_MONTH_SALARY ? MINIMAL_MONTH_SALARY : typicalSalary);
	}

	@Override
	public String toString()
	{
		return super.toString() + ", month salary is " + this.CalculateSalary();
	}

	@Override
	public double CalculateSalary()
	{
		return this.typicalSalary;
	}
}
