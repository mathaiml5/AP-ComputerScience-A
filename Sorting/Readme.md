# Sorting: Insertion Sort, Merge Sort, and Quick Sort on arrays of integers

### Insertion Sort
Insertion sort works by looking at elements that are smaller than a given element as we move from left to right. At each step we look at element is at index i and we inspect all elements in array to right of this index in each step by
looping through array and finding the smallest element in the remaining right portion of the array. If the smallest element is smaller than the current index it is swapped.

The InsertionSort class also counts the number of swaps/assignments and compares. Additionally a modified version of InsertionSort_v2 which can be used to determine the number of moves and insertions is also implemented.

### Merge Sort

The Merge Sort algorithm recursively calls itself for sorting two halves of a partition of the array and calls the merge method to combine the two sorted halves of a portion of an array.

In sorting N objects, merge sort has an average and worst-case performance of **O(N log N)** If the running time of merge sort for a list of length n is T(n), then the recurrence relation <code>T(n) = 2T(n/2) + n</code> as the algorithm splits and sorts two lists of half the size of the original list, and add the n steps taken to merge the resulting two lists. This is a common pattern for divide-and-conquer recurrences.

### Quick Sort
QuickSort class implements the quicksort algorithm which partitions an array around a pivot element and moves elements so that elements less than the pivot are left of the pivot in the array and elements greater than the pivot are right of the pivot in the array. Then, Quicksort is called again on the left partition of the array and the partition of the array right of the pivot.


The quicksort algorithm has worst case complexity **O(N^2)** however with a better pivoting strategy it can be made to run in average case of **O(N log N)** with a better pivot identification methods such as the <code>MEDIAN of 3</code> using the first, middle and last elements chosen as the pivot. 


Quicksort can be run with 4 strategies for pivot: random element for pivot, choose first element or last element as pivot, or the median of 3 as pivot
