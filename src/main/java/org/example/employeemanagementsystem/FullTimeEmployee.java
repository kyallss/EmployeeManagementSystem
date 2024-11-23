package org.example.employeemanagementsystem;

public class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, double annualSalary) {
        super(name, "Full-time");
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateSalary() {
        return annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}

