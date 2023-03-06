package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
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
            wage = employeeWage - (employeeWage * 15 / 100);
        } else if(employeeType == 'C') {
            wage = employeeWage - (employeeWage * 18 / 100);
        } else {
            wage = employeeWage - (employeeWage * 30 / 100);
        }
        return wage;
    }
}

class Employees {
    List<Employee> employees;
    private int totalTemporaryEmployee;
    private int totalContractEmployee;
    private int totalFullTimeEmployee;
    private double totalEmployeeWagesBeforeTax;
    private double totalEmployeeWagesAfterTax;

    Employees(){
        employees = new ArrayList<>();
        totalTemporaryEmployee = 0;
        totalContractEmployee = 0;
        totalFullTimeEmployee = 0;
        totalEmployeeWagesBeforeTax = 0;
        totalEmployeeWagesAfterTax = 0;
    }

    void addEmployee(Employee employee){
        employees.add(employee);
        incrementEmployeeByType(employee.getEmployeeType());
        incrementWagesBeforeTax(employee.getEmployeeWage());
        incrementWagesAfterTax(employee.getEmployeeWageAfterTax());
    }

    int getTotalEmployee(){
        return employees.size();
    }

    void incrementEmployeeByType(char type){
        if(type == 'T'){
            this.totalTemporaryEmployee = this.totalTemporaryEmployee + 1;
        }
        else if(type == 'C'){
            this.totalContractEmployee = this.totalContractEmployee + 1;
        }
        else {
            this.totalFullTimeEmployee = this.totalFullTimeEmployee + 1;
        }
    }

    void incrementWagesBeforeTax(double wage){
        this.totalEmployeeWagesBeforeTax += wage;
    }

    void incrementWagesAfterTax(double wage){
        this.totalEmployeeWagesAfterTax += wage;
    }

    public int getTotalTemporaryEmployee() {
        return totalTemporaryEmployee;
    }

    public int getTotalContractEmployee() {
        return totalContractEmployee;
    }

    public int getTotalFullTimeEmployee() {
        return totalFullTimeEmployee;
    }

    public double getTotalEmployeeWagesBeforeTax() {
        return totalEmployeeWagesBeforeTax;
    }

    public double getTotalEmployeeWagesAfterTax() {
        return totalEmployeeWagesAfterTax;
    }


}

