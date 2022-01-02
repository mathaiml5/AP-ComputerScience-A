import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] d){
        int comparecount = 0, assigncount =0;
        int max = d.length - 1;

        for (int i = 0; i < d.length - 1; i++) {
            //begin element is at i and we inspect all elements in array to right of this element in each step
            int m = i;
            //Loop thru and find the smallest element in the remaining right array
            for (int j = i+1; j < d.length; j++) {
                System.out.println("Comparing if element at j = " + j + " is less than at index m = " + m);
                comparecount++;

                if(d[j] < d[m]){
                    System.out.println(" d[j] = " + d[j] + " <  d[m] = " + d[m]);
                    m = j;
                    System.out.println(" m changed to: " + m + " d[m] = " + d[m]);
                }
            }
            //We can make this more efficient by swapping begin element with the smallest found in each step only when they are not the same we need to swap
            if(i != m) {
                assigncount++;
                System.out.println("Swapping element d[" + i + "] =" + d[i] + " with d [" + m + "]=" + d[m]);
                int temp = d[m];
                d[m] = d[i];
                d[i] = temp;
            }
            System.out.println("After executing j= " + i + " in the loop the array data = " + Arrays.toString(d));
        }
        System.out.println("After executing sort method, the number of comparisons = " + comparecount);
        System.out.println("After executing sort method, the number of swap assignments = " + assigncount);
    }

    public static void main(String[] args) {
                int[] ar = {6, 3, 2, 5, 4,1};
//        int[] ar = {1,2,3, 4,5,6};
        System.out.println("Initial unsorted array is: " + Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
