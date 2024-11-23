package org.example.employeemanagementsystem;

public abstract class Employee {
    private String name;
    private String employeeType;

    public Employee(String name, String employeeType) {
        this.name = name;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }


    public abstract double calculateSalary();
}
