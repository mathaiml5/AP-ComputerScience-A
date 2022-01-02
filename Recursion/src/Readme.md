# Recursion Examples

This assignment looks at 3 different examples of using recursion.
* Handshakes: Handshake Class implemets a recursive solition to the classic combinatorial problem of counting number of handshakes when we have a certain number of people in a room. 
A recursive approach uses the idea that adding one person into the room means that that person shakes hands with everyone else in the room so the number of handshakes increases by n - 1

* Contains:  The Contains class checks if a string (the "haystack") contains another string (the "needle"). It uses a recursive call to a ContainsHelper
  
  * Start traversing both strings from left to right 
  * Compare the characters in the current index. 
  * If they are the same then advance one character in both haystack and needle (assuming we are always looking for the entire haystack string and not at an offset)
  * If the characters being compared in needle and haystack are not the same then advance one character in haystack.

* JumpIt Game: The Jump It class implements the well know frog jumping game where a frog has to jump over many steps and each step has associated cost with the objective to minimize the cost to get from left to right.
 The implementaiton contains a method called jumpIt which determines the minimum cost to finish a game of jump it.
  The rules of jump it:
  * The game of “Jump It” consists of a board with n positive integers in a row except for the first column, which always contains zero. These numbers represent the cost to enter each column. Here is a sample game board where n is 6:
  
     0	3	80	6	57	10
  * The object of the game is to move from the first column to the last column in the lowest total cost. The number in each column represents the cost to enter that column. 
  * Always start the game in the first column and have two types of moves. You can either move to the adjacent column or jump over the adjacent column to land two columns over. The cost of a game is the sum of the costs of the visited columns.
 
  * In the board shown above, there are several ways to get to the end. Starting in the first column, our cost so far is 0. We could jump to 80, then jump to 57, then move to 10 for a total cost of 80 + 57 + 10 = 147. However, a cheaper path would be to move to 3, jump to 6, then jump to 10, for a total cost of 3 + 6 + 10 = 19.
