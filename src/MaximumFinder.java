import java.util.Scanner;

public class MaximumFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       System.out.println("Enter three numbers:");
        double x = input.nextDouble();
        double y = input.nextDouble();
        double z = input.nextDouble();

        double result = maximum(x,y,z);
        double result1 = minimum(x,y,z);

        //Another method of finding the maximum
       /* if (x >= y && x >= z) {
            result = x;
        } else if (y >= x && y >= z) {
            result = y;
        } else {
            result = z;
        }*/

        System.out.println("The highest number is: " + result);
        System.out.println("The lowest number is: " + result1);
    } //End of Main

    private static double maximum(double number1, double number2, double number3) {

        double maximumValue = number1;

        if (number1 >= number2 && number1 >= number3) {
            maximumValue = number1;
        } else if (number2 >= number1 && number2 >= number3) {
            maximumValue = number2;
        } else {
            maximumValue = number3;
            return maximumValue;
        }
        return maximumValue;
    }

    private static double minimum(double number1, double number2, double number3) {

        double maximumValue = number1;

        if (number1 <= number2 && number1 <= number3) {
            maximumValue = number1;
        } else if (number2 <= number1 && number2 <= number3) {
            maximumValue = number2;
        } else {
            maximumValue = number3;
            return maximumValue;
        }
        return maximumValue;
    }


}