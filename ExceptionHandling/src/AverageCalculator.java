import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The AverageCalculator class calculates the average of n numbers where n is the initial number entered by the user
 * and throws an exception and asks the user to reenter a number when the user does not enter a positive integer
 * @Author: Vishak Srikanth
 * @Version: 4/21/2021
 */
public class AverageCalculator {

    public static final boolean FILE_INPUT_MODE = false;

    /**
     * isPostiveInteger(String tok):
     * @param tok, a string argument for the method which is supposed to be what a token of what the user enters into
     * the program
     * @return a boolean, whether what the user entered into the program is a positive integer
     */
    public static boolean isPostiveInteger(String tok) {
        //If tok is a null string, the user has not entered a positive integer.
        if (tok == null) {
            return false;
        }
        //If the user enters a string with 0 length, the user has not entered a positive integer.
        int len = tok.length();
        if (len == 0) {
            return false;
        }
        int i = 0;
        //If the user enters a string beginning with -, the user has not entered a positive integer.
        if (tok.charAt(0) == '-') {
            return false;
        }
        //If the user enters a string beginning with +, the user has not entered a positive integer.
        if (tok.charAt(0) == '+') {
            if (len == 1) {
                return false;
            }
            i = 1;
        }
        //If the characters in the string the user enters starting from character i are not characters between 0 and 9
        //inclusive, then the user has not entered a positive integer.
        for (; i < len; i++) {
            char c = tok.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws NonPositiveIntegerException, IOException {
        //create a BufferedReader object to scan console input
        BufferedReader r;

        int n = -1;

        r = new BufferedReader(new InputStreamReader(System.in));


        //keep prompting the user to enter the number of numbers in the list until we get a positive integer from
        //the user
        while (n <= 0) {
            try{
                System.out.println("Please enter a positive integer for number of elements (N): ");
                StringTokenizer st = new StringTokenizer(r.readLine());
                String tok = st.nextToken();
//                boolean ispositiveInteger = tok.matches("^-?[0-9]+");
                //If the string the users enters is not a positive integer then throw a NonPositiveIntegerException.
                if(!isPostiveInteger(tok)) {
                    throw new NonPositiveIntegerException(
                            "Please enter a positive integer value for how many numbers are there in the list for which you want to compute average!");
                }
                n = Integer.parseInt(tok);
            }
            //If a NonPositiveIntegerException exception is thrown print to the user: Please re-enter a positive integer
            //value for number of elements (N):
            catch (NonPositiveIntegerException ex) {
                System.err.println(ex);
                System.err.println("Please re-enter a positive integer value for number of elements (N): ");

            }
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {

            int num = -1;
            while(num <=0) {
                try {
                    //ask for user input for the next number in the list
                    System.out.println("Please enter a positive integer for list element #" + (i+1));
                    StringTokenizer st = new StringTokenizer(r.readLine());
                    String tok = st.nextToken();
                    //If the next user input is negative, then throw a NonPositiveIntegerException
                    if(!isPostiveInteger(tok)) {
                        throw new NonPositiveIntegerException(
                                "Please enter a positive integer value for each number in the list for which you want to compute average!");
                    }
                    num = Integer.parseInt(tok);

                }
                //If a NonPositiveIntegerException exception is thrown print to the user: Please re-enter a positive
                // integer value for list element #, then write the list element number
                catch (NonPositiveIntegerException ex) {
                    System.err.println(ex);
                    System.err.println("Please re-enter a positive integer value for list element #" + (i+1));
                }
            }
            numbers[i] = num;




        }
        //sum the integers in the numbers array
        double s = 0.0;
        for (int i = 0; i < n; i++) {
            s += numbers[i];
        }
        //divide the sum by the number of integers in the numbers array to get the average
        double avg = s/n;
        System.out.println("Average of the " + n + "  numbers entered is: " + String.format("%.4f", avg));



    }
}
