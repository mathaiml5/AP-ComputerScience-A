/** Part 1: Autocomplete term class
 * Immutable type Term that represents an autocomplete term consisting of a query string and
 * an associated integer weight. This class implements the following methods which supports comparing terms by
 * three different orders:
 * 1. lexicographic order by query string (the natural order);
 * 2. in descending order by weight (an alternate order);
 * 3. lexicographic order by query string but using only the first r characters
 * (a family of alternate orderings).
 *  The last order is used in Part 3 to find all query strings that start with a given prefix
 *  (of length r).
 *  @author Vishak Srikanth
 *  @version 5/20/2021
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/**
 * Main Term class which implements the Comparable<Term> interface
 */
public class Term implements Comparable<Term> {

    //private member variable that holds the search query field
    private String query;
    //private member variable that holds the search term weight
    private long weight;

    /** Getter for search query string field
     * @return : query string
     */
    public String getQuery() {
        return query;
    }

    /** Setter for search query string field
     * @param query: query string
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /** Getter for weight field
     * @return weight field of term object
     */
    public long getWeight() {
        return weight;
    }

    /** Setter for weight field
     * @param weight : weight to be set on term
     */
    public void setWeight(long weight) {
        this.weight = weight;
    }

    /** Initializes a term object with the given query string and weight.
     * @param query : search string
     * @param weight : weight of the term
     */
    public Term(String query, long weight) {
        if(query==null){
            throw new java.lang.NullPointerException("Query cannot be empty. Please enter a non-null value!");
        }
        if (weight < 0) {
            throw new java.lang.IllegalArgumentException("Term Weight needs to be non-negative i.e. cannot be < 0. Please enter a positive value.");
        }
        this.query = query;
        this.weight = weight;
    }

    /** Comparator inner class that implements the logic for comparing terms in descending order of weight
     *  It implements the compare method on 2 term objects by comparing their weights and returning -1 or 0 or 1
     *  depending o whether term1 has a larger, same or smaller weight than term2
     */
    private static class ByReverseWightOrder implements Comparator<Term> {
        /**
         * Compares its two arguments which are terms for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is greater than, equal
         * to, or less than than the second.
         *
         * @param term1 the first term to be compared.
         * @param term2 the second term to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is greater than, equal to, or less than the
         * second since we want the terms in descending order of weight in this
         * sort order
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Term term1, Term term2) {
            //Sorts the terms in descending order of weight
            //if term weights are in descending return -1
            if (term1.weight > term2.weight) {
                return -1;
            }
            //if term weights are equal return 0
            else if (term1.weight == term2.weight) {
                return 0;
            }
            //if term weights are in ascending order enter 1
            else {
                return 1;
            }
        }
    }
    private static class ByPrefixOrder implements Comparator<Term> {
        private int rCharsforComparison;

        private ByPrefixOrder(int rCharsforComparison) {
            this.rCharsforComparison = rCharsforComparison;
        }

        /**
         * Compares two terms for lexicographic order by considering only the first r characters.
         * Returns a negative integer, zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.
         * @param t1 the first term to be compared.
         * @param t2 the second term to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Term t1, Term t2) {
            String s1 = t1.query;
            String s2 = t2.query;
            int minLength = Math.min(s1.length(), s2.length());


            //If the two strings being compared are both longer than the 1st r characters that need to be
            // compared (which is stored in the rCharsforComparison field) then we need to only perform a
            // regular substring compare which does a lexicographic comparison (natural order)
            if (minLength >= rCharsforComparison) {
                return s1.substring(0, rCharsforComparison).compareTo(s2.substring(0, rCharsforComparison));
            }
            //If either of the two strings is shorter than r characters being compared
            else
            {
                //if the 1st minLength characters comparison yields 0 (i.e. 2 strings start with
                // identical sequence of minLength characters) then adjust the output so that
                // if s1 is shorter string we yield the same result as though s1 < s2 lexicographically
                // and if s2 is shorter we yield the same result as though s2 < s1 lexicographically
                int compResult = s1.substring(0, minLength).compareTo(s2.substring(0, minLength));
                if (compResult == 0) {
                    if (s1.length() == minLength){
                        compResult =  -1;
                    }
                    else{
                        compResult = 1;
                    }
                }
                return compResult;
            }
        }
    }

    /** Compares the two terms in descending order by weight.
     * @return byReverseWeightOrder Comparator object from inner static class
     */
    public static Comparator<Term> byReverseWeightOrder() {
            return new ByReverseWightOrder();
    }

    /** Compares the two terms in lexicographic order but using only the first r characters of each query.
     * @param r : the 1st r characters for comparison
     * @return ByPrefixOrder Comparator object from inner static class
     */
    public static Comparator<Term> byPrefixOrder(int r) {
            return new ByPrefixOrder(r);
    }

    /** Compares the two terms in lexicographic order by query.
     * @param that : 2nd term or other term being compared
     * @return : -1, 0, 1 depending on comparison results
     */
    public int compareTo(Term that) {
        return this.query.compareTo(that.getQuery());
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return
                Long.toString(weight) + "\t" +
                        query;
    }

    // Note: This main method is only used during unit testing
    public static void main(String[] args) throws IOException {
        //Read in the terms data from a file given as commandline argument
        String inputFileName = args[0];
        BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));

        int r = Integer.parseInt(args[1]);
        StringTokenizer st = new StringTokenizer(inputFile.readLine());
        //File has total # of terms in file as 1st line
        int numTerms = Integer.parseInt(st.nextToken());
        System.out.println("Loading database:" + inputFileName + ".....");
        Term[] terms = new Term[numTerms];
        //parse each term in file which has weight followed by a tab and then the query string
        for (int i = 0; i < numTerms; i++) {
            st = new StringTokenizer(inputFile.readLine(), "\t");
            // read 1st token weight
            long weight = Long.parseLong(st.nextToken().trim());
            // read the next token which is the query
            String query = st.nextToken();
            // Construct term object
            terms[i] = new Term(query, weight);
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(args[2])));
        //Sort Terms that start with prefix and return them in descending order of weights
        Arrays.sort(terms, new ByPrefixOrder(r));


        //print results to output file
        for(int j=0;j< terms.length;j++){
            pw.println("1st " + r+ " chars:" + terms[j].query.substring(0, r) + "\t" + terms[j].toString());
        }
        inputFile.close();
        pw.close();
    }


}


