import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * The QuickSort class contains methods which do quicksort, which partitions an array around a pivot and moves elements
 * so that elements less than the pivot are left of the pivot in the array and elements greater than the pivot are right
 * of the pivot in the array. Then, Quicksort is done again on the part of the array left and the part of the array
 * right of the pivot.
 * @author: Vishak Srikanth
 * @version: 4/14/2021
 */
public class QuickSort
{
    //The quicksort algorithm has complexity O(n^2) however with a better pivoting strategy it can be made to
    //run in average case of O(n log n) with a better pivot identification methods such as the MEDIAN of 1st, middle and
    //last elements chosen as the pivot
    // To identify which pivoting strategy we define some constants and set a static variable which represents how we choose the pivot
    // The 4 strategies identified are: random element for pivot, choose first element or last element as pivot, or the median of 3 as pivot
    public static final int RANDOM_PIVOT = 1;
    public static final int FIRST_ELEMENT_PIVOT = 2;
    public static final int LAST_ELEMENT_PIVOT = 3;
    public static final int MEDIAN_OF_3_PIVOT = 4;
    public static int pivotType = LAST_ELEMENT_PIVOT;

    /**
     * partition(int[] arr, int lo, int hi): partitions a portion of an array around a pivot, and sorts the portion of the array,
     * and returns the pivot after this process
     * @param arr, the array to be sorted
     * @param lo, the first index for the portion to be sorted
     * @param hi, the last index for the portion of the array to be sorted
     * @return pivot, the index for the pivot after swaps are made
     */
    public static int partition(int[] arr, int lo, int hi)
    {
        // Partitions arr[lo]...arr[hi] around a pivot.
        // The pivot could be the first element in this section of the array
        // or perhaps a random element in the array.
        // Returns the final resting index of the pivot element
        // (needed for the quicksort recursion)
        int pivot=0;
        //Strategy 1: Use a randomly selected Pivot
        if(pivotType == RANDOM_PIVOT) {
            pivot = lo + (int) (Math.floor(Math.random() * (hi - lo + 1)));
        }
        //Strategy 2: Use first element as Pivot
        else if(pivotType== FIRST_ELEMENT_PIVOT){
            pivot=lo;
        }
        //Strategy 3: Use last element as Pivot
        else if(pivotType== LAST_ELEMENT_PIVOT){
            pivot=hi;
        }
        //Strategy 4: Use median of 3 as Pivot
        else if(pivotType==MEDIAN_OF_3_PIVOT){
            int m1=arr[lo];
            int m2=arr[(lo+hi)/2];
            int m3=arr[hi];
            //find the element from the first,middle, and last element that is less than or equal to another of the 3
            // elements and is greater than or equal to the other of 3 elements
            if((m1<=m2 && m2<=m3)||(m3<=m2 && m2<=m1)){
                pivot=(lo+hi)/2;
            }
            else if((m1<=m3 && m3<=m2)||(m2<=m3 && m3<=m1)){
                pivot=hi;
            }
            else if((m3<=m1 && m1<=m2)||(m2<=m1 && m1<=m3)){
                pivot=lo;
            }
        }


        //Move pivot element to end of array by swapping with element at hi
        int temp0 = arr[hi];
        arr[hi]=arr[pivot];
        arr[pivot]=temp0;
        pivot = hi;

        //i -> represents the index of smallest element
        //j-> loop variable to compare elements in the array with pivot element
        int i = lo - 1 ;
        for (int j =lo  ; j <= hi -1; j++) {
            //If current element is less than the pivot element then increment i and swap the elements at i and j
            if(arr[j]<arr[pivot]){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        //Now swap the hi and the element that is one higher than smallest element as this has been sorted
        int temp2 = arr[hi];
        arr[hi]=arr[i+1];
        arr[i+1]=temp2;
        //The index of the pivot is now the final value of i+1
        pivot=i+1;
        return pivot;
    }

    /**
     * quickSort(int[] arr, int lo, int hi): a method to sort a portion of the array arr
     * @param arr, an array which is supposed to become sorted
     * @param lo,the first element in the portion of the array we are trying to sort
     * @param hi, the last element in the portion of the array we are trying to sort
     */
    public static void quickSort(int[] arr, int lo, int hi)
    {
        if (lo < hi ) // base case is when lo >= hi (nothing to sort)
        {
            // 1. partition the array around the pivot, p
            int p = partition(arr,lo,hi);
            // 2. sort the elements to the left of the pivot
            quickSort(arr,lo,p-1);
            // 3. sort the elements to the right of the pivot
            quickSort(arr,p+1,hi);
        }
    }

    /**
     * sort(int[] arr): a method that calls the quickSort helper method to sort an array
     * @param arr, the array to be sorted
     */
    // this method allows for a more client friendly way of
    // invoking a sort
    public static void sort(int[] arr)
    {
        quickSort(arr,0,arr.length-1);
    }

    /**
     * print(int[] arr): a method to print an array
     * @param arr, the array to be printed
     */
    private static void print(int[] arr)
    {
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1] + "]");
    }


    //tester code
    public static void main (String[] args)
    {
        //int[] numbers = {3,1,4,5,9,2};
        int[] numbers = {5,1,9,2,8,3,7,4,6};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        System.out.println("Unsorted numbers array is: " + Arrays.toString(numbers));
        System.out.println("Unsorted grades array is: " + Arrays.toString(grades));

        //We check that each pivoting strategy produces the corrected sorted array
        pivotType = RANDOM_PIVOT;
        System.out.println("Sorted Arrays After Using Pivoting Strategy: Choose Random Element");
        int[] numberstoSort = numbers.clone();
        int[] gradestoSort = grades.clone();
        //We make a clone of the input arrays and sort those in place
        sort(numberstoSort);
        sort(gradestoSort);
        //Print sorted arrays
        print(numberstoSort);
        print(gradestoSort);

        pivotType = FIRST_ELEMENT_PIVOT;
        System.out.println("Sorted Arrays After Using Pivoting Strategy: Choose First Element");
        numberstoSort = numbers.clone();
        gradestoSort = grades.clone();
        //We make a clone of the input arrays and sort those in place
        sort(numberstoSort);
        sort(gradestoSort);
        //Print sorted arrays
        print(numberstoSort);
        print(gradestoSort);

        pivotType = LAST_ELEMENT_PIVOT;
        System.out.println("Sorted Arrays After Using Pivoting Strategy:  Choose Last Element");
        numberstoSort = numbers.clone();
        gradestoSort = grades.clone();
        //We make a clone of the input arrays and sort those in place
        sort(numberstoSort);
        sort(gradestoSort);
        //Print sorted arrays
        print(numberstoSort);
        print(gradestoSort);

        pivotType = MEDIAN_OF_3_PIVOT;
        System.out.println("Sorted Arrays After Using Pivoting Strategy:  Median of Three (low, mid, high in array)");
        numberstoSort = numbers.clone();
        gradestoSort = grades.clone();
        //We make a clone of the input arrays and sort those in place
        sort(numberstoSort);
        sort(gradestoSort);
        //Print sorted arrays
        print(numberstoSort);
        print(gradestoSort);

    }
}



