/**
 *
 * StudentGrader: Computes the student's overall score and letter grade given individual's quiz, midterm and final score
 * @author Vishak Srikanth
 * @version 10/6/20
 *
 * Program reads a comma separated file where each row has a student record with 3 quiz grades, midterm and final score
 * The program loops over all lines in the input file 1 at a time, splits each line on comma delimiter
 * Then it creates a StudentRecord object for each line by using the setScoresAndName and then computes the student's
 * average quiz score, overall score, overall percentage, final letter grade using scoreCalculator and stored the
 * computed values in the appropriate private member variables
 * As each record is created the toString() method is called on each StudentRecord object to prove that the correct values
 * were read in, computed and stored in the private member variables for each StudentRecord
 */
import java.io.*;

public class StudentGrader {
    public static void main(String[] args) throws IOException {
        /** Input file is a comma separated file with the following format:
         * Name, Quiz1Score, Quiz2Score, Quiz3Score, MidtermScore, FinalScore
         * For example:
         * George Washington,9,9,8,87,98
         */
        String pathToCsv = "inputs/student_scores_input.csv";
        // Open a new File object
        File csvFile = new File(pathToCsv);
        String row = "";
        // Check if file exists and is not empty
        if (csvFile.isFile()) {
            // create BufferedReader and read data from csv file
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
            //Loop thru' each row which corresponds to 1 student record
            while ((row = csvReader.readLine()) != null) {
                //Split each row into the various elements of the student record
                String[] data = row.split(",");
                //System.out.println("Student [Name=" + data[0] + ", Quiz 1 Score =" + data[1] + ", Quiz 2 Score=" + data[2] + ", Quiz 3 Score=" + data[3] + ", Midterm = " + data[4] + ", Final = " + data[5] +"]");
                String studentName = data[0];
                double quiz1Raw = Double.parseDouble(data[1]);
                double quiz2Raw = Double.parseDouble(data[2]);
                double quiz3Raw = Double.parseDouble(data[3]);
                double midtermRaw = Double.parseDouble(data[4]);
                double finalRaw = Double.parseDouble(data[5]);
                // Create Student record with the data in a single row
                StudentRecord my_rec = new StudentRecord();
                //Set the private member variables and compute percentage scores and store them in the StudentRecord object
                my_rec.setScoresAndName(studentName, quiz1Raw, quiz2Raw, quiz3Raw, midtermRaw, finalRaw);
                // Calculate weighted average scores and then map to Gade based on grading scale
                my_rec.scoreCalculator();
                System.out.println(my_rec.toString());
            }
            csvReader.close();
        }

    }
}
