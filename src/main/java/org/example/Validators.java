package org.example;


class Validators {
    void validateName(String name) throws ExceptionRaiser {

        if(name.length()-countSpace(name) < 5){
            throw new ExceptionRaiser("Name length must be greater than 5");
        }
        else if(countSpace(name) < 1){
            throw new ExceptionRaiser("Name must contains atleast 1 space");
        }
    }

    void validateWage(double wage, char type) throws  ExceptionRaiser{
        if(type == 'T' && (wage > 90.00 || wage < 0.00)){
            throw new ExceptionRaiser("Hourly Wage cannot exceed 90.00 or lower than 0");
        }
        else if(type == 'C' && (wage < 1000.00 || wage > 3500.00)){
            throw new ExceptionRaiser("Bi-weekly pay cannot be below 1000.00 or more than 3500.00");
        }
        else if(type == 'F' && (wage < 3000.0)){
            throw new ExceptionRaiser("monthly pay cannot be less than 3000.00");
        }

    }

    void validateId(int id) throws ExceptionRaiser{
        if(id < 0){
            throw new ExceptionRaiser("Id must be a positive integer");
        }
    }

    void validateEmployeeType(char type) throws ExceptionRaiser{
        if(!(type == 'T' || type == 'C' || type == 'F')){
            throw new ExceptionRaiser("Invalid Employee Type");
        }
    }

    int countSpace(String name){
        int count = 0;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) == ' ')
                count++;
        }
        return count;
    }
}

class ExceptionRaiser extends Exception {
    public ExceptionRaiser(String str){
        super(str);

    }
}
