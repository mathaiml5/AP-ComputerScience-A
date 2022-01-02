# Hangman Game
This is a Java text console based app that allows user to play the word guessing Hangman game
It illsutrates several basic concepts from AP CS A class such as public and private methods, basic OO concepts, loops, string manipulation, 1D arrays, etc.
The program flow is as follows:
1. A Hangman object that holds the current state, images array, title, and phrase list is created and initialized
2. A random string from a dictionary of phrases is loaded as the answer that are loaded into the member variable of Hangman object which is initialized with the missed and guessed counts
3. The program then provides welcome messages and rules of the game.
4. The main logic uses a while loop to check if the user has won already or has lost by exceeding the max number of misses
5. Inside the while loop: repeats the following steps 6-10:
6. prompt the user for a letter to guess and validates until user enters a valid English letter
7. check whether the letter exists in the phrase
8. if letter exists update the string and prints friendly messages to player about how many left, # of misses etc.
9. if all letters have been guessed correctly, user has won, and print message and exit out of the loop.
10. if letter not found, show hangman picture and number of misses and what has been completed and how many letters remain
11. once the while loop is exited, check if user has lost and print the appropriate message
