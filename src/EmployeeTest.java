//Created by Ryan Boulds
public class EmployeeTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ryan", "Boulds", 9_000);



       Employee employee2 = new Employee("Courtney", "Boulds", 1_000); //Courtney is my sister's name.

//displays message about employee1
        System.out.printf("%nFor the employee: %s %s %n$%.2f is their monthly income.%n$%.2f is their yearly income.%n$%.2f is their yearly income with a 10%% raise.%n",
                employee1.getFirst(),
                employee1.getLast(),
                employee1.getMonthlySalary(),
                employee1.getYearlySalary(),
                employee1.getYearlySalaryPlusRaise());
//displays message about employee2
       System.out.printf("%nFor the employee: %s %s %n$%.2f is their monthly income.%n$%.2f is their yearly income.%n$%.2f is their yearly income with a 10%% raise.%n",
               employee2.getFirst(),
               employee2.getLast(),
               employee2.getMonthlySalary(),
               employee2.getYearlySalary(),
               employee2.getYearlySalaryPlusRaise());



    }//End of main
}//End of EmployeeTest

