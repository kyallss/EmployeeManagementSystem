package org.example.employeemanagementsystem;

public class Contractor extends Employee {
    private double hourlyRate;
    private int maxHours;

    public Contractor(String name, double hourlyRate, int maxHours) {
        super(name, "Contractor");
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * maxHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }
}

