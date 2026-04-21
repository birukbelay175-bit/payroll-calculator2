package com.pluralsight;

public class PayrollCalculator {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public PayrollCalculator(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}