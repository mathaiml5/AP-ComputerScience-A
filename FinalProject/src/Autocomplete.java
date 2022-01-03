/**
 * Part 3: Autocomplete Data Type
 * The Autocomplete class contains the methods to create the top level Autocomplete type which holds an array ot Terms
 * the user can search on. These terms can be sorted based on the query string (natural order) or by the weights of the
 * term queries. The Autocomplete object is created from a text files which represent various databases that can be loaded
 * into memory and queried either using commandline or directly from Autocomplete Swing GUI reference implementation provided by
 * Princeton CS department (file is located at: ftp://ftp.cs.princeton.edu/pub/cs226/autocomplete/AutocompleteGUI.java)
 * The Autocomplete class has following methods:
 * 1. Constructor to read in a text database file and create a sorted array of terms (Sorting can be natural order or
 * ordered by term's weight from highest to lowest either based on the full query string or a partial search prefix of
 * the query string.
 * 2. method to return all matches from the terms in the Autocomplete object based on the string prefix or partial search
 * query as the user enters the text in the GUI or enters a set of characters to get all terms whose query strings start
 * with that prefix. The sort order is by descending order of weight.
 * 3. method to get the number of matches that start with the query prefix entered amongst the terms in the Autocomplete
 * object
 * 4. Helper method to return the length of the longest query string contained within the array of terms
 * A main method is provided to unit test the creation of the Autocomplete object from a text database file and test all
 * the methods in the class perform correctly.
 * Note: The sort implementation used for the terms uses the native Array.sort from Java 8 which uses Quicksort for
 * arrays of primitives and merge sort for arrays of objects.
 * @author Vishak Srikanth
 * @version 5/20/2021
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Autocomplete {

    /**
     * The private variable that holds the list of terms contained in the Autocomplete object
     */
    private Term[] terms;

    /**
     * Constructor that creates the Autocomplete instance from the given array of terms.
     *
     * @param terms : an array of term objects
     */
    public Autocomplete(Term[] terms) {
        //Default Arrays.sort uses the compareTo method on the class which compares the query private variable
        //This optimization is needed so that terms are always stored in lexicographic order for fast retrieval
        // via BinarySearch when using prefix based search during Autocomplete filtering
        Arrays.sort(terms);
        this.terms = terms;
    }

    /**
     * @param inputDBFileName : input text file that contains the terms that can be queried  along with their weights
     *                        which represent their priority (i.e. descending sort order) in the result set returned.
     *                        Several example databases are provided in the data folder in the same project path which
     *                        has sample database files for cities, movies, actors, movie ratings, words, n-grams etc.
     * @throws IOException : When there are read errors on the database files (either not found or incorrectly formatted
     *                        this exception is thrown
     */
    public Autocomplete(String inputDBFileName) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(inputDBFileName));

        StringTokenizer st = new StringTokenizer(inputFile.readLine());
        //File has total # of terms in file as 1st line
        int numTerms = Integer.parseInt(st.nextToken());

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

        inputFile.close();

        //NOTE: We can't call the other constructor with a terms array as argument as the call to invoke other constructot
        // (the statement this(terms) has to be 1st line in the constructor call, so we have no choice but to duplicate
        // some of the code here
        //Default Arrays.sort uses the compareTo method on the class which compares the query private variable
        //This optimization is needed so that terms are always stored in lexicographic order for fast retrieval
        // via BinarySearch when using prefix based search during Autocomplete filtering
        Arrays.sort(terms);
        this.terms = terms;
    }


    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     *
     * @param prefix : query string for the terms (in autocomplete as user types we will perform the search for the prefix
     *               string based on the user input
     * @return all matches of the prefix string amongst the terms list against which we are doing the query
     */
    public Term[] allMatches(String prefix) {
        Term[] matchArray;
        Term queryTerm = new Term(prefix, 0);
        //Find the index of the first and last matching terms using Binary search
        //Note: since we are using Binary search the terms need to be maintained in sorted order as per sorting function
        // based on Comparator class used (here we explicity call the search on the array of terms which are maintained
        // in lexicographic sort order
        //First we find all matching terms based on the partial prefix string which is obtained in natural sort (lexicographic order)
        int firstMatch = BinarySearchDeluxe.firstIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        int lastMatch = BinarySearchDeluxe.lastIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        //Get all the matches between 1st and last matching terms in the sorted term array
        int numMatches = lastMatch - firstMatch + 1;
        if (firstMatch >= 0 && lastMatch >= 0 && firstMatch <= lastMatch) {
            matchArray = new Term[numMatches];
        } else {
            matchArray = new Term[0];
        }
        //copy the terms corresponding all the matches for the prefix string into the final matchArray
        if (matchArray.length != 0) {
            for (int i = 0; i < numMatches; i++) {
                matchArray[i] = terms[firstMatch + i];
            }
        }
        //Since we need the macthing terms descending order of search weight we sort the matched array of terms
        // using the Comparator class which sorts by descending order of term weights !
        Arrays.sort(matchArray, Term.byReverseWeightOrder());
        return matchArray;
    }




    /**
     * Returns the number of terms that start with the given prefix which is needed for Autocomplete
     *
     * @param prefix : query string for the terms (in autocomplete as user types we will perform the search for the prefix
     *               string based on the user input
     * @return : number of matches of the prefix string amongst the terms list against which we are doing the query
     */
    public int numberOfMatches(String prefix) {

        //Create a new term that holds the prefix (starting portion of string) that we are searching in the terms list
        Term queryTerm = new Term(prefix, 0);
        //Note: since we are using Binary search the terms need to be maintained in sorted order as per sorting function
        // based on Comparator class used (here we explicity call the search on the array of terms which are maintained
        // in lexicographic sort order
        //First we find all matching terms based on the partial prefix string which is obtained in natural sort (lexicographic order)
        int firstMatch = BinarySearchDeluxe.firstIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        int lastMatch = BinarySearchDeluxe.lastIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        //Count all the matches beween 1st and last matching terms in the sorter term array
        int numMatches = -1;
        //If the firstMatch and lastMatch index values are >=0 means we have potential matches and
        //if firstMatch <= lastMatch we have at least 1 matching term
        if (firstMatch >= 0 && lastMatch >= 0 && firstMatch <= lastMatch) {
            numMatches = lastMatch - firstMatch + 1;
        }
        // If eithrer firstMatch or lastMatch are negative then we have no matches so we set numMatches to 0.
        if (firstMatch < 0 || lastMatch < 0) {
            numMatches = 0;
        }
        return numMatches;
    }

    /** Helper method to find the term with the longest query string - it is used to determine the width of the
     * Autocomplete search box in the GUI so that the longest result string can be accomodated nicely
     * @return length of the longest term contained in the Autocomplete object
     */
    public int getLongestTermLength(){
        int maxLen = Integer.MIN_VALUE;
        for(Term t: terms){
            String query = t.getQuery();
            maxLen = Math.max(query.length(), maxLen);
        }
        return maxLen;
    }

    // Unit Testing the AutoComplete functionality with a term list file and various queries
    public static void main(String[] args) throws IOException {
        //Read in the terms data from a file given as commandline argument
        String inputTermDBFileName = args[0];
        System.out.println("Loading database:" + inputTermDBFileName + ".....");
        Autocomplete ac = new Autocomplete(inputTermDBFileName);

        // read in queries from text input file (which is provided as the 2nd command lin argument and print out the
        // top N matching terms into an output file specified
        String inputQueryFileName = args[1];
        System.out.println("Reading and performing queries from query file: " + inputQueryFileName + ".....");
        BufferedReader inputQueriesFile = new BufferedReader(new FileReader(inputQueryFileName));

        String outputFile = args[2];
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        StringTokenizer st1 = new StringTokenizer(inputQueriesFile.readLine());
        int N = Integer.parseInt(st1.nextToken());
        //read query string for which we need matches
        String prefix = inputQueriesFile.readLine();
        while (prefix != null ) {
            //Loop through all queries and return the top N matches for the query against the current database loaded inside
            //Autocomplete object
            Term[] termMatches = ac.allMatches(prefix);
            System.out.println("Performing a search in database for query prefix: " + prefix + ".....");
            pw.println("****************************************************************************");
            if(termMatches.length == 0){
                pw.println("No search results for prefix: " + prefix);
            }
            else {
                pw.println("Search results for prefix: " + prefix);
                for (int i = 0; i < Math.min(N, termMatches.length); i++)
                    pw.println(termMatches[i]);
                prefix = inputQueriesFile.readLine();
            }
        }
        System.out.println("Search query output written to output file: " + outputFile + "....." + "Done");
        inputQueriesFile.close();
        pw.close();

    }
}
