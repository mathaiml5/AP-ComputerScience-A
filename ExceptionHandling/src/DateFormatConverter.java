import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * The DateFormatConverter class converts dates from numerical month/day/year format to normal “month day, year” format
 * (e.g. inputting "12/25/2000" should print out "December 25, 2000")
 * The code reads in a string checks each of day, month, and year portions of the input are valid and throws appropriate exceptions
 * with the relevant error messages to help the users to correct just the incorrect portion of the input
 * Note: As a convenience (and to keep code simple!) I have tried to avoid extra overhead with object instantiations to run instance
 * methods and extra work for getters and setter methods all the key constants and methods for validation are all defined as static
 * as the main purpose of the exercise is to demonstrate exception handling.
 * @Author: Vishak Srikanth
 * @Version: 4/21/2021
 */
public class DateFormatConverter {

    /**
     *  The constant daysinMonth array contains the # of days in each month of the year
     */
    public static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     *  the constant monthNames contains the names of each month in the year
     */
    public static final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    /** Check if the year string input by user is valid
     * @param tok: token string input which has the year (yyyy) portion of input string
     * @return : true if year is valid, false if invalid
     */
    public static boolean isValidYear(String tok) {
        //Empty year entered by user
        if (tok == null) {
            return false;
        }
        int len = tok.length();
        //If the year string is not four characters long it's invalid
        if (len <= 0 || len != 4) {
            return false;
        }

        //Get the character for the millenium.
        char mil = tok.charAt(0);
        //Any year input that is <= 1000 or > 3000 is invalid
        if (mil < '1' || mil > '3') {
            return false;
        }
        //Check each character after 1st corresponds to a valid digit between 0-9
        for (int i = 1; i < len; i++) {
            char c = tok.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        //If we are here, it means no errors so return true
        return true;
    }

    /** Convert the input date to the formatted date string as specified in the problem
     * @param dd input day
     * @param mm input month (note called after valid month is input by user)
     * @param yyyy input year (note called after valid year is input by user)
     * @return the nicely formatted output string
     * (note function is only called checking tcalled after valid day is input by user)
     */
    public static String convertToDateString(int dd, int mm, int yyyy) {
        return monthNames[mm - 1] + " " + dd + ", " + yyyy;
    }

    /** Check if the month string input by user is valid
     * @param tok: token string input which has the month (mm) portion of input string
     * @return : true if month is valid, false if invalid
     */
    public static boolean isValidMonth(String tok) {
        //Empty month entered by user
        if (tok == null) {
            return false;
        }
        int len = tok.length();
        //month can only be 1 character or 2 characters corresponding to months 1-12
        if (len <= 0 || len > 2) {
            return false;
        }
        //If month is 1 character means unpadded month number is input by user and it needs to be between 1-9
        if (len == 1) {
            char monthDig = tok.charAt(0);
            if (monthDig < '1' || monthDig > '9') {
                return false;
            }
        }
        //If month string has 2 characters
        if (len == 2) {
            //get the 2 characters corresponding to the unit and tens digit of the month
            char monthTensDig = tok.charAt(0);
            char monthUnitsDig = tok.charAt(1);
            //month can't be 00
            if (monthTensDig == '0' && monthUnitsDig == '0') {
                return false;
            }
            //month can't have tens digit < 0 and > 1
            if (monthTensDig < '0' || monthTensDig > '1') {
                return false;
            }
            //month can't have units digit < 0 and > 9
            if (monthUnitsDig < '0' || monthUnitsDig > '9') {
                return false;
            }
            //if months has a tens digit that is 1, it can only be 10, 11, 12
            if (monthTensDig == '1' && (monthUnitsDig < '0' || monthUnitsDig > '2')) {
                return false;
            }
        }
        //If we are here, we have a valid month, so return true
        return true;
    }

    /** Check if day is valid from the month and year (which have already been checked and found to be valid)
     * @param tok: token string input which has the day (dd) portion of input string
     * @param month: integer corresponding to the ordinal month of the year
     * @param year: integer corresponding to year
     * @return: string "OK" if day is valid. If invalid, return the appropriate error message string corresponding to the failed check
     */
    public static String checkValidDay(String tok, int month, int year) {

        //Empty day entered by user
        if (tok == null) {
            return "Empty day field";
        }
        int len = tok.length();
        //If the day is more than 2 or less than 1 digit it's invalid
        if (len < 1 || len > 2) {
            return "Incorrect number of digits in day field (can be 1 or 2 only)";
        }
        //If only single character corresponding to 1 digit date is entered
        if (len == 1) {
            char dayDig = tok.charAt(0);
            //Check if valid digit - single digit day can only have values from 1-9
            if (dayDig < '1' || dayDig > '9') {
                return "Invalid non-numeric character in day field";
            }
        }
        //if day entered has 2 characters corresponding to a 2 digit day
        if (len == 2) {
            char dayTensDig = tok.charAt(0);
            char dayUnitsDig = tok.charAt(1);
            //Day cannot be 00
            if (dayTensDig == '0' && dayUnitsDig == '0') {
                return "00 is not a valid day!";
            }
            //Day cannot have a number < 1 or > 4 for its tens digit
            if (dayTensDig < '0' || dayTensDig > '3') {
                return "You have entered invalid characters for the tens digit of day that are outside of the 1-3 range";
            }
            //Day cannot have a number < 0 or > 9 for its units digit
            if (dayUnitsDig < '0' || dayUnitsDig > '9') {
                return "You have entered invalid characters for the units digit of day that are outside of the 0-9 range";
            }
            //If day starts with 3 in its 10s digits, then the unit digit can only be 0 or 1 (ie valid dates 30 or 31)
            if (dayTensDig == '3' && dayUnitsDig > '1') {
                return "You have entered invalid day that is outside of the 1-31 range";
            }

        }
        //If none of the above error conditions are present in the input string, we parse it to get the day
        int dd = Integer.parseInt(tok);

        //We look up the max # od days for the month entered (note: subtract 1 for zero indexed array)
        int maxMonthDays = daysInMonth[month - 1];

        //For february alone we need to adjust for leap year as the default for february in the daysInMonth array is 28
        if (month == 2) {
            //Set boolean for leap year to false
            boolean isLeap = false;
            //If year is a multiple of 4
            if (year % 4 == 0) {
                // Further if it is a multiple of 100
                if (year % 100 == 0) {
                    // And multiple of 400 then leap
                    if (year % 400 == 0)
                        isLeap = true;
                    //Multiple of 4 and 100 but not 400 not leap year
                    else
                        isLeap = false;
                }
                //If multiple of 4 but not of 100 then leap year
                else
                    isLeap = true;
            }
            //If not multiple of 4 not a leap year
            else {
                isLeap = false;
            }
            //If leap then add 1 more day to the maxdays for February
            if (isLeap) {
                maxMonthDays++;
            }

        }
        //If the days entered is less than or equal to the max # days in that month (after leap year correction) then day is valid
        if (dd <= maxMonthDays) {
            return "OK";
        }
        //Otherwise we have an invalid day corresponding to the month and year entered
        else {
            return "You have entered an invalid day for the month and year given!";
        }

    }

    //Main method needs to throw IO exception since we are using BufferedReader
    public static void main(String[] args) throws IOException {
        BufferedReader r;

        int n = -1;

        r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a date using MM/DD/YYYY format: ");
        /*
            Logic for checking that the input is valid is as follows:
            1. Set date (dd), month (mm), year (yyyy) variables to some default values
            2. Since we need to allow user to only reenter the incorrectly formatted or invalid portion of the data we maintain several booleans
               to indicate status of inputs which are all initialized to false: validYear, validDay, validMonth, validDateFormat
               Then we do a while loop until all portions of the date string are input correctly which is indicated if validInput = true.
               While the validInput is not true we repeat the steps 3-9 below.
            3. User is asked to input the entire date string if validDateFormat=false
            4. Check if the entire date string input by user is entered correctly (i.e in mm/dd/yyyy format), if so we set validDateFormat=true otherwise we raise
               DateFormatException. The catch block prints out the exact error message and provides the user to re-input the entire date string in the correct mm/dd/yyyy format
            5. Then we parse the string and split it at / characters to get the strings correspoding to month, day, and year (monthStr, dayStr, yearStr respectively)
            6. First we check if year string input by user corresponds to a valid year using the isValidYear static method, if valid then function returns true and
               we set validYear=true. If invalid we throw YearException. The catch block prints out the reason why the input year is incorrect and provides the user an opportunity
               to re-input the year string alone in the correct yyyy format
            7. Next we check if month string input by user corresponds to a valid month using the isValidMonth static method, if valid then function returns true and
               we set validMonth=true. If invalid we throw MonthException. The catch block prints out the reason why the input month is incorrect and provides the user an opportunity
               to re-input the month string alone in the correct mm format
            8. Next we check if day string input by user corresponds to a valid day given that the month and year have already been checked in the steps above
               using the isValidDay static method. If valid the function returns "OK" and we set validMonth=true. If invalid, the function returns the exact reason why the day is invalid
                (for example a having 29 as the day for the month of February in a non-leap year) and we throw DayException. The catch block prints
                out the reason why the input day is incorrect and provides the user an opportunity to re-input the day string alone in the correct dd format
            9. If all day, month, and year are valid set validInput = true, otherwise go back to step 3.
         */
        int dd = 1, mm = 1, yyyy = 1000;
        boolean validInput = false;
        boolean validYear =false, validDay=false, validMonth=false, validDateFormat=false;
        String monthStr = new String();
        String dayStr = new String();
        String yearStr = new String();
        while (!validInput) {
            try {

                if(!validDateFormat) {
                    StringTokenizer st = new StringTokenizer(r.readLine());
                    String date = st.nextToken();
                    String[] values = date.split("/");

                    if (values.length != 3) {
                        throw new DateFormatException(
                                "You have entered dates in an invalid format. The correct format is MM/DD/YYYY");
                    }
                     monthStr = values[0];
                     dayStr = values[1];
                     yearStr = values[2];
                     validDateFormat = true;
                }


                if(!validYear) {
                    if (!isValidYear(yearStr)) {
                        throw new YearException(
                                "Please enter a valid year in the range: 1000-3000 ");
                    }
                    yyyy = Integer.parseInt(yearStr);
                    validYear = true;
                }

                if(!validMonth) {
                    if (!isValidMonth(monthStr)) {
                        throw new MonthException(
                                "Please enter a valid month in the range 01-12 if using 2 digits or single digit in range 1-9 if month is less than 10 (no padding) ");
                    }
                    mm = Integer.parseInt(monthStr);
                    validMonth = true;
                }

                if(!validDay) {
                    String valid = checkValidDay(dayStr, mm, yyyy);
                    if (!valid.equals("OK")) {
                        throw new DayException(valid);
                    }
                    dd = Integer.parseInt(dayStr);
                    validDay = true;
                }
                validInput = true;

            } catch (YearException ex) {
                System.err.println(ex);
                System.out.println("Please re-enter a valid year (4 digit YYYY format): ");
                StringTokenizer st = new StringTokenizer(r.readLine());
                yearStr = st.nextToken();
            } catch (MonthException ex) {
                System.err.println(ex);
                System.out.println("Please re-enter a valid month (with or without leading zeros in MM format) : ");
                StringTokenizer st = new StringTokenizer(r.readLine());
                monthStr = st.nextToken();
            } catch (DayException ex) {
                System.err.println(ex);
                System.out.println("Please re-enter a valid day (in DD format) for the month and year given : ");
                StringTokenizer st = new StringTokenizer(r.readLine());
                dayStr = st.nextToken();
            } catch (DateFormatException ex) {
                System.err.println(ex);
                System.out.println("Please re-enter a valid formatted date (MM/DD/YYYY): ");
            }

        }
        //Once the dd, mm, yyyy values are correctly extracted from user input and the date has been validated
        //convert the input date into the formatted date like "MonthName Day, Year" using convertToDateString function
        String dateString = convertToDateString(dd, mm, yyyy);
        //Print the final formatted string
        System.out.println("The converted date is: " + dateString);


    }
}
