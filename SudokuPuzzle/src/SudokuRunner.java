import java.util.*;


/**
 *  *  The main client or runner for the Sudoku game which runs the game:
 *  *  1. creates the SudokuPuzzle object, initializes the states and prints image of starting board
 *  *  2. uses a while loop to check if the user has won already or has lost by exceeding the max number of misses
 *  *  3. displays the rules of the game and prompts user to enter their guess
 *  *  4. checks guess for correctness
 *  *  5.  if correct moves onto another guess
 *  *  6. inside the while loop for incorrect: e:
 *  *  6a. prompts the user for option to reset, hint or guess again
 *  *  7. once the while loop is exited, check if user has lost and print the appropriate message
 */
public class SudokuRunner {
    // Driver code
    public static void main(String[] args)
    {
        int N = 9, K = 5;
        SudokuPuzzle sudoku = new SudokuPuzzle(N, K);


        System.out.println("   _____               _           _");
        System.out.println("  / ____|             | |         | |");
        System.out.println(" | (___    _   _    __| |   ___   | | __  _   _");
        System.out.println("  \\___ \\  | | | |  / _` |  / _ \\  | |/ / | | | |");
        System.out.println("  ____) | | |_| | | (_| | | (_) | |   <  | |_| |");
        System.out.println("|_____/    \\__,_|  \\__,_|  \\___/  |_|\\_\\  \\__,_|");
        System.out.println();
        System.out.println("Let's Play Sudoku!");
        System.out.println("Sudoku puzzle has a 9x9 board with 3x3 cages where each cell holds a number between 1-9");
        System.out.println("In every solution, there is only 1 of each number 1-9 in each cell and row as well as in the each 3x3 cage");
        System.out.println("I will create a starting board where some numbers will be filled up. You need to guess each missing number");
        System.out.println("which will be represented by a .(dot). At each step, you can choose to guess a value for a partuicalr cell that");
        System.out.println("is not filled. The rows and columns are numbered in cartesian coordinates starting with (1,1) on top lect to");
        System.out.println("(9,9) in bottom right. After each guess if you guessed correctly or not. If you guessed incorrectly 5 times you");
        System.out.println("lose. When you guess incorectly, I will prompt you to make another guess or ask for a hint or reset the board");
        System.out.println("and start from the beginning. You win if yon can guess all the missing numbers on the puzzle before you run out of misses.");
        System.out.println("Good Luck!!!");

            RESTART:
        sudoku.startPuzzle();
//        int[][] sol = sudoku.getBoardSolution();
//        System.out.println(sudoku.toString());
//        int[][] init = sudoku.getCurrentState();
//        sudoku.printSudokuBoard(sudoku.getBoardSolution(),true);
//         test print solution
        sudoku.printSudokuBoard(sudoku.getCurrentState(),false);
//        Test print all possible solution values in baord
//        sudoku.printAllPossibleValuesBoard();

        int miss_count = 0;
        boolean won_game = false;
        boolean same_cell_flag = false;

        //At each step of the game prompt user for the current row, column of cell and the guess
        int current_row_guess = 0;
        int current_col_guess = 0;
        int current_cell_guess = 0;
        int current_col_index = -1;
        int current_row_index = -1;
        ArrayList<Integer> incorrect_guess_list_for_cell = new ArrayList<Integer>();

        //As long as the number of misses is < 10 and the player has not won the game by correctly guessing all empty squares in puzzle
        while((miss_count <= sudoku.getMAX_MISSES()) && !won_game) {



            // Prompt the user to enter a row and a column of the cell and guess value for the cell until valid inpus are presented
            if(same_cell_flag == false) {

                System.out.println("Enter row position [1-9]: ");
                Scanner scan_row = new Scanner(System.in);
                boolean invalid_row;
                do {
                    String rowpos = scan_row.next();

                    invalid_row = (rowpos.length() != 1) || !(Integer.parseInt(rowpos, 10) >= 1 && Integer.parseInt(rowpos, 10) <= 9);
                    if (invalid_row) {
                        System.out.println("Please re-enter a single valid number in the range 1-9");
                        invalid_row = true;
                    } else {
                        current_row_guess = Integer.parseInt(rowpos, 10);
                        current_row_index = current_row_guess - 1;
                        invalid_row = false;
                    }
                } while (invalid_row);

                System.out.println("Enter col position [1-9]: ");
                Scanner scan_col = new Scanner(System.in);
                boolean invalid_col;
                do {
                    String colpos = scan_col.next();

                    invalid_col = (colpos.length() != 1) || !(Integer.parseInt(colpos, 10) >= 1 && Integer.parseInt(colpos, 10) <= 9);
                    if (invalid_col) {
                        System.out.println("Please re-enter a single valid number in the range 1-9");
                        invalid_col = true;
                    } else {
                        current_col_guess = Integer.parseInt(colpos, 10) ;
                        current_col_index = current_col_guess - 1;
                        invalid_col = false;
                    }
                } while (invalid_col);
            }

            System.out.println("Enter the value for the cell in position [" + current_row_guess + ", " + current_col_guess + "] : ");
            Scanner scan_value = new Scanner(System.in);
            boolean invalid_value;
            do {
                String guess_val = scan_value.next();
                current_cell_guess = Integer.parseInt(guess_val, 10);
                invalid_value = (guess_val.length() != 1) || !(current_cell_guess >= 1 && current_cell_guess <= 9);
                if (invalid_value) {
                    System.out.println("Please re-enter a single valid number in the range 1-9");
                    invalid_value = true;
                }
            } while (invalid_value);


            // Keep prompting player for a guess until player enters a valid uppercase or lowercase letter
            if (sudoku.getValueIn(current_row_index, current_col_index) != 0) {
                boolean[][] st = sudoku.getStart();
                if(st[current_row_index][current_col_index]){
                    System.out.println("This cell at: [ " + current_row_guess + ", " + current_col_guess + "] has already been filled in initially! Try another cell!");
                }
//                if(sudoku.getValueIn(current_row_guess, current_col_guess))
                else {

                    System.out.println("At [ " + current_row_guess + ", " + current_col_guess + "] : You have already filled this cell of the puzzle! Try another cell! ");
                }
            } else {
                sudoku.addGuess(current_row_index, current_col_index, current_cell_guess);
                boolean correct_guess = sudoku.checkPuzzle();
                if(correct_guess) {
                    System.out.println("Great! Your Guess of " + current_cell_guess + " for the cell at: [ " + current_row_guess + ", " + current_col_guess + "] is CORRECT!");
                    if(sudoku.isFull() && sudoku.checkPuzzle()){
                        System.out.println("Congratulations, you WON! You have correctly guessed all missing numbers on the puzzle board!");
                        won_game = true;
                    }
                    sudoku.printSudokuBoard(sudoku.getCurrentState(),false);
                    same_cell_flag = false;
                    incorrect_guess_list_for_cell.clear();
                }
                else{

                    if(incorrect_guess_list_for_cell.contains(current_cell_guess)){
                        System.out.println("You already guessed " + current_cell_guess + " for the cell at: [ " + current_row_guess + ", " + current_col_guess + "]. Please try again!");
                        sudoku.addGuess(current_row_index, current_col_index, 0);
                        same_cell_flag = true;
                    }
                    else {
                        miss_count++;

                        System.out.println("Sorry! Your Guess of " + current_cell_guess + " for the cell at: [ " + current_row_guess + ", " + current_col_guess + "] is INCORRECT!");
                        System.out.println("Sorry! You have missed " + miss_count + " out of " + sudoku.getMAX_MISSES() + " Allowed !");
                        System.out.println("Would you like to A) Undo Previous Guess and Continue B) Get a Hint for valid values in this cell and Continue C) Reset and Start over with the same puzzle");
                        System.out.println("Enter A, B, or C : ");
                        Scanner scan_sel = new Scanner(System.in);
                        boolean invalid_sel;
                        char user_choice = '\0';
                        do {
                            String sel = scan_sel.next();

                            invalid_sel = (sel.length() != 1) || (!((sel.charAt(0) >= 'A' && sel.charAt(0) <= 'C') || (sel.charAt(0) >= 'a' && sel.charAt(0) <= 'z')));
                            if (invalid_sel) {
                                System.out.println("Please re-enter a valid choice (A,B, or C)");
                                invalid_sel = true;
                            } else {
                                user_choice = sel.toUpperCase().charAt(0);
                                invalid_sel = false;
                            }
                        } while (invalid_sel);

                        // If user chooses option A erase previous guess and continue
                        if (user_choice == 'A') {
                            sudoku.addGuess(current_row_index, current_col_index, 0);
                            sudoku.printSudokuBoard(sudoku.getCurrentState(), false);
                            incorrect_guess_list_for_cell.add(current_cell_guess);
                            same_cell_flag = true;

                        }
                        //if user chooses option B then provide a hint for the same cell
                        else if (user_choice == 'B') {
                            sudoku.addGuess(current_row_index, current_col_index, 0);
                            System.out.print("For the cell at: [ " + current_row_guess + ", " + current_col_guess + "], the valid choices are: ");
                            sudoku.printValidvaluesforCell(current_row_index, current_col_index);
                            System.out.println();
                            sudoku.printSudokuBoard(sudoku.getCurrentState(), false);
                            incorrect_guess_list_for_cell.add(current_cell_guess);
                            same_cell_flag = true;

                        } else if (user_choice == 'C') {
                            System.out.print("Resetting Board...");
                            System.out.println();
                            sudoku.reset();
                            miss_count = 0;
                            same_cell_flag = false;
                            incorrect_guess_list_for_cell.clear();
                            sudoku.printSudokuBoard(sudoku.getCurrentState(), false);
                        }

                    }
                }
            }


        }


    }
}
