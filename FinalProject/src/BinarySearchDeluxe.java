/**
 * Part 2: Binary Search
 * The BinarySearchDeluxe class contains static methods to do a binary search on an array of objects of any type (referenced in <Key> class)
 * for e.g. based on the string prefix or partial search of the query member variable of an array of term objects. The key feature in this
 * enhanced implementation of binary search is that when binary searching a sorted array that contains more than one key equal
 * to the search key, we need to know the index of either the first or the last such key match. This is required in use cases such as when we
 * need to return all the matchin entries in a database that start with the query string progressively when the user starts
 * typing a string in the autocomplete GUI and we wish to show all objects in the loaded database which start with the string
 * Accordingly, we implement the following methods:
 * 1. Return the index of the first key in a[] that equals the search key, or -1 if no such key.
 * 2. Return the index of the last key in a[] that equals the search key, or -1 if no such key.
 * The code also handles corner cases such that each static method throws a java.lang.NullPointerException if any of its arguments is null.
 * Both methods to find first matching index and last mathcing should make at most 1 + ⌈log2 N⌉ compares in the worst case,
 * where N is the length of the array. In this context, a compare is one call to comparator.compare().
 * Note: The binary search relies on the fact the term array is stored in sorted order and uses a custom comparator object provided
 * @author Vishak Srikanth
 * @version 5/20/2021
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Main Binary search class
 */
public class BinarySearchDeluxe {


    /**
     * Final static variables are used only for unit tests and not during autocomplete program
     */
    public static final int FIRST_MATCH_INDEX = 1;
    public static final int LAST_MATCH_INDEX = -1;

    /**
     * Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
     * @param a          : Sorted array of objects being searched
     * @param key        : query key
     * @param comparator : comparator that defies sort order for the array
     * @param <Key>      : type of object
     * @return : 1st matching object within array based on the comparator defined
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        //If either the search list, the key being searched or the comparator are null throw an NPE
        if (a == null || key == null || comparator == null) {
            throw new java.lang.NullPointerException();
        }
        //If the array is empty return -1
        if (a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;
        int mid;
        //Do binary search between left and right indices of the a array but until we arrive at a  subinterval
        //where left and right are separated by at least one other entry (for efficiency so we can handle duplicates
        //in the case of prefix searches for Autocomplete)
        while (left + 1 < right) {
            mid = (left + right) / 2;
            //Since we need the 1st match we continue the binary search even if a[mid] and key object match
            //based on comparator until we continue to look in the left or lower subinterval to find the lowest or left most
            //index match
            if (comparator.compare(key, a[mid]) <= 0) {
                right = mid;
            }
            //if key > a[mid] as per comparator then we need to look at right interval starting from a[mid]
            else {
                left = mid;
            }
        }
        //After we shrink the interval to only the first matched entries we return the appropriate index
        if (comparator.compare(a[left], key) == 0) {
            return left;
        }
        if (comparator.compare(a[right], key) == 0) {
            return right;
        }

        return -1;

    }


    /** Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
     * @param a          : Sorted array of objects being searched
     * @param key        : query key
     * @param comparator : comparator that defies sort order for the array
     * @param <Key>      : type of object
     * @return : last matching object within array based on the comparator defined
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new java.lang.NullPointerException();
        }

        int left = 0;
        int right = a.length - 1;
        int mid;
        //Do binary search between left and right indices of the a array but until we arrive at a  subinterval
        //where left and right are separated by at least one other entry (for efficiency so we can handle duplicates
        //in the case of prefix searches for Autocomplete)
        while (left + 1 < right) {
            mid = (left + right) / 2;
            //Since we need the last match we continue the binary search even if a[mid] and key object match
            //based on comparator until we continue to look in the right subinterval until we find the highest or right most
            //index match
            if (comparator.compare(key, a[mid]) >= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //After we shrink the interval to only the last matched entries we return the appropriate index
        if (comparator.compare(a[right], key) == 0) {
            return right;
        }

        if (comparator.compare(a[left], key) == 0) {
            return left;
        }


        return -1;


    }


    /** This method is utility methods for use in unit tests for the concept of finding first and last index AFTER you have ascertained that a match
     *  exists after searching with regular binary search algorithms - it's only for testing the concept of the other custom object based methods above
     *  and it not directly used in AutoComplete implementation
     * @param a    : Sorted array of objects being searched
     * @param k    : query key
     * @param mode : determines whether we return index of 1st match or last match of the search key in the search array
     * @return : 1st matching object within array based on the comparator defined
     */
    public static int binSearchFirstLastMatch(Integer[] a, int k, int mode) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1;
        int mid = -1;
        if (mode == FIRST_MATCH_INDEX) {

            while (right - left > 1) {
                mid = left + (right - left) / 2;
                if (a[mid] >= k)
                    right = mid;
                else
                    left = mid;
            }
//            System.out.println("At the end we have left: " + left + " mid: " + mid + " right:" + right);
            ans = right;

        }

        if (mode == LAST_MATCH_INDEX) {

            while (right - left > 1) {
                mid = left + (right - left) / 2;
                if (a[mid] <= k)
                    left = mid;
                else
                    right = mid;
            }
//            System.out.println("At the end we have left: " + left + " mid: " + mid + " right:" + right);
            ans = left;

        }
        return ans;


    }

    // Unit testing all the methods in the class with simple boxed Integer arrays and a terms array
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 51, 4, 4, 4, 4, 6, 6, 7, 21, 8, 90, -1, 45, 45, 45};
        Integer[] boxedInts =
                IntStream.of(arr)
                        .boxed()
                        .toArray(Integer[]::new);

        System.out.println("Input Array of Integers: " + Arrays.toString(boxedInts));
        Arrays.sort(boxedInts);
        System.out.println("Array of Integers After Sorting: " + Arrays.toString(boxedInts));
        System.out.println(Arrays.toString(boxedInts));
//        System.out.println(arr.length);
        int key = 4;
        System.out.println("Searching for key: " + key + " in array of Integers....");
//        Testing utility method
        System.out.println("Found first Index of key: " + key + " using utility method is: " + binSearchFirstLastMatch(boxedInts, 4, FIRST_MATCH_INDEX));
        System.out.println("Found last index of key:" + key + " using utility method is: " + binSearchFirstLastMatch(boxedInts, 4, LAST_MATCH_INDEX));

        Comparator<Integer> cmp = (i1, i2) -> Integer.compare(i1, i2);
        System.out.println("Found first Index of key: " + key + " using firstIndexOf method: " + BinarySearchDeluxe.firstIndexOf(boxedInts, 4, cmp));
        System.out.println("Found last Index of key: " + key + " using lastIndexOf method: " + BinarySearchDeluxe.lastIndexOf(boxedInts, 4, cmp));

        Term[] tArray = new Term[10];

        tArray[0] = new Term("abc", 10);
        tArray[1] = new Term("abcdef", 25);
        tArray[2] = new Term("abcdef", 38);
        tArray[3] = new Term("abc", 41);
        tArray[4] = new Term("abbc", 55);
        tArray[5] = new Term("abccdef", 88);
        tArray[6] = new Term("abcd", 88);
        tArray[7] = new Term("zzzz", 88);
        tArray[8] = new Term("abc", 99);
        tArray[9] = new Term("abcd", 41);
        Term test = new Term("abcd", 38);

        System.out.println("Creating an array of Term Objects");
        System.out.println("Array of terms before sorting: " + Arrays.toString(tArray));
        Arrays.sort(tArray);
        System.out.println("Array of terms after sorting lexicographically: " + Arrays.toString(tArray));
        //Note: When the term query strings are identical, term are sorted in the increasing order ot their ordinal position within the original array!
        System.out.println(Arrays.toString(tArray));
        System.out.println("1st match index for search within term array for prefix: "+ test.getQuery().substring(0, 3));
        System.out.println(BinarySearchDeluxe.firstIndexOf(tArray, test, Term.byPrefixOrder(3)));
        System.out.println("The term at this index is " + tArray[BinarySearchDeluxe.firstIndexOf(tArray, test, Term.byPrefixOrder(3))].toString());
        System.out.println("last match index for search within term array for prefix: "+ test.getQuery().substring(0, 2));
        System.out.println(BinarySearchDeluxe.lastIndexOf(tArray, test, Term.byPrefixOrder(2)));
        System.out.println("The term at this index is " + tArray[BinarySearchDeluxe.lastIndexOf(tArray, test, Term.byPrefixOrder(2))].toString());
    }

}
