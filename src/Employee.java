//Created by Ryan Boulds


public class Employee {

    private String first, last;
    private double monthlySalary, YearlySalary, YearlySalaryPlusRaise;


    //constructor
    public Employee(String firstName, String lastName, double monthlySalaryInput) {
        this.first = firstName;
        this.last = lastName;

        if (monthlySalaryInput > 0.0) {
            monthlySalary = monthlySalaryInput;
        } else {
            monthlySalary = 0;
        }
        YearlySalary = monthlySalary * 12;
        YearlySalaryPlusRaise = YearlySalary * 1.1;
    }//End of constructor

    //records data to return it to EmployeeTest
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getYearlySalary() {
        return YearlySalary;
    }

    public double getYearlySalaryPlusRaise() {
        return YearlySalaryPlusRaise;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

} //End of Employee