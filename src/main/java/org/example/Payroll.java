package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Payroll {

    Employees employees = new Employees();
    DecimalFormat df = new DecimalFormat("$,##0.00");

    void run(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\nDo you want to register another employee (Y/N)? : ");
            char loop = scanner.next().toUpperCase().charAt(0);
            if(loop == 'Y'){
                worker();
            } else {
                finalPrinter();
                break;
            }
        }
    }

    void worker() {
        Entries entry = new Entries();
        String employeeName;
        int employeeId;
        char employeeType;
        double employeeWage;

        // Employee Name Entry
        employeeName = entry.setEmployeeName();
//
        // Employee Id Entry
        employeeId = entry.setEmployeeId();

        // Employee Type Entry
        employeeType = entry.setEmployeeType();

        // Employee Wage Entry
        employeeWage = entry.setEmployeeWage();

        Employee employee = new Employee(employeeName, employeeId, employeeType, employeeWage);

        System.out.print("Employee’s wage after tax: " + df.format(employee.getEmployeeWageAfterTax()));
        employees.addEmployee(employee);


    }

    void finalPrinter(){
        System.out.println("Employee name, employee ID, Work Type, Total Wage before tax, Total Wage after tax");
        for(Employee employee : employees.employees){
            System.out.println(employee.getEmployeeName() + " " +
                    employee.getEmployeeId() + " " +
                    employee.getEmployeeType() + " " +
                    df.format(employee.getEmployeeWage()) + " " +
                    df.format(employee.getEmployeeWageAfterTax()));
        }

        System.out.println("Total employees: " + employees.getTotalEmployee());
        System.out.println("Work types: (" +
                employees.getTotalTemporaryEmployee() + ") Temporary, (" +
                employees.getTotalContractEmployee() + ") Contract, (" +
                employees.getTotalFullTimeEmployee() + ") Full-time"
        );
        System.out.println("Total wages before tax: " + df.format(employees.getTotalEmployeeWagesBeforeTax()));
        System.out.println("Total wages after tax: " + df.format(employees.getTotalEmployeeWagesAfterTax()));
    }

}

class Entries {

    boolean valid;
    char employeeType = '\0';
    Scanner scanner = new Scanner(System.in);
    Validators validators = new Validators();

    String setEmployeeName(){
        String employeeName = null;
        valid = false;
        while(!valid){
            System.out.print("Please enter the employee’s name? : ");
            try {
                employeeName = scanner.nextLine().trim();
                validators.validateName(employeeName);
                valid = true;
            } catch (ExceptionRaiser e){
                System.out.println("\t => " + e.getMessage() + " !!");
            }
        }
        return employeeName;
    }

    int setEmployeeId(){
        valid = false;
        int employeeId = 0;
        while(!valid){
            System.out.print("Please enter the employee’s ID? : ");
            try {
                scanner = new Scanner(System.in);
                employeeId = scanner.nextInt();
                validators.validateId(employeeId);
                valid = true;
            }
            catch(Exception e) {
                if(e.getMessage() != null){
                    System.out.println("\t => " + e.getMessage());
                } else {
                    System.out.println("\t => Invalid Entry !");
                }
            }
        }
        return employeeId;
    }

    char setEmployeeType(){
        valid = false;
        while(!valid){
            System.out.print("Please enter the employee’s work type? : ");
            try{
                employeeType = scanner.next().toUpperCase().charAt(0);
                validators.validateEmployeeType(employeeType);
                valid = true;
            }
            catch(Exception e){
                System.out.println("\t => " + e.getMessage() + " !!");
            }
        }
        return employeeType;
    }

    double setEmployeeWage(){
        double employeeWage = '0';
        valid = false;
        while(!valid){
            System.out.print("Please enter the employee’s wage? : ");
            try {
                scanner = new Scanner(System.in);
                employeeWage = scanner.nextDouble();
                validators.validateWage(employeeWage, employeeType);
                valid = true;
            }
            catch(Exception e){
                if(e.getMessage() != null){
                    System.out.println("\t => " + e.getMessage());
                } else {
                    System.out.println("\t => Invalid Entry !");
                }
            }
        }
        return employeeWage;
    }
}