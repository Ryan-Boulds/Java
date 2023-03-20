import java.util.Scanner;
public class Chapter2MenuAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//Get the first input from the user.
        System.out.print("Enter the first integer: ");
        int integer1 = input.nextInt(); //Get a integer1
//Get the second input from the user.
        System.out.print("Enter the second integer: ");
        int integer2 = input.nextInt(); //Get a integer2
//Menu
        System.out.printf("Type an operation that you would like to perform. %nType +, -, *, /, or %%. %n");
//Get input
        //Using next().charAt(0) to Accept Char Input
        char operation = input.next().charAt(0);
        // System.out.print(operation);
//determine what the user inputted and complete the operation

        if(operation == '+' ) {
            System.out.printf("%d + %d = %d.%n", integer1, integer2, integer1 + integer2);
        }
        else if(operation == '-' ) {
            System.out.printf("%d - %d = %d.%n", integer1, integer2, integer1 - integer2);
        }
        else if(operation == '*' ) {
            System.out.printf("%d * %d = %d.%n", integer1, integer2, integer1 * integer2);
        }
        else if(operation == '/' ) {
            if(integer2 == 0) {
                System.out.print("You cannot divide by 0.");
            }
            else System.out.printf("%d / %d = %d.%n", integer1, integer2, integer1 / integer2);

        }
        else if(operation == '%' ) {
            System.out.printf("%d %% %d = %d.%n", integer1, integer2, integer1 % integer2);
        }
        else{
            System.out.printf("Error, please input a valid character.%n");
        }

    }//End of main

} //End of Class
