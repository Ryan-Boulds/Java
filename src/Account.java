//Created by Ryan Boulds
//
//This is used to track account information
public class Account {
    //This stores the user's name
    private String name;
    private double balance = 0;

    //CONSTRUCTOR
    //THis code runs when the object is created (i.e., instantiated
    public Account(String name, double balance) {
        this.name = name;

        //Only Allow positive entry
        if (balance > 0.0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return (this.balance);
    }

    public void deposit(double depositAmount) {
        //only if a POSITIVE ENTRY
        if (depositAmount > 0.0) {
            this.balance += depositAmount;

        }
    }
    //This sets the class INSTANCE variable "name" to a value.
    public void setName (String name){
        this.name = name;
    }
    public String getName () {
        return (this.name);
    }
}