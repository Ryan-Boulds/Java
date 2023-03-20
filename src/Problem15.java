import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Get the input from the user.
        System.out.printf("%nPlease enter an integer for the number of asterisks that you would like to print.%nThe integer must be between 1 to 100: ");
        int NumOfAsterisks = input.nextInt();


        //This if else statement determines if the integer input is between 1 and 100.
        if (NumOfAsterisks >= 1 && NumOfAsterisks <= 100) {
            while (NumOfAsterisks >= 1) {

                System.out.print("*");
                // For every time that the while loop runs, it will subtract 1 from NumOfAsterisks until it reaches 0.
                // This will effectively end the loop.
                NumOfAsterisks = NumOfAsterisks - 1;

            } //END of while loop
        } //End of if
        else {
            System.out.print("The integer entered is not between 1 to 100."); //error message for if the integer was not between 1 and 100.

        }//END of else

    }//END of Main

} //END of public class Problem15