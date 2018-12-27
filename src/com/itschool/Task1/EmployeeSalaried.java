package com.itschool.Task1;

public class EmployeeSalaried extends Employee implements IEmployee {
    private double typicalSalary = minimalMonthSalary;

    public EmployeeSalaried(String name) {
        super(name);
    }

    @Override
    public double CalculateSalary() {
        return this.typicalSalary;
    }

    public EmployeeSalaried(double typicalSalary) {
        this.typicalSalary = typicalSalary;
    }

    public EmployeeSalaried(String name, double typicalSalary) {
        super(name);
        this.typicalSalary = typicalSalary;
    }

    public double getTypicalSalary() {
        return typicalSalary;
    }

    public void setTypicalSalary(double typicalSalary) {
        this.typicalSalary = (typicalSalary < minimalMonthSalary ? minimalMonthSalary : typicalSalary);
    }

    @Override
    public String toString() {
        return super.toString() + ", month salary is " + this.CalculateSalary();
    }

}
