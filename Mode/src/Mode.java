/**
 * The Mode class contains a method to produce arrays with entries being random integers between 1 and 365 inclusive
 *,having one hundred elements and finds and prints the mode(most common element) in the array and the frequency of the
 * mode values. If there are more than 1 values in the input list which are the most frequent then all such values are
 * printed. The mode calculation also optionally sorts the input array of integers in ascending order using countsort
 * Since we are given a fixed range of input values (k) and all values are integers we can use countsort algorithm which
 * is very performant i.e. linear time complexity of O(n+K) and space efficient with linear O(n+K) space requirement!!
 * Note: countsort is only efficient when range of values K is not too large compared to n (# of items to be sorted)
 * which is definitely the case for this problem.
 *
 * @author Vishak Srikanth
 * @version 3/17/2021
 */

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

public class Mode {
    // Number of elements in int array that we need to find the mode for
    public static final int arrSize = 100;
    //Range of integer values of the input array from 1...ArrRange
    public static final int arrRange = 365;
    // Stores input array that we need to find the modes for
    private int[] inputArray = new int[arrSize];
    //    private int[] sortedArray = new int[arrSize];
    // modes stores the list of mode values (unique and without duplicates)
    private ArrayList<Integer> modes = new ArrayList<Integer>();
    // Frequency (or count of # of occurrences) of the modes in the array
    private int max_freq;

    // Default constructor -> empty
    public Mode() {

    }


    /** Getter for the inputArray variable
     * @return input array of the Mode object
     */
    public int[] getInputArray() {
        return inputArray;
    }

    /** Constructor with the inputArray variable
     * @param inputArray: sets the input array to this input value passed to constructor
     */
    public Mode(int[] inputArray) {
        this.inputArray = inputArray;
    }

    /** setInputArray(int[] inputArray): Getter for the inputArray variable
     * @param inputArray : sets the input array of Mode instance to this input value passed to method
     */
    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray;
    }

    /** generateInputArray(int n, int K): a method to generate an input array of size n and with all elements in the range 1,2,...,K
     * @param n how many random numbers to generate for the input list
     * @param K what is the range of the integers in the input list i.e integer in the list (1,2..., K)
     * @return array of
     */
    public static int[] generateInputArray(int n, int K){

        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            //Since Random.nextInt(n) returns numbers from 0,1,..., n-1 and we need a number between 1 and K (inclusive)
            // We need to add 1 to Random.nextInt(n-1) to get a number in the range 1,2...K
            val[i] = (new Random().nextInt(K-1)) + 1;
        }
        return val;

    }

    /* calcMode(int[] arr, int k, boolean bSort): Calculate mode uses input array and calculates the modes and their frequencies. Optionally it can sort the input
       array if the bSort binary flag is set
       Since we are given a fixed range of input values (k) and all values are integers we can use countsort algorithm which is O(n+k)
       `inpAarr` ——> the input integer array to be sorted
       `k` ——> the range of values so that such that all integers in input array are in range 1,2,...k
       `bSort` --> flag to determine if you want to do an "in-place" sort using countsort algorithm which is O(n+k)
    */
    public void calcMode(int[] arr, int k, boolean bSort)
    {
        // create the frequency distribution array for all possible inputs
        // in the range of the values that can be in the input array
        // Note: Since the values of Numbers will be from 1,2,3,....K, the freq array's size is set to K+1
        int[] freq = new int[k+1];

        //Create a new list for all the modes
        ArrayList<Integer>  modelist = new ArrayList<>();

        //This is the countsort implementation:
        // 1. We first build the frequency array which maps each number in the range 1,,K to the # of occurences in the inputarray
        // 2. We traverse all the elements of the freq array and just copy the elements in ascending order into a new array!
        // So we are doing 1 pass thru' input array to build freq array and another pass thru' freq. array to get the final sorted list
        // Countsort in this case is very performant i.e. time complexity of O(n+K) and space efficient with linear O(n+K) space requirement!!
        // Note: countsort is only efficient when range of values K is not too large compared to n (# of items to be sorted) which is definitely the case for this problem.

        // using each item the input array as an index, store frequency count in `freq[]`
        for (int i: arr) {
            freq[i]++;
        }

        // variable to store max of freq array
        // this will have the frequency of Mode element in the array (or count of # of times mode occurs)
        max_freq = Arrays.stream(freq).max().getAsInt();

        // overwrite the input array with sorted order if the bSort flag is on, otherwise leave unchanged
        int index = 0;
        for (int i = 0; i < k; i++) {
            //Only check the freq array for values that are present in input array
            if(freq[i] > 0) {
                // Check if this element is one of the modes if so add to modelist
                // Since we are checking through the entire input array, we can get duplicates that we need to remove
                if(freq[i] == max_freq){
                    modelist.add(i);
                }

                if(bSort) {
                    while (freq[i]-- > 0) {
                        arr[index++] = i;
                    }
                }
            }
        }
        // delete duplicates (if any) from 'modelist'
        // LinkedHashList provides set semantics so it removes duplicates
        // Set the private variable of the class to the list of modes
        modes = new ArrayList<Integer>(new LinkedHashSet<Integer>(modelist));

    }
    //Main method which calls other methods that generate the input array and calculates mode and finally prints the results both with and without sorting
    public static void main(String[] args) {


        // Helper strings and arrays to draw a dashed line separator
        char[] chars = new char[1000];
        Arrays.fill(chars, '-');
        String DASHES = new String(chars);

        // Create an input array of arrSize (=100) elements that are in the range 1...arrRange (or in the range 1,...,365)
        // Note: this is done as a general purpose method that can generate an array of given size that has
        // randomly generated integers in a specific range
        int[] val = generateInputArray(Mode.arrSize, Mode.arrRange);

        //We use 2 instances of Mode class to show the differences with the Sorting flag
        Mode myMode1 = new Mode(val.clone());
        Mode myMode2 = new Mode(val.clone());

        System.out.println(DASHES);



        //Input Array before running the mode calculation WITH countsort implemented
        System.out.println("Calculate Mode WITH sorting of Input Array: ");
        System.out.println("Input Array is: " + Arrays.toString(myMode1.inputArray));
        long start = System.nanoTime();
        myMode1.calcMode(myMode1.getInputArray(), Mode.arrRange, true);
        long end = System.nanoTime();;
//        System.out.println("WITH Sorting of Input Array the time is: " + (end-start) + " nanoseconds");
        //Input Array After running the mode calculation WITH countsort implemented which does an "inplace sort"
        System.out.println("Input Array is Now Sorted (After Mode Calculation WITH Sort): " + Arrays.toString(myMode1.inputArray));
        //Print out the mode values and their corresponding frequency
        System.out.println("Mode Values are: " + Arrays.toString(myMode1.modes.toArray()));
        System.out.println("Mode Values Frequency is: " + myMode1.max_freq);
        System.out.println(DASHES);

        //Input Array before running the mode calculation WITHOUT countsort implemented
        System.out.println("Calculate Mode WITHOUT sorting of Input Array: ");
        System.out.println("Input Array is: " + Arrays.toString(myMode2.inputArray));
        long start2 = System.nanoTime();
        myMode2.calcMode(myMode2.getInputArray(), Mode.arrRange, false);
        long end2  = System.nanoTime();;
//        System.out.println("WITHOUT Sorting of Input Array the time is: " + (end2-start2) + " nanoseconds");
        //Input Array After running the mode calculation WITHOUT sorting should be same as the original array
        System.out.println("Input Array is Now Unsorted (After Mode Calculation WITHOUT Sort): " + Arrays.toString(myMode2.inputArray));
        System.out.println("Mode Values are: " + Arrays.toString(myMode2.modes.toArray()));
        System.out.println("Mode Values Frequency is: " + myMode2.max_freq);
        System.out.println(DASHES);
    }

}
