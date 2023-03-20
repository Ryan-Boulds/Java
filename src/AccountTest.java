import java.util.Scanner;

// Static class to DRIVE the Account Object!
//Created by Ryan Boulds
//
public class AccountTest {
    public static void main(String[] args) {
        //create a SCANNER object called "input".
        Scanner input = new Scanner(System.in);

        Account account1 = new Account("Ryan", 1_000_000);
        Account account2 = new Account("Courtney", -5.01);
        System.out.printf("account1 name is: %s%n", account1.getName());
        System.out.printf("account1 balance is: %s%n", account1.getBalance());
        System.out.printf("account2 name is %s%n", account2.getName());
        System.out.printf("account2 balance is: %s%n", account2.getBalance());



 /*       //create a SCANNER object called "myAccount".
        Account myAccount = new Account();
        //print the NAME of the account holder
        System.out.printf("Initial name is %s:%n", myAccount.getName());

        //Prompt user for a name
        System.out.println("Please Enter a Name:");
        String theName = input.nextLine();
        myAccount.setName(theName);


        //display the user's name that was set by setName()
        System.out.printf("Name in object myAccount is: %n%s%n " ,myAccount.getName());

  */
    }
}
