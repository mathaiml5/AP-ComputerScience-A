import java.util.Arrays;

/*
    This version of Insertion Sort is from Barron's AP Comp Sci A 2021 book Chapter 9
    This version adds logic to count the number of insertion steps and number of right moves
    See the multiple choice questions Q16-18 below

    For Questions 16–18 refer to the insertionSort method and the private instance variable a, both in a Sorter class.

    Precondition: a[0],a[1]...a[a.length-1] is an unsorted array of Integer objects.
    Postcondition: Array a is sorted in descending order.

        16. An array of Integer is to be sorted biggest to smallest using the insertionSort
        method. If the array originally contains
        1 7 9 5 4 12
        what will it look like after the third pass of the for loop?
        (A) 9 7 1 5 4 12
        (B) 9 7 5 1 4 12
        (C) 12 9 7 1 5 4
        (D) 12 9 7 5 4 1
        (E) 9 7 12 5 4 1

        17. When sorted biggest to smallest with insertionSort, which list will need the
        fewest changes of position for individual elements?
        (A) 5, 1, 2, 3, 4, 9
        (B) 9, 5, 1, 4, 3, 2
        (C) 9, 4, 2, 5, 1, 3
        (D) 9, 3, 5, 1, 4, 2
        (E) 3, 2, 1, 9, 5, 4

        18. When sorted biggest to smallest with insertionSort, which list will need the greatest number of changes in position?
        (A) 5, 1, 2, 3, 4, 7, 6, 9
        (B) 9, 5, 1, 4, 3, 2, 1, 0
        (C) 9, 4, 6, 2, 1, 5, 1, 3
        (D) 9, 6, 9, 5, 6, 7, 2, 0
        (E) 3, 2, 1, 0, 9, 6, 5, 4

 */
public class InsertionSort_v2 {
    private static Integer[] a;
    public static void insertionSort(boolean bAscending){
        System.out.println("Before Sorting Array is " + Arrays.toString(a));
        int insertionStepCount = 0, rightMoveStep =0;
        for (int i = 0; i < a.length; i++) {
            System.out.println("Pass " + (i+1));
            Integer temp = a[i];
            int j = i-1;

            while( j>=0 && (bAscending? temp < a[j] : temp > a[j])){
                System.out.println("Checking that temp: " + temp + (bAscending ? " < " : " > ") + "a[" + j + "] " + a[j]);
                a[j+1] = a[j];
                rightMoveStep++;
               System.out.println("RIGHT MOVE: Moving a[" + j + "] = " + a[j] + " to position " + (j+1));
                j--;

            }
            insertionStepCount++;
            System.out.println("INSERTION STEP: Setting a[" + (j+1) + "] to temp: " + temp);
            a[j+1] = temp;
            System.out.println("After completing pass for i =" + i + " Array is " + Arrays.toString(a));
        }
        System.out.println("Number of Insertion Steps: " + insertionStepCount);
        System.out.println("Number of right moves: " + rightMoveStep);
        System.out.println("After Sorting Array is " + Arrays.toString(a));
    }


    public static void main(String[] args) {
        System.out.println("============================================================================================");
        System.out.println("Problem 16: ");
        Integer[] nums = {1,7,9,5,4,12};
        a = nums;
        insertionSort(false);
        System.out.println("============================================================================================");
        System.out.println("Problem 17A");
        Integer[] nums_q17_a = {5,1,2, 3,4,9};
        a = nums_q17_a;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 17B");
        Integer[] nums_q17_b = {9,5,1,4,3,2};
        a = nums_q17_b;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 17C");

        Integer[] nums_q17_c = {9,4, 2, 5, 1 ,3};
        a = nums_q17_c;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 17D");

        Integer[] nums_q17_d = {9, 3, 5, 1, 4, 2};
        a = nums_q17_d;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 17E");

        Integer[] nums_q17_e = {3, 2, 1, 9, 5, 4};
        a = nums_q17_e;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 18A");
        Integer[] nums_q18_a = {5,1,2,3,4,7, 6, 9};
        a = nums_q18_a;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 18B");
        Integer[] nums_q18_b = {9,5,1,4,3,2, 1, 0};
        a = nums_q18_b;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 18C");
        Integer[] nums_q18_c = {9,4, 6, 2, 1, 5, 1 ,3};
        a = nums_q18_c;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 18D");
        Integer[] nums_q18_d = {9, 6, 9, 5, 6, 7, 2, 0};
        a = nums_q18_d;
        insertionSort(false);

        System.out.println("============================================================================================");
        System.out.println("Problem 18E");
        Integer[] nums_q18_e = {3, 2, 1, 0, 9, 6, 5, 4};
        a = nums_q18_e;
        insertionSort(false);
        System.out.println("============================================================================================");
    }
}
