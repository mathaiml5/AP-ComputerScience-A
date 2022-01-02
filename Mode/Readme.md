# Mode

This assignment focuses on calculating mode (most frequent value) in a list of numbers with and wtihout sorting.

The Mode class contains a method to produce a an array of N numbers (default is N=100) with entries being random integers between 1 and K inclusive (default K = 365) and finds and prints the mode(most common element) in the array and the frequency of the mode values. 
If there are more than 1 values in the input list which are the most frequent then all such values areprinted. The mode calculation also optionally sorts the input array of integers in ascending order using <code>countsort</code>

Since we are given a fixed range of input values (K) and all values are integers we can use countsort algorithm which is very performant i.e. linear time complexity of **O(N+K)** and space efficient with linear **O(N+K)** space requirement!!

Note: Countsort is only efficient when range of values K is not too large compared to N (# of items to be sorted) which is definitely the case for this problem.
