/**
 * RhymingWords is a class that reverses words from a dictionary of words, then sorts the reversed words,
 * un-reverses the sorted list to yield words with similar endings, and finally chooses nearby words to a query word
 * (based on their position sorted by ending of the words) in a list of words. Once this rhyming word set is created,
 * you can query for words that rhyme by inputting your target word for which you need rhyming words
 * into the program in order to get rhyming words. By default upto 20 words are returned in the vicinity
 * (10 words before and 10 words after the searched word) in alphabetical order. If the word searched is towards the
 * beginning or end of the sorted rhyming word list there may be fewer rhyming words returned.
 *
 * @author Vishak Srikanth
 * @version March 17th, 2021
 */
import java.util.*;
import java.io.*;


public class RhymingWords
{
    //Trying 3 different approaches to reversing a string in Java: Using string builder, using Java8 Collections and using String concatenation
    public static final int USING_STRING_BUILDER = 1;
    public static final int USING_COLLECTIONS_REVERSE = 2;
    public static final int USING_STRING_CONCAT = 3;

    /** reverseAllStrings(List<String> inp, int method): a method to reverse a list of strings provided as input using a
     *  string reversal method (tested 3 different methods!)
     * @param inp List of input Strings that need to be reversed
     * @param method the method used to reverse - user needs to provide one of USING_STRING_BUILDER, USING_COLLECTIONS_REVERSE,
     *               or USING_STRING_CONCAT
     * @return list of strings where each string is the reverse of the corresponding string in the input
     */
    public static List<String> reverseAllStrings(List<String> inp, int method){
        int n = inp.size();
        List<String> rev_list = new ArrayList<String>();
        //apply either the reversewithStringBuilder(string), reversewithCollections(string), or the reversewithStringConcat (string)
        //methods to reverse a string
        String[] ret = new String[n];
        if(method == RhymingWords.USING_STRING_BUILDER){
            inp.forEach( (string) -> rev_list.add(reversewithStringBuilder(string)) );
        }

        if(method == RhymingWords.USING_COLLECTIONS_REVERSE){
            inp.forEach( (string) -> rev_list.add(reversewithCollections(string)) );
        }

        if(method == RhymingWords.USING_STRING_CONCAT){
            inp.forEach( (string) -> rev_list.add(reversewithStringConcat (string)) );
        }

        return rev_list;
    }

    /** reversewithStringBuilder(String str): Static method to reverse a string using StringBuilder's reverse function
     * @param str : input String to be reversed
     * @return Reversed string (output)
     */
    //
    public static String reversewithStringBuilder(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }


    /** reversewithCollections(String str): a static method to reverse a string using Collections.reverse()
     * @param str:  input String to be reversed
     * @return Reversed string (output)
     */
    public static String reversewithCollections(String str)
    {
        // base case: if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // create an empty list of characters
        ArrayList<Character> list = new ArrayList<Character>();

        // push every character of the given string into it
        for (char c : str.toCharArray())
            list.add(c);

        // reverse list using java.util.Collections reverse()
        Collections.reverse(list);

        // convert ArrayList into String using StringBuilder and return it
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c : list)
            builder.append(c);

        return builder.toString();
    }

    /**reversewithStringConcat(String str): Static method to reverse a string using string concatenation
     * @param str:  input String to be reversed
     * @return Reversed string (output)
     */
    public static String reversewithStringConcat(String str)
    {
        // return if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // variable to store the reversed string
        String rev = "";

        // use string concatenation operator to build reversed string by
        // reading character from the end of the original string and successively concatenating it
        for (int i = str.length() - 1; i >=0 ; i--)
            rev += str.charAt(i);

        return rev;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // make sure you download wordlist.txt 
        //Create a word list from input words file
        List<String> words = readFile("inputs/wordlist.txt");

        // Helper strings and arrays to draw a dashed line separator
        char[] chars = new char[100];
        Arrays.fill(chars, '-');
        String DASHES = new String(chars);

        // Read the set of wrods from dictionary and stre them in the `words` list
        System.out.println(DASHES);
        System.out.println("Reading Dictionary of Words from Input File:");
        System.out.println("Number of words input: " + words.size());
        System.out.println("The first word is: " + words.get(0));
        System.out.println("The last word is: " + words.get(words.size()-1));
        
        //Reverse All Strings in List
        System.out.println(DASHES);
        List<String> reversed_words = reverseAllStrings(words, RhymingWords.USING_STRING_BUILDER);
        //Checking reverse list got created correctly
        System.out.println("Number of words input in reversed list: " + reversed_words.size());
        System.out.println("The first word in reversed list is: " + reversed_words.get(0));
        System.out.println("The last word in reversed is: " + reversed_words.get(reversed_words.size()-1));
        //I have written the output to a file to make sure the code works, but this process is time consuming so while
        //running the RhymingWords program I commented out the lines outputting the reversed words to a file.
//        PrintWriter out = new PrintWriter("reversed_words.out");
//        for (String line : reversed_words) {
//            out.println(line);
//        }
//        out.close();


        //Sort reversed words to find rhymes easily
        System.out.println(DASHES);
        Collections.sort(reversed_words);
        //Checking reverse list got created correctly
        System.out.println("Number of words in sorted reversed list: " + reversed_words.size());
        System.out.println("The first word in SORTED reversed list is: " + reversed_words.get(0));
        System.out.println("The last word in SORTED reversed is: " + reversed_words.get(reversed_words.size()-1));
        //I have written the output to a file to make sure the code works, but this process is time consuming so while
        //running the RhymingWords program I commented out the lines outputting the sorted reversed words to a file.
//        PrintWriter out1 = new PrintWriter("reversed_sorted_words.out");
//        for (String line : reversed_words) {
//            out1.println(line);
//        }
//        out1.close();

        //Create the sorted rhyming words list
        System.out.println(DASHES);
        List<String> rhyming_words = reverseAllStrings(reversed_words, RhymingWords.USING_STRING_BUILDER);
        //Checking reverse list got created correctly
        System.out.println("Number of words input in rhyming words list: " + rhyming_words.size());
        System.out.println("The first word in rhyming words list is: " + rhyming_words.get(0));
        System.out.println("The last word in rhyming words list is: " + rhyming_words.get(rhyming_words.size()-1));
        //I have written the output to a file to make sure the code works, but this process is time consuming so while
        //running the RhymingWords program I commented out the lines outputting the final ordering of words to a file.
//        PrintWriter out1 = new PrintWriter("rhyming_words_sorted.out");
//        for (String line : rhyming_words) {
//            out1.println(line);
//        }
//        out1.close();

        System.out.println(DASHES);
        //get input from user for the word to find rhyming words for:
        System.out.println("Enter the word for which you need rhyming words:");
        Scanner sc = new Scanner(System.in);
        String searchWord = sc.nextLine();

        //If word input by user exists in the word list from the dictionary of words
        // then reverse the search word,
        if(words.contains(searchWord)){

            // find the index (or position) of the search word in the rhyming words list
            int idx = rhyming_words.indexOf(searchWord);

//            System.out.println("Index of reversed search is: " + idx);

            // find closest matches in the sorted rhymes words list (+/- 10 words from index of the searched word in the rhyme word list)
            // We want the list from left interval: [index -10, index) and right interval: [index+1, index + 11) where [ => included, ) => not included
            // We need to handle boundary conditions where the reverse of the search word we are searching is at the end of the sorted reverse word list
            // Note the element at the upper bound index is NOT included in sublist function, while lower bound is always included
            int left_lower_bound = (idx - 10) > 0 ? (idx - 10) : 0 ;
            int right_upper_bound = (idx + 11) > (words.size() - 1 ) ? (words.size() - 1) : (idx+11) ;
            int left_upper_bound = (idx > 0) ? idx : 0;
            int right_lower_bound = (idx + 1) > (words.size() - 1 ) ? (words.size() - 1) : (idx + 1);
            List<String> rhyme_list = rhyming_words.subList(left_lower_bound, left_upper_bound);
            rhyme_list.addAll(rhyming_words.subList(right_lower_bound, right_upper_bound));
//
            // Sort the words that matched to show them in proper alphabetically sorted order!
            Collections.sort(rhyme_list);
            System.out.println("List of Rhyming Words (sorted in alphabetical order): " + Arrays.toString(rhyme_list.toArray()));
            System.out.println("Number of rhyming words: " + rhyme_list.size());
        }
        //If search word is not found print a message that can't find rhymes
        else{
            System.out.println("Sorry! The word you entered is not in my dictionary, so can't find rhyming words.");
        }
        System.out.println(DASHES);

     }
         
    
    
     /**
      * Reads in all words from a text file and returns it as a List of String objects
      */
     public static List<String> readFile(String fileName){
        // Location of file to read
        File file = new File(fileName);
        List<String> words = new ArrayList<>();
 
        try 
        {
 
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) 
            {
                words.add(scanner.nextLine());   
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return words;
     }
}