# Rhyming Words
 
 This assignment illustrates various string operations (substrings, finding/searching for matches, reversing strings, comparison etc.)
 
 The problem is to find words that rhyme with a word that user inputs based on a wordlist.
 
 The algorithm to find rhyming words is implemented in the RhymingWords class as follows:
 
 1. Read words from a dictionary of words or wordlist L
 2. Reverse the words to create new list R and sort the reversed words to yield list R'
 3. Reverse the sorted list R' to yield words with similar endings Rs
 4. Now choose nearby words to a query word (based on their position sorted by ending of the words) in list Rs. 
 
Once this sorted rhyming word set Rs is created, you can query for words that rhyme by inputting your target word for which you need rhyming words
into the program in order to get rhyming words. By default upto 20 words are returned in the vicinity (10 words before and 10 words after the searched word) in alphabetical order. 
If the word searched is towards the beginning or end of the sorted rhyming word list there may be fewer rhyming words returned.

The string reverse method is implemented using 3 different approaches: Java's built-in <code>Collections.reverse</code>, using Java StringBuilder class's <code>reverse</code> method and manual character by character String concatenation using + operator. 
