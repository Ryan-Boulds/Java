import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        //Used for user input.
        Scanner input = new Scanner(System.in);
        System.out.printf("Type -1 to quit%n");
        int total = 0;
        int grade = 0;
        int gradeCounter = -1;


        while (grade != -1) {
            gradeCounter++;
            System.out.print("Enter Grade: ");
            grade = input.nextInt();
            total = total + grade;

            System.out.print(gradeCounter);
        }
        double average = (double) total / gradeCounter;
//Calculate the average
        System.out.printf("%nTotal of all 10 grades is: %d%n", total);
        System.out.printf("%nThe class average is: %.2f%n", average);

    }
}