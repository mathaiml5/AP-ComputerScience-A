import java.util.Arrays;

public class InsertionSort_v2 {
    private static Integer[] a;
    public static void insertionSort(boolean bAscending){
        System.out.println("Before Sorting Array is " + Arrays.toString(a));
        int insertionStepCount = 0, rightMoveStep =0;
        for (int i = 0; i < a.length; i++) {
//            System.out.println("Pass " + i);
            Integer temp = a[i];
            int j = i-1;

            while( j>=0 && (bAscending? temp < a[j] : temp > a[j])){
//                System.out.println("Checking that temp: " + temp + "> a[" + j + "] " + a[j]);
                a[j+1] = a[j];
                rightMoveStep++;
//                System.out.println("RIGHT MOVE: After completing step for j =" + j + " Array is " + Arrays.toString(a));
                j--;

            }
            insertionStepCount++;
//            System.out.println("INSERTION STEP: Setting a[" + (j+1) + "] to temp: " + temp);
            a[j+1] = temp;
//            System.out.println("After completing pass for i =" + i + " Array is " + Arrays.toString(a));
        }
        System.out.println("NUmber of Insertion Steps: " + insertionStepCount);
        System.out.println("Number of right moves: " + rightMoveStep);
        System.out.println("After Sorting Array is " + Arrays.toString(a));
    }


    public static void main(String[] args) {
        System.out.println("Problem 16: ");
        Integer[] nums = {1,7,9,5,4,12};
        a = nums;
        insertionSort(false);
        System.out.println("Problem 17");
        Integer[] nums_q17_a = {5,1,2, 3,4,9};
        a = nums_q17_a;
        insertionSort(false);
        Integer[] nums_q17_b = {9,5,1,4,3,2};
        a = nums_q17_b;
        insertionSort(false);
        Integer[] nums_q17_c = {9,4, 2, 5, 1 ,3};
        a = nums_q17_c;
        insertionSort(false);
        Integer[] nums_q17_d = {9, 3, 5, 1, 4, 2};
        a = nums_q17_d;
        insertionSort(false);
        Integer[] nums_q17_e = {3, 2, 1, 9, 5, 4};
        a = nums_q17_e;
        insertionSort(false);

        System.out.println("Problem 18");
        Integer[] nums_q18_a = {5,1,2,3,4,7, 6, 9};
        a = nums_q18_a;
        insertionSort(false);
        Integer[] nums_q18_b = {9,5,1,4,3,2, 1, 0};
        a = nums_q18_b;
        insertionSort(false);
        Integer[] nums_q18_c = {9,4, 6, 2, 1, 5, 1 ,3};
        a = nums_q18_c;
        insertionSort(false);
        Integer[] nums_q18_d = {9, 6, 9, 5, 6, 7, 2, 0};
        a = nums_q18_d;
        insertionSort(false);
        Integer[] nums_q18_e = {3, 2, 1, 0, 9, 6, 5, 4};
        a = nums_q18_e;
        insertionSort(false);

    }
}
