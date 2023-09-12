import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame {
    //sets the initial direction of the snake
    public static String direction = "right";

    //Main
    public static void main(String[] args) throws InterruptedException {

        Random rand = new Random();

        //Declare variables and set initial values.
        boolean snakeIsAlive = true;
        int CurrentLengthOfSnake = 0;
        //MaxLength can be changed to adjust the size of the board that the snake can move around on.
        int MaxLengthOfX = 15;
        int MaxLengthOfY = 15;
        int NumOfTimesLoopRepeats = 0;
        int foodPositionX = rand.nextInt((MaxLengthOfX - 1) + 1);
        int foodPositionY = rand.nextInt((MaxLengthOfY - 1) + 1);


        //initializes array
        int[][] snakePosition = new int[MaxLengthOfX + 2][MaxLengthOfY + 2];
        //assigns -1 to every element in the array/
        for (int i = 0; i < snakePosition.length; i++) {
            for (int j = 0; j < snakePosition.length; j++) {
                snakePosition[i][j] = -1;
            }
        }
        //initial point
        snakePosition[MaxLengthOfX / 2][MaxLengthOfY / 2] = 1;
        //set initial food position
        snakePosition[foodPositionX][foodPositionY] = -10;

        //Open window
        JFrame frame = new JFrame("Snake Game");
        frame.setSize(550, 650);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();

        //This will add the frame in which the snake will be drawn
        frame.add(textArea);

//***********************************************************************************************************************************
//This method gets inputs from the user using the arrow keys

        textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
                    direction = "up";
                } else if (keyCode == KeyEvent.VK_DOWN|| keyCode == KeyEvent.VK_S) {
                    direction = "down";
                } else if (keyCode == KeyEvent.VK_LEFT|| keyCode == KeyEvent.VK_A) {
                    direction = "left";
                } else if (keyCode == KeyEvent.VK_RIGHT|| keyCode == KeyEvent.VK_D) {
                    direction = "right";
                }
            }
        });

//************************************************************************************************************************************

        //Snake Game Loop
        while (snakeIsAlive) {

            //keeps track of how many times loop has repeated.
            // The number of times the loop is repeated is recorded into array location as a timestamp.
            NumOfTimesLoopRepeats++;

            //resets foodHasEaten to false after food has been eaten.
            boolean foodHasEaten = false;

//**********************************************************************************************************************
//graphing which records what to draw in the window into the StringBuilder "printInWindow"
            StringBuilder printInWindow = new StringBuilder();

            //This loop draws the upper horizontal line border.
            for (int i = 0; i < MaxLengthOfX + 1; i++) {
                printInWindow.append("----");
            }
            printInWindow.append("\n");

            //This loop will draw each line.  Thus, this is for graphing the Y coordinates.
            for (int NumOfLinesCounted = 0; NumOfLinesCounted <= MaxLengthOfY; NumOfLinesCounted++) {

                //This will print a | before every single line.Thus making a vertical row on the left.
                printInWindow.append("|");

                //This loop with draw each space or object on the graph.
                for (int spacesPerLine = 0; spacesPerLine < MaxLengthOfX; spacesPerLine++) {

                    //This will print the snake, food, and whitespaces on the board
                    if (snakePosition[spacesPerLine][NumOfLinesCounted] != -1 && snakePosition[spacesPerLine][NumOfLinesCounted] != -10) {
                        printInWindow.append(" O ");
                    } else if (snakePosition[spacesPerLine][NumOfLinesCounted] == -10) {
                        printInWindow.append("@ ");
                    } else {
                        printInWindow.append("     ");
                    }
                }

                //This will print a vertical row on the right.
                printInWindow.append("|\n");
            }
            //This draws the lower horizontal line border
            for (int i = 0; i < MaxLengthOfX + 1; i++) {
                printInWindow.append("----");
            }//End of loops that draw graph

            //Gives user their score everytime they eat food.
            printInWindow.append("\nScore:");
            printInWindow.append(CurrentLengthOfSnake);
            printInWindow.append("             Use Arrow Keys to Control!");
            //Now that the data for the frame is recorded, now it can be printed.
            textArea.setText(printInWindow.toString());
            //Snake Color
            textArea.setForeground(Color.GREEN);
            textArea.setBackground(Color.BLUE);

            textArea.setEditable(false);
            textArea.setBounds(0, 0, 550, 650);
            textArea.setFont(new Font("Symbol BOLD", Font.BOLD, 23));
            frame.setVisible(true);
//**********************************************************************************************************************
//The frame is now drawn in the window.
//Let's give the player time to input a new direction for the snake to travel before getting the input for the next frame.
            Thread.sleep(400);

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
            }//End of detecting where in array the newest addition is located.

//currently takes WASD inputs.
            switch (direction) {
                case "right": //right
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
                            //Snake eats tail.
                            snakeIsAlive = false;
                        }
                    } else {
                        //Snake hits a wall.
                        snakeIsAlive = false;
                    }
                    break;

                case "left"://left
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
                            //Snake eats tail.
                            snakeIsAlive = false;
                        }
                    } else {
                        //Snake hits a wall.
                        snakeIsAlive = false;
                    }
                    break;

                case "up": //up
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
                            //Snake eats tail.
                            snakeIsAlive = false;
                        }
                    } else {
                        //Snake hits a wall.
                        snakeIsAlive = false;
                    }
                    break;

                case "down": //down
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
                            //Snake eats tail.
                            snakeIsAlive = false;
                        }
                    } else {
                        //Snake hits a wall.
                        snakeIsAlive = false;
                    }
                    break;
            }//end of controls
//**********************************************************************************************************************
//Food logic

            //remove old trail
            if (!foodHasEaten) {
                //This will detect the location of a point relative to what time the point was added.
                for (int i = 0; i < snakePosition.length; i++) {
                    for (int j = 0; j < snakePosition[i].length; j++) {
                        if (snakePosition[i][j] == NumOfTimesLoopRepeats - CurrentLengthOfSnake) {
                            snakePosition[i][j] = -1; //resets array values to make it delete places where the snake is.
                        }
                    }
                }//End of detecting which array position is the newest addition.
            }//End Food has not been eaten

//If the snake eats food, then this will choose a random point to put more food.
            if (foodHasEaten) {
                foodPositionX = rand.nextInt((MaxLengthOfX - 1) + 1);
                foodPositionY = rand.nextInt((MaxLengthOfY - 1) + 1);
                //The number -10 is put into the array to represent food. -1 represents an empty space,
                //and positive numbers serve as a timestamp for where the snake is and close to the end of the tail it is.
                snakePosition[foodPositionX][foodPositionY] = -10;
                //increases the length of the snake everytime it eats food.
                CurrentLengthOfSnake++;
            }//End Food has been eaten

        }//End of snakeIsAlive loop

        textArea.setText("Game Over!" + "\nScore: " + CurrentLengthOfSnake);
        textArea.setBounds(0, 0, 750, 750);
        frame.add(textArea);
        textArea.setEditable(false);
        textArea.setFont(new Font("Calibre", Font.BOLD, 50));
        frame.setVisible(true);

    }//End of Main
}//End of Class