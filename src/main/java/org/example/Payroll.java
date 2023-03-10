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
            } else if(loop == 'N'){
                finalPrinter();
                break;
            }
            else {
                System.out.println("\nInput invalid !");
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
