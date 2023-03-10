package org.example;

import java.util.Scanner;

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