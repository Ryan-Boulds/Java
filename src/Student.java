//////////////////////////////////////////////////
// Created by Ryan Boulds.
// This is a textbook example.
//This class tracks student information.
//////////////////////////////////////////////////
public class Student {
    private String name;
    private double average;

    //constructor
    public Student(String name, double average) {
        this.name = name;

//allows numbers 0 to 100
        if (average > 0.0) {
            if (average <= 100) {
                this.average = average; //This ASSIGNS a value to the instance variable.
            }
        }

    } //End of constructor.

    //////////////////////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public void setAverage(double average) {
        this.average = average;
        // Allow numbers: (0,100].
        //
        if (average > 0.0) {
            if (average <= 100) {
                this.average = average; //This ASSIGNS a value to the instance variable.
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public double getAverage() {
        return average;
    }

    public String getLetterGrade() {
        String letterGrade = "";
        if (average >= 90) {
            letterGrade = "A";
        }
        if (average >= 80) {
            letterGrade = "B";
        }
        if (average >= 70) {
            letterGrade = "C";
        }
        if (average >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return (letterGrade);
    }
} //End of Student class.
