# Exception Handling

The main purpose of this exercise is to demonstrate exception handling for various scenarios.

The DateFormatConverter class is implemented to convert dates from numerical month/day/year format to normal “month day, year” format (e.g. inputting "12/25/2000" should print out "December 25, 2000")
The code reads in a string checks each of day, month, and year portions of the input are valid and throws appropriate exceptions with the relevant error messages to help the users to correct just the incorrect portion of the input after properly accounting for leap days, leap years, and number of days in each month.

The AverageCalculator class is implemented to calculate the average of N positive numbers. The user first is required to enter N and is then asked to provide N positive numbers for which she needs the average.
For every user input, the number entered is checked to be > 0 and the program throws an exception and asks the user to reenter a number when the user does not enter a positive integer
