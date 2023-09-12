//Created by Ryan Boulds

import java.util.Scanner;

public class DiamondPrinting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an odd number between 1-19 of the number of lines that you would like to print: ");  //message prompting the user for input.
        int NumOfLines = input.nextInt();  //Gets input from the user.
        if (NumOfLines % 2 == 1 && NumOfLines <= 19) { //This makes sure the input meets the criteria of being in the range of 1-19 for odd integers.

            NumOfLines = (NumOfLines + 1) / 2; //This makes it such that there is not twice the number of lines that the user wants to print.
            //The reason for this is due to having two loops. One for where the diamond opens up, and one loop for when the diamond closes.
            //The +1 makes it such that there will not be a remainder, and it will also factor for the line in the center.

            for (int NumOfLinesCounted = 1; NumOfLinesCounted <= NumOfLines; NumOfLinesCounted++) {
                int numOfSpacesPerLine = NumOfLines; //This is for the formatting of how many spaces are needed to ensure that it makes a diamond shape.
                double numOfAsterisksPerLine = 0.5; //increasing the amount by 0.5 will make sure it will have 2 added asterisks per line to make the diamond shape.  One per each side.

                while (numOfSpacesPerLine > NumOfLinesCounted) { //This loop will put spaces before the asterisks to make the diamond shape.
                    System.out.print(" ");
                    numOfSpacesPerLine = numOfSpacesPerLine - 1; //As the diamond becomes wider, it will need fewer spaces to maintain the shape.
                }

                while (numOfAsterisksPerLine < NumOfLinesCounted) { //For each line added, 2 additional asterisks will be added per line.
                    System.out.print("*");
                    numOfAsterisksPerLine = numOfAsterisksPerLine + 0.5; //Adding 0.5 to numOfAsterisksPerLine will be sure to add two asterisks per line as NumOfLinesCounted increases.
                }
                System.out.printf("%n"); //This will move onto the next line before restarting the loop.
            } //End of the part of the diamond where it opens up + the center line.

            //This for loop is the same as the one previous with a few small changes to make sure is closes the diamond instead of opening it.
            for (int NumOfLinesLeft = NumOfLines - 1; NumOfLinesLeft > 0; NumOfLinesLeft = NumOfLinesLeft - 1) { //This will count down how many lines it had remaining to print.
                int numOfSpacesPerLine = NumOfLines; //This is for the formatting of how many spaces are needed to ensure that it makes a diamond shape.
                double numOfAsterisksPerLine = 0.5;  //decreasing the amount by 0.5 will make sure it will have 2 added asterisks per line to make the diamond shape.  One per each side.
                //once numOfAsterisksPerLine reaches 0.5, it will stop printing asterisks leaving only one at the end.

                while (numOfSpacesPerLine > NumOfLinesLeft) {  //This loop will put spaces before the asterisks to make the diamond shape.
                    System.out.print(" ");
                    numOfSpacesPerLine = numOfSpacesPerLine - 1;  //As the diamond becomes less wide, it will need more spaces to maintain the shape.
                }

                while (numOfAsterisksPerLine < NumOfLinesLeft) {  //For each line added, 2 fewer asterisks will be added per line.
                    System.out.print("*");
                    numOfAsterisksPerLine = numOfAsterisksPerLine + 0.5; //adding 0.5 to numOfAsterisksPerLine will be sure to remove two asterisks per line as NumOfLinesLeft becomes less.
                }
                System.out.printf("%n");  //This will move onto the next line before restarting the loop.
            } //End of the lower part of the diamond where it closes it.

        } else {
            System.out.println("Please enter a positive odd number between 1-19."); //If the input does not meet the criteria, then an error message with appear.
        }
    }
}