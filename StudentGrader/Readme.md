# Student Grader

This is a simple program to demonstrate File IO and reading records which are in each row of the input csv files to create 1 object per line and computing some properties on the created objects.

The StudentGrader class creates and stores relevant data for a student record object read from input data for student name, scores in 3 quizzes (each 10 points) midterm (100 points) and final (100 points)

The overall score is calculated using a weighted average (final exam counts for 40% of the grade, midterm counts for, 35% of the grade, 3 quizzes together count for a total of 25% of the grade) and final grade is computed based on:

Any grade of 90 or more is an A,

Any grade of 80 or more (but less than 90) is a B,

Any grade of 70 or more (but less than 80) is a C,

Any grade of 60 or more (but less than 70) is a D, and

Any grade below 60 is an F.

The StudentGrader class reads a csv file where each row has a student record with 3 quiz grades, midterm and final score, looping over all lines in the input file 1 at a time, splits each line on comma delimiter

and creates a StudentRecord object for each line by using the setScoresAndName and then computes the student's average quiz score, overall score, overall percentage, final letter grade using scoreCalculator and stores the

computed values in the appropriate private member variables

As each record is created the toString() method is called on each StudentRecord object to show that the correct values were read in, computed and stored in the private member variables for each StudentRecord
