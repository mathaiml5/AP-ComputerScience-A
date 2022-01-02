import java.lang.Math;
import java.util.Arrays;
/**
 * The Jump It class contains a methord called jumpIt which determines the
 * minimum cost to finish a game of jump it.
 * rules of jump it:
 * The game of “Jump It” consists of a board with n positive integers in a 
 * row except for the first column, which always contains zero. These 
 * numbers represent the cost to enter each column. Here is a sample game 
 * board where n is 6:
 * 0	3	80	6	57	10
 * The object of the game is to move from the first column to the last column 
 * in the lowest total cost. The number in each column represents the cost to 
 * enter that column. Always start the game in the first column and have two 
 * types of moves. You can either move to the adjacent column or jump over the 
 * adjacent column to land two columns over. The cost of a game is the sum of 
 * the costs of the visited columns.
 *
 * In the board shown above, there are several ways to get to the end. Starting 
 * in the first column, our cost so far is 0. We could jump to 80, then jump to 
 * 57, then move to 10 for a total cost of 80 + 57 + 10 = 147. However, a 
 * cheaper path would be to move to 3, jump to 6, then jump to 10, for a total
 * cost of 3 + 6 + 10 = 19.
 *
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
public class Jump_It
{
    /**
     * jumpIt(): a method that calculates the minimum cost in a jumpIt game
     *
     * @param  board: the array representing the costs to get into each
     *  column
     * @return the minimum possible costs starting at the leftmost column
     *  and reaching the rightmost column of a board
     */
    public static int jumpIt( int[] board)
    {
        if(board.length <= 2){
          /**  
          * the cost is board[0](0 if the board intially has length 1)
          * for crossing a board with 1 column, 
          * board[0] + board[1] for a board with 2 columns(board[1] if the 
          * board intially has length 1), and 0 for crossing a board with 
          * no columns
          */
          if(board.length==0) {
              return 0;
            }
          else if(board.length==1) {
              return board[0];
            }
          else {
              return board[0] + board[1]; 
            }
        }
        /**
        *the cost of crossing a board with many columns is the cost
        * of the first cell plus the minimum cost for crossing either the
        * board consisting of all columns but the first column, or the
        * board consisting of all but the first two columns( we move 1 or
        * 2 cells to the right every move)
        */
        else {
            return Math.min(board[0] + 
            jumpIt(Arrays.copyOfRange(board, 1, board.length)),board[0]
            + jumpIt(Arrays.copyOfRange(board, 2, board.length)));
        }
    }
}
