
import java.util.*;
import java.io.*;

/**
 * Benford's law, or the first-digit law, is an observation about the 
 * frequency distribution of leading digits in many real-life sets of 
 * numerical data. The law states that in many naturally occurring collections
 * of numbers, the leading digit is likely to be small. For example, in sets 
 * that obey the law, the number 1 appears as the leading significant digit 
 * about 30% of the time, while 9 appears as the leading significant
 * digit less than 5% of the time. If the digits were distributed uniformly, 
 * they would each occur about 11.1% of the time. Benford's law also makes 
 * predictions about the distribution of second digits, third digits, digit 
 * combinations, and so on.
 * Write a program that tests Benford’s Law. You will use data from two 
 * different real-life data sources. The data is stored in two separate text 
 * files: sunspots.txt and librarybooks.txt
 * Feel free to try this program out on other large sets of data!
 * 
 * You will loop through the list of numbers and count how many times 1 is 
 * the first digit, 2 is the first, etc...
 * 
 * Your output/results should look like this:
 * 
 * Analysis of sunspot data:
 * Percentage of numbers starting with 1: 28.24%
 * Percentage of numbers starting with 2: 12.04%
 * Percentage of numbers starting with 3: 9.99%
 * Percentage of numbers starting with 4: 10.34%
 * Percentage of numbers starting with 5: 9.92%
 * Percentage of numbers starting with 6: 8.36%
 * Percentage of numbers starting with 7: 6.28%
 * Percentage of numbers starting with 8: 6.38%
 * Percentage of numbers starting with 9: 5.63%
 * 
 * Analysis of library book data:
 * Percentage of numbers starting with 1: 33.44%
 * Percentage of numbers starting with 2: 17.57%
 * Percentage of numbers starting with 3: 11.14%
 * Percentage of numbers starting with 4: 8.77%
 * Percentage of numbers starting with 5: 7.00%
 * Percentage of numbers starting with 6: 6.13%
 * Percentage of numbers starting with 7: 5.49%
 * Percentage of numbers starting with 8: 5.50%
 * Percentage of numbers starting with 9: 4.95%
 * 
 * @author Vishak Srikanth
 * @version 9/29/20
 */
public class BenfordsLaw
{
    public static void main(String[] args){
        System.out.println("According to Benford's Law, one might expect the" 
        +" following frequency of first digits");
        System.out.println("*************************************************"
        +"***********************************");
        //create an array full of the frequencies as predicted by Benford's
        //law
        final double[]  freq = {0.0, 30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8,
        5.1, 4.6};
        //use a for loop to print each frequency in a print statement
        for (int i = 1; i <=9; i++)
        {
            System.out.println("Percentage of numbers starting with " + i + 
            ": "+ freq[i] + "%");
        }
        //print output
        System.out.println();
        System.out.println("Analysis of sunspot data:");
        printFirstDigitsSunSpots("data/sunspots.txt");
        System.out.println();
        System.out.println("Analysis of library book data:");
        printFirstDigitsLibraryBooks("data/librarybooks.txt");
    }
        
    
    
    /**
     * Opens a file for input and prints out the frequency of 1 as a first 
     * digit, 2 as a first digit, 3 as a first digit, and so forth
     */ 
    private static void printFirstDigitsLibraryBooks(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        
        int totalLines = 0;
        //create an array of freuencies and set frequencies to 0
        int[] freq = new int[10];
        for(int i=0;i<=9;i++){
         freq[i]=0;
        }
        try 
        {
 
            Scanner scanner = new Scanner(file);
            
            // flush out the first 4 lines in the text file
            for (int i = 0; i < 4; i++)
                scanner.nextLine();
                
            while (scanner.hasNextLine())
            {
                //increment 1 to number of lines
               totalLines ++;
               // Read in the next line and make note of the first digit 
               //in a running tally
               //scan line and get first digit in char form and convert char
               //to a integer and increment frequency of that intial digit 
               //by 1
               String line = scanner.nextLine();
               char first_digit = line.charAt(0);
               int first_digit_in_int =
               Integer.parseInt(String.valueOf(first_digit));
               freq[first_digit_in_int]++;
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        // Print out the results of your tally as as a percentage.
        // It should look something like this:
        //
        // Analysis of library book data:
        // Percentage of numbers starting with 1: 33.44%
        // Percentage of numbers starting with 2: 17.57%
        // Percentage of numbers starting with 3: 11.14%
        // Percentage of numbers starting with 4: 8.77%
        // Percentage of numbers starting with 5: 7.00%
        // Percentage of numbers starting with 6: 6.13%
        // Percentage of numbers starting with 7: 5.49%
        // Percentage of numbers starting with 8: 5.50%
        // Percentage of numbers starting with 9: 4.95%
        //create an array of percents for library books
        double[] freq_library_books_percent = new double[10];
        //we dont want to do integer division and get 0 so we make lines 
        //into a double
        double lines_as_double = totalLines;
        //convert frequencies to percents and round to nearest hundreth of a
        //percent
        for(int j=1;j<=9;j++) {
          freq_library_books_percent[j] =((double)Math.round(freq[j] * 100 
          *100 /lines_as_double))/100;
        }
        //print out percent of numbers starting with each digit in a sentence
        //as part of this print statement
        for(int k=1;k<=9; k++) {
          System.out.println("Percentage of numbers starting with " + k +
          ": " + freq_library_books_percent[k] + "%");
        }
 
    }
    
    
    
    /**
     * Opens a file for input and prints out the frequency of 1 as a first 
     * digit, 2 as a first digit,
     * 3 as a first digit, and so forth
     */ 
    private static void printFirstDigitsSunSpots(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        //List<String> movies = new ArrayList<String>();
        //initialize the number of lines to 0 ,and create an array of
        //frequencies of the first digit for sunspot.txt
        int totalLines = 0;
        //create an array of freuencies and set frequencies to 0
        int[] freq_sunspot = new int[10];
        for(int l=0;l<=9;l++){
         freq_sunspot[l]=0;
        }
        try 
        {
 
            Scanner scanner = new Scanner(file);
            
            //flush out the first 3 lines of the file
            for (int i = 0; i < 3; i++)
                scanner.nextLine();
                
            while (scanner.hasNextLine())
            {
                totalLines++;
                // Read in the next sunspot count and make note of the first 
                //digit in a running tally
                // Note: Each line of data looks something like this:   
                //(* Month: 1749 05 *) 85
                // Notice that the integer you are interested comes at 
                //the end of the line.
                // You might use your String methods to extract the character
                //of interest (i.e. '8')
                // Then you might want to convert the char '8' to an int 
                //type. How? 
                //read each line individually
                String line = scanner.nextLine();
                //find ) and move to characters further to get to the first
                //digit
                int index_of_closing_bracket_sunspot = line.indexOf(')');
                int index_of_first_digit_sunspot = 
                index_of_closing_bracket_sunspot + 2;
                //first digit in char from and converting first digit to
                //an int
                char first_digit_sunspot = 
                line.charAt(index_of_first_digit_sunspot);
                int first_digit_in_int_sunspot =
               Integer.parseInt(String.valueOf(first_digit_sunspot));
               freq_sunspot[first_digit_in_int_sunspot]++;
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        // Print out the results of your tally as as a percentage.
        // It should look something like this:
        //
        // Analysis of sunspot data:
        // Percentage of numbers starting with 1: 28.24%
        // Percentage of numbers starting with 2: 12.04%
        // Percentage of numbers starting with 3: 9.99%
        // Percentage of numbers starting with 4: 10.34%
        // Percentage of numbers starting with 5: 9.92%
        // Percentage of numbers starting with 6: 8.36%
        // Percentage of numbers starting with 7: 6.28%
        // Percentage of numbers starting with 8: 6.38%
        // Percentage of numbers starting with 9: 5.63%
        //create an array of doubles to put precents into
        double[] freq_sunspot_percent = new double[10];
        //we dont want to do integer division and get 0 so we make lines 
        //into a double
        double lines_as_double_sunspot = totalLines;
        //make counts into percent and round to nearest hundreth of a percent
        for(int j=1;j<=9;j++) {
          freq_sunspot_percent[j] =((double)Math.round(freq_sunspot[j] * 
          100 * 100 /lines_as_double_sunspot))/100;
        }
        //print output from frequency data table
        for(int k=1;k<=9; k++) {
          System.out.println("Percentage of numbers starting with " + k +
          ": " + freq_sunspot_percent[k] + "%");
        }
        
    }
}