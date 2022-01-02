import java.util.Arrays;

/**
 *The MergeSort class has methods to do mergeSort, which recursively does merge sort on two halves on an array and merges the halves.
 * @author: Vishak Srikanth
 * @version:: 4/14/2021
 */
public class MergeSort
{

    // temp is a temporary array that we will use as a copy
    // of the original array so we won't overwrite values
    // in the original; much the same way as we use a temp
    // variable when we swap two values in an array
    private static int[] temp;

    /**
     * sort(int[] arr): calls the merge sort helper method to sort an array
     * @param arr, an array to be sorted
     */
    public static void sort(int[] arr)
    {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * mergeSort(int[] arr, int low, int high): method that calls itself for sorting two halves of a portion of the
     * array and calls the merge method to combine the two sorted halves of a portion of an array
     * @param arr, an array to be sorted
     * @param low, the first index in the portion of the array to be sorted
     * @param high, the last index in the portion of the array to be sorted
     */
    private static void mergeSort(int[] arr, int low, int high)
    {
        if (low >= high)
            return; // base case
        int middle = (low + high)/2;

        mergeSort (arr, low, middle); // sort the left half of the array (it's magic!)
        mergeSort (arr, middle+1, high); // sort the right half of the array

        merge (arr, low, middle, high); // merge the two sorted halves
    }

    /**
     * merge(int[] arr, int low, int middle, int high): used to merge two consecutive sorted portions of an array
     * @param arr, the array from which two sorted parts are to be merged
     * @param low, the first index of the first sorted portion of the array
     * @param middle, the last index of the first sorted portion of the array
     * @param high, the last index of the second sorted portion of the array
     */
    private static void merge(int[] arr, int low, int middle, int high) {

        // merges the two sorted halves:
        // arr[low] to arr[middle] is the left half.
        // arr[middle+1] to arr[high] is the right half.


        // store a copy of arr[low] to arr[high]
        // in temp[low] to temp[high]
        // thus, when merging, we can copy the values
        // from temp and store them in arr without worrying
        // about overwriting values in arr.
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        //FirstHalf is the index being compared from the first sorted portion, and secondHalf is the index being compared from the
        //second sorted portion.
        //Current is the current index which we are changing in the array arr.
        int firstHalf=low;
        int secondHalf=middle+1;
        int current=low;
        //Once we have finished comparing elements from both sorted portions of the array arr we no longer need to change
        //any elements in arr.
        while(firstHalf<=middle || secondHalf<=high){
            //When we have elements to add from both sorted portions of the part of arr being merged, if the element being compared in the
            //second section of the array is greater than or equal to the one from the first section add the element from the first sorted section
            //to arr and look at the next element in the first sorted portion, in addition to adding one to the index to add the next element
            //in the sorted array.
            if ((firstHalf<=middle && secondHalf<=high) &&temp[firstHalf] <= temp[secondHalf] ) {
                arr[current]=temp[firstHalf];
                current++;
                firstHalf++;
            }
            //When we have elements to add from both sorted portions of the part of arr being merged, if the element being compared in the
            //first section of the array is greater than the one from the second section add the element from the second sorted section
            //to arr and look at the next element in the second sorted portion, in addition to adding one to the index in which to add the next element
            //in the sorted array.
            else if((firstHalf<=middle && secondHalf<=high) && temp[firstHalf] > temp[secondHalf] ) {
                arr[current]=temp[secondHalf];
                current++;
                secondHalf++;
            }
            //If we have already add all elements from the first sorted section to the array arr, then the next element to be added is
            //the next element in the second sorted section of the array arr, in addition to adding one to the index in which to add the next element
            //in the sorted array.
            else if(firstHalf>middle){
                arr[current]=temp[secondHalf];
                secondHalf++;
                current++;
            }
            //If we have already add all elements from the second sorted section to the array arr, then the next element to be added is
            //the next element in the first sorted section of the array arr, in addition to adding one to the index in which to add the next element
            //in the sorted array.
            else {
                arr[current]=temp[firstHalf];
                firstHalf++;
                current++;
            }
        }
    }

    /**
     * print(int[] arr): a method to print an array
     * @param arr, the array which we are trying to print
     */
    private static void print(int[] arr)
    {
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]+"]");
    }

    //tester code
    public static void main (String[] args)
    {
        int[] numbers = {3,1,4,5,9,2};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        //Print unsorted arrays
        System.out.println("Unsorted numbers array is: " + Arrays.toString(numbers));
        System.out.println("Unsorted grades array is: " + Arrays.toString(grades));
        System.out.println("Sorting Arrays with MergeSort...");
        sort(numbers);
        sort(grades);
        System.out.println("Sorted Arrays After MergeSort: ");
        print(numbers);
        print(grades);

    }

}

