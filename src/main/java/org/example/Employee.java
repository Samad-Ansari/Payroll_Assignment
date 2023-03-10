package org.example;

public class Employee {
    final int TEMPORARY_EMP_TAX = 15;
    final int CONTRACT_EMP_TAX = 18;
    final int FULLTIME_EMP_TAX = 20;
    final int FULLTIME_EMP_BENEFIT = 10;
    private String employeeName;
    private int employeeId;
    private char employeeType;
    private double employeeWage;

    Employee(String employeeName, int employeeId, char employeeType, double employeeWage){
        setEmployeeName(employeeName);
        setEmployeeId(employeeId);
        setEmployeeType(employeeType);
        setEmployeeWage(employeeWage);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public char getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(char employeeType) {
        this.employeeType = employeeType;
    }

    public double getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(double employeeWage) {
        this.employeeWage = employeeWage;
    }

    public double getEmployeeWageAfterTax() {
        double wage;
        if(employeeType == 'T') {
            wage = employeeWage - (employeeWage * TEMPORARY_EMP_TAX / 100);
        } else if(employeeType == 'C') {
            wage = employeeWage - (employeeWage * CONTRACT_EMP_TAX / 100);
        } else {
            wage = employeeWage - (employeeWage * (FULLTIME_EMP_BENEFIT + FULLTIME_EMP_TAX) / 100);
        }
        return wage;
    }
}
