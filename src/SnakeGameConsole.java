import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class SnakeGameConsole {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Declare variables and set initial values.
        boolean snakeIsAlive = true;
        int CurrentLengthOfSnake = 1;
        //MaxLength can be changed to adjust the size of the board that the snake can move around on.
        int MaxLengthOfX = 15;
        int MaxLengthOfY = 15;
        int NumOfTimesLoopRepeats = 0;
        int foodPositionX = rand.nextInt((MaxLengthOfX-1) + 1);
        int foodPositionY = rand.nextInt((MaxLengthOfY-1) + 1);
        String direction = "d";

        //initializes array
        int[][] snakePosition = new int[MaxLengthOfX + 2][MaxLengthOfY + 2];
        //assigns -1 to every element in the array/
        for (int i = 0; i < snakePosition.length; i++) {
            for (int j = 0; j < snakePosition.length; j++) {
                snakePosition[i][j] = -1;
            }
        }
        //initial point (for testing purposes)
        snakePosition[MaxLengthOfX / 2][MaxLengthOfY / 2] = 1;
        //set initial food position
        snakePosition[foodPositionX][foodPositionY] = -10;

        System.out.printf("WIP Controls: Enter Strings such as 'w' 'a' 's' 'd' for movement.%nAny other inputs will keep the same direction going. %nYou must hit enter for each frame.%nThis is something that I will fix in a later iteration.%n" );

        //Snake Game Loop
        while (snakeIsAlive) {
            //resets foodHasEaten to false after food has been eaten.
            boolean foodHasEaten = false;
            //keeps track of how many times loop has repeated.
            // The number of times the loop is repeated is recorded into array location as a timestamp.
            NumOfTimesLoopRepeats++;
//**********************************************************************************************************************
//graphing
            //This loop draws the upper horizontal line border.
            for (int i = 0; i < MaxLengthOfX + 1; i++) {
                System.out.print("---");
            }
            System.out.printf("%n");

            //This loop will draw each line.  Thus, this is for graphing the Y coordinates.
            for (int NumOfLinesCounted = 0; NumOfLinesCounted <= MaxLengthOfY; NumOfLinesCounted++) {

                //This will print an * before every single line.Thus making a vertical row on the left.
                System.out.print("|");

                //This loop with draw each space or object on the graph.
                for (int spacesPerLine = 0; spacesPerLine < MaxLengthOfX; spacesPerLine++) {

                    if (snakePosition[spacesPerLine][NumOfLinesCounted] != -1 && snakePosition[spacesPerLine][NumOfLinesCounted] != -10) {
                        System.out.print(" ■ ");
                    } else if (snakePosition[spacesPerLine][NumOfLinesCounted] == -10) {
                        System.out.print(" @ ");
                    } else {
                        System.out.print("   ");
                    }
                }

                //This will print a vertical row on the right.
                System.out.print(" |");
                System.out.printf("%n");
            }
            //This draws the lower horizontal line border
            for (int i = 0; i < MaxLengthOfX + 1; i++) {
                System.out.print("---");
            }//End of loops that draw graph

//**********************************************************************************************************************
//beginning of logic for snake and food locations

//if x = -1 or y = -1, then this means they are unassigned.
            int x = -1, y = -1;

            //This will detect the location of a point relative to what time the point was added.
            for (int i = 0; i < snakePosition.length; i++) {
                for (int j = 0; j < snakePosition[i].length; j++) {
                    if (snakePosition[i][j] == NumOfTimesLoopRepeats) {
                        x = i;
                        y = j;
                    }
                }
            }//End of detecting which array is the newest addition.
//**********************************************************************************************************************
//controls
            //Get the input from the user.
            String userInput = input.nextLine();

            //If the user enters an invalid input, then the snake will continue going the direction it was already going.
            if (Objects.equals(userInput, "w") || Objects.equals(userInput, "a") || Objects.equals(userInput, "s") || Objects.equals(userInput, "d")) {
                direction = userInput;
            }

//currently takes WASD inputs.
            switch (direction) {
                case "d": //right
                    //checks if food exists on the point that the head is about to be drawn.
                    if (snakePosition[x + 1][y] == -10) {
                        foodHasEaten = true;
                    }
                    //wall collision detector
                    if (x != MaxLengthOfX - 1) {
                        //If the value in the array position is positive, then the snake is present.
                        //If the snake eats itself, the game is over.
                        if (snakePosition[x + 1][y] < 0) {
                            snakePosition[x + 1][y] = NumOfTimesLoopRepeats + 1;
                        } else {
                            System.out.println("Game Over. You ate your tail.");
                            snakeIsAlive = false;
                        }
                    } else {
                        System.out.println("Game Over. You hit a wall.");
                        snakeIsAlive = false;
                    }
                    break;

                case "a"://left
                    //wall collision detector.  This also makes sure it is within the array parameters.
                    if (x != 0) {
                        //checks if food exists on the point that the head is about to be drawn.
                        if (snakePosition[x - 1][y] == -10) {
                            foodHasEaten = true;
                        }
                        //If the value in the array position is positive, then the snake is present.
                        //If the snake eats itself, the game is over.
                        if (snakePosition[x - 1][y] < 0) {
                            snakePosition[x - 1][y] = NumOfTimesLoopRepeats + 1;
                        } else {
                            System.out.println("Game Over. You ate your tail.");
                            snakeIsAlive = false;
                        }
                    } else {
                        System.out.println("Game Over. You hit a wall.");
                        snakeIsAlive = false;
                    }
                    break;

                case "w": //up
                    //wall collision detector.  This also makes sure it is within the array parameters.
                    if (y != 0) {
                        //checks if food exists on the point that the head is about to be drawn.
                        if (snakePosition[x][y - 1] == -10) {
                            foodHasEaten = true;
                        }
                        //If the value in the array position is positive, then the snake is present.
                        //If the snake eats itself, the game is over.
                        if (snakePosition[x][y - 1] < 0) {
                            snakePosition[x][y - 1] = NumOfTimesLoopRepeats + 1;
                        } else {
                            System.out.println("Game Over. You ate your tail.");
                            snakeIsAlive = false;
                        }
                    } else {
                        System.out.println("Game Over. You hit a wall.");
                        snakeIsAlive = false;
                    }
                    break;

                case "s": //down
                    //checks if food exists on the point that the head is about to be drawn.
                    if (snakePosition[x][y + 1] == -10) {
                        foodHasEaten = true;
                    }
                    //wall collision detector
                    if (y + 1 != MaxLengthOfY + 1) {
                        //If the value in the array position is positive, then the snake is present.
                        //If the snake eats itself, the game is over.
                        if (snakePosition[x][y + 1] < 0) {
                            snakePosition[x][y + 1] = NumOfTimesLoopRepeats + 1;
                        } else {
                            System.out.println("Game Over. You ate your tail.");
                            snakeIsAlive = false;
                        }
                    } else {
                        System.out.println("Game Over. You hit a wall.");
                        snakeIsAlive = false;
                    }
                    break;
                default: //This should be impossible to happen
                    break;
            }//end of controls
//**********************************************************************************************************************
//Food logic
            //remove old trail

            //This will detect the location of a point relative to what time the point was added.
            if (!foodHasEaten) {
                for (int i = 0; i < snakePosition.length; i++) {
                    for (int j = 0; j < snakePosition[i].length; j++) {
                        if (snakePosition[i][j] == NumOfTimesLoopRepeats - CurrentLengthOfSnake) {
                            snakePosition[i][j] = -1; //resets array values to make it delete places where the snake is.
                        }
                    }
                }
            }//End of detecting which array is the newest addition.

//If the snake eats food, then this will choose a random point to put more food.

            if (foodHasEaten) {
                foodPositionX = rand.nextInt((MaxLengthOfX-1) + 1);
                foodPositionY = rand.nextInt((MaxLengthOfY-1) + 1);
                //The number -10 is put into the array to represent food. -1 represents an empty space,
                //and positive numbers serve as a timestamp for where the snake is and close to the end of the tail it is.
                snakePosition[foodPositionX][foodPositionY] = -10;
                //increases the length of the snake everytime it eats food.
                CurrentLengthOfSnake++;

            }
//**********************************************************************************************************************
//Work on this:
//Maybe make this an executable file that draws the snake in another window.

            //reset screen

            Thread.sleep(300);
            System.out.flush();  //this does nothing in IntelliJ
        }
    }
}