import java.util.*;

/**
 *
 * @author Vishak Srikanth
 * @version 1.0
 *
 *
 */
public class SudokuPuzzle {

        /**
         *  Sudoku Puzzle holds the current game object and state
         */
        private int[][] board_solution;
        private int N; // N X N is number of cells with N columns and N rows in Sudoku board_solution
        private int SQ; // SQ x SQ is number of smaller sub-grids
        private int K; // K: Initial Number of squares filled in
        private int[][] initial_board;
        private int[][] board;
        private boolean[][] start;
        private int guess_num;
        private int MAX_MISSES = 5;

        /*
        board—a 9 by 9 array of integers that represents the current state of the puzzle, where 0 indicates a blank square
        start—a 9 by 9 array of boolean values that indicates which squares in board are given values that cannot be changed and the following methods:
        SudokuPuzzle—a constructor that creates an empty puzzle
        toString—returns a string representation of the puzzle that can be printed
        addInitial(row, col, value)—sets the given square to the given value as an initial value that cannot be changed by the puzzle solver
        addGuess(row, col, value)—sets the given square to the given value; the value can be changed later by another call to addGuess
        checkPuzzle—returns true if the values in the puzzle do not violate the restrictions
        getValueIn(row, col)—returns the value in the given square
        getAllowedValues(row, col)—returns a one-dimensional array of nine booleans, each of which corresponds to a digit and is true if the digit can be placed in the given square without violating the restrictions
        isFull—returns true if every square has a value
        reset—changes all of the nonpermanent squares back to blanks (0s)
         */


        /**
         * @return  the N x N board_solution
         */
        public int[][] getBoardSolution(){
            return this.board_solution;
        }

        /**
         * @param b : set the board_solution of the puzzle with a 2-D array b
         */
        public void setBoardSolution(int[][] b){
            this.board_solution = b;
        }


        /**
         * @return  the size of the Sudoku puzzle N, usually 9
         */
        public int getN(){
            return this.N;
        }


        /**
         * @param n: Set the size of the Sudoku puzzle
         */
        public void setN(int n){
            this.N = n;
        }


        /**
         * @return  the size of the subgrid's side SQ within Sudoku puzzle N, typically in 9x9, subgrid is 3x3
         */
        public int getSQ(){
            return this.SQ;
        }

        /**
         * @param n: set the size of the subgrid's side SQ within Sudoku puzzle of side N, typically in 9x9 puzzle subgrid is 3x3
         */
        public void setSQ(int n){
            this.SQ = n;
        }

        /**
         * @return the number of square that are filled in initially at the beginning of game in Sudoku
         */
        public int getK(){
            return this.K;
        }


        /**
         * @param n: set the # of squares that are filled in initially at the beginning of game in Sudoku
         */
        public void setK(int n){
            this.K = n;
        }


        /**
         * @param N: Size of Sudoku puzzle N X N
         * @param K: Number of
         */
        // Constructor
        SudokuPuzzle(int N, int K)
        {
            this.N = N;
            this.K = K;

            // Compute square root of N
            Double SQd = Math.sqrt(N);
            SQ = SQd.intValue();

            board_solution = new int[N][N];
            initial_board = new int[N][N];
            board = new int[N][N];
            start = new boolean[N][N];

        }
//      Generate soltutionand inittialize board
        void startPuzzle() {
//            int[][] s = new int[N][N];
//            int[][] ib = new int[N][N];
            generateSolution();
//            System.out.println(boardtoString(board_solution));
//            s = getBoardSolution();
//            printSudokuBoard(getBoardSolution(), true);
            createInitialBoard();


//            setInitialBoard(ib);
            setCurrentState(cloneArray(getInitialBoard()));
//            System.out.println(boardtoString(board));
//            printSudokuBoard(ib, false);
        }

        // Sudoku Board Generator
        void generateSolution()
        {

            // First Fill the diagonal of SQ x SQ subgrid in the N x N grid
            fillDiagonal();

            // Fill all off-diagonal square cages
            fillRemaining(0, SQ);

            //print Sodoku board_solution
//            printSudokuBoard(board_solution, true);
//            return board_solution;
        }



        // Fill the diagonal SQ number of SQ x SQ cages
        void fillDiagonal()
        {

            for (int i = 0; i<N; i=i+SQ)

                // for diagonal box, start coordinates->i==j
                fillBox(i, i);
        }

        // Returns false if given 3 x 3 block contains num.
        boolean unusedInBox(int rowStart, int colStart, int num)
        {
            for (int i = 0; i<SQ; i++)
                for (int j = 0; j<SQ; j++)
                    if (board_solution[rowStart+i][colStart+j]==num)
                        return false;

            return true;
        }

        // Fill a 3 x 3 cage
        void fillBox(int row, int col)
        {
            int num;
            for (int i=0; i<SQ; i++)
            {
                for (int j=0; j<SQ; j++)
                {
                    do
                    {
                        num = randomGenerator(N);
                    }
                    while (!unusedInBox(row, col, num));

                    board_solution[row+i][col+j] = num;
                }
            }
        }

        // Random generator between 1-9
        int randomGenerator(int num)
        {
            return (int) Math.floor((Math.random()*num+1));
        }

        // Check if number is safe to put in cell
        boolean CheckIfSafe(int i,int j,int num)
        {
            return (unUsedInRow(i, num) &&
                    unUsedInCol(j, num) &&
                    unusedInBox(i-i%SQ, j-j%SQ, num));
        }

        // check in the row for existence of num
        boolean unUsedInRow(int i,int num)
        {
            for (int j = 0; j<N; j++)
                if (board_solution[i][j] == num)
                    return false;
            return true;
        }

        // check in the row for existence of num
        boolean unUsedInCol(int j,int num)
        {
            for (int i = 0; i<N; i++)
                if (board_solution[i][j] == num)
                    return false;
            return true;
        }

        // A recursive function to fill remaining
        // matrix
        boolean fillRemaining(int i, int j)
        {
            // System.out.println(i+" "+j);
            if (j>=N && i<N-1)
            {
                i = i + 1;
                j = 0;
            }
            if (i>=N && j>=N)
                return true;

            if (i < SQ)
            {
                if (j < SQ)
                    j = SQ;
            }
            else if (i < N-SQ)
            {
                if (j== (i/SQ) *SQ)
                    j = j + SQ;
            }
            else
            {
                if (j == N-SQ)
                {
                    i = i + 1;
                    j = 0;
                    if (i>=N)
                        return true;
                }
            }

            for (int num = 1; num<=N; num++)
            {
                if (CheckIfSafe(i, j, num))
                {
                    board_solution[i][j] = num;
                    if (fillRemaining(i, j+1))
                        return true;

                    board_solution[i][j] = 0;
                }
            }
            return false;
        }

        // Create initial board by keeping k-Digits from solution
        void createInitialBoard()
        {

            int count = K;
            initial_board = cloneArray(board_solution);
//            System.out.println("Before initial board: \n" + boardtoString(my_initial_board));
            while (count != 0)
            {
                int cellId = randomGenerator(N*N - 1);
//                System.out.println("Removing item: " + count);
//                System.out.println(" Cell id: " + cellId);
                // extract coordinates i and j
                int i = (cellId/N);
                int j = cellId%9;
                if (j != 0)
                    j = j - 1;

//                System.out.println("Coordinates : " + i+" "+j);
                if (initial_board[i][j] != 0)
                {
                    count--;
                    initial_board[i][j] = 0;
                }
            }
//            initial_board = my_initial_board;
//            System.out.println("After initial board: \n" + boardtoString(initial_board));
//            System.out.println("After solution board: \n" + boardtoString(board_solution));
            populateStartState(initial_board, start);
        }

        //Populate state array
        void populateStartState(int[][] initial_board, boolean[][] start) {
                for(int i =0; i< N; i++){
                    for(int j =0; j < N; j++){
                        if(initial_board[i][j] != 0){
                            start[i][j] = true;
                        }
                        else{
                            start[i][j] = false;
                        }
                    }
                }
        }

        //reset board so that you can start from scratch
        void reset(){
            board = cloneArray(initial_board);
        }

        // is board full
        boolean isFull(){
            boolean full = true;
            for(int i =0; i< N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        full = false;
                        break;
                    }
                }
            }
            return full;
        }

//    get value in cell
        public int getValueIn(int row, int col){
           return board[row][col];
    }

//get all allowed values in a cell
     public boolean[] getAllowedValues(int row, int col){
            boolean[] allowed = {true, true, true, true, true, true, true, true, true};
            int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            int current_cell = board[row][col];
            for(int i = 0; i < N; i++) {
                if (i != col && board[row][i] != 0) {
                    int j = board[row][i] - 1;
                    allowed[j] = false;
                }
                if (i != row && board[i][col] != 0) {
                    int j = board[i][col] - 1;
                    allowed[j] = false;
                }
                int rowStart = (row / 3) * 3;
                int colStart = (col / 3) * 3;
                for (int a = 0; a < SQ; a++) {
                    for (int b = 0; b < SQ; b++) {
                        if((rowStart + a == row) && (colStart + b == col)){
                            continue;
                        }
                        if (board[rowStart + a][colStart + b] != 0) {
                            int p = board[rowStart + a][colStart + b] - 1;
                            allowed[p] = false;
                        }
                    }
                }
            }


        return allowed;

    }

    //addGuess(row, col, value)—sets the given square to the given value; the value can be changed later by another call to addGuess
    void addGuess(int row, int col, int value){
        if(! start[row][col]){
            board[row][col] = value;
        }
    }


// check if rows and columns are ok with no conflicts
    boolean checkRowsAndColumnsAreOK(){
        ArrayList<Integer> num_list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer>[] row_list = new ArrayList[9];
        ArrayList<Integer>[] col_list = new ArrayList[9];
        int okrow_count = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if( board[row][col] !=0 ) {
                    row_list[row].add(board[row][col]);
                    col_list[col].add(board[row][col]);
                }
            }
        }
        int okcount = 0;
        for (int i = 0; i< N; i++){
            if (! hasDuplicate(col_list[i]) && ! hasDuplicate(row_list[i])){
                okcount++;//true
            }
        }

        return (okcount==N);
    }

    //check if cage is OK
    boolean checkBoxisOK(int rowStart, int colStart)
    {
        ArrayList<Integer> num_list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        for (int i = 0; i<SQ; i++)
            for (int j = 0; j<SQ; j++)
                if(board[rowStart+i][colStart+j] != 0){
                    arrli.add(board[rowStart+i][colStart+j]);
                }
        return (!hasDuplicate(arrli));
//        boolean isEqual = num_list.equals(arrli);      //true
//        return isEqual;
    }


//    checkPuzzle—returns true if the values in the puzzle do not violate the restrictions
    boolean checkPuzzle(){
        boolean ok = true;
//        for(int i=0; i < SQ; i+=SQ){
//            for(int j=0; j < SQ; j+=SQ) {
//                int rowStart = i * SQ;
//                int colStart = j * SQ;
//                if (checkBoxisOK(rowStart, colStart)) {
//                    ok_boxcount++;
//                }
//            }
//        }
//
//        return (ok_boxcount == N && checkRowsAndColumnsAreOK());
        puzzlenotOK:
        for(int i=0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] != board_solution[i][j]) {
                        ok = false;
                        break puzzlenotOK;
                    }
                }
            }
        }
        return ok;
    }
//    utility function for duplicates
    public boolean hasDuplicate(ArrayList<Integer> al){
        Set<Integer> seenValues = new HashSet();
        for(Integer value : al){
            if(seenValues.contains(value)){
                return true;
            }
            else{
                seenValues.add(value);
            }
        }
        return false;
    }
// diagnotic function to print all possible values in the board
    void printAllPossibleValuesBoard() {
        for(int i =0; i< N; i++){
            for(int j =0; j < N; j++){
                boolean[] b =getAllowedValues(i,j);
                System.out.print("Allowed values for (" + (i + 1) + ", " + (j + 1) + ")");
                System.out.print("[");
                for(int k =0; k < N; k++){
                    if(b[k])
                        System.out.print( "" + (k + 1) + ", " );
                }
                System.out.print("]");
                System.out.println();

            }
        }
    }
//print all valid values for the cell for Hint function
    void printValidvaluesforCell(int row, int col){
//        System.out.print("Allowed values for (" + row + ", " + col + ")");
        System.out.print("[");
        boolean[] b =getAllowedValues(row, col);
        for(int k =0; k < N; k++){
            if(b[k]) {
                if (k == 0) {
                    System.out.print("" + (k + 1));
                } else {
                    System.out.print(", " + (k + 1));
                }
            }
        }
        System.out.print("]");
    }

    /* Prints the current state of the Sudoku board with the following pattern
    +-------+-------+-------+
    | 5 3 . | . 7 . | . . . |
    | 6 . . | 1 9 5 | . . . |
    | . 9 8 | . . . | . 6 . |
    +-------+-------+-------+
    | 8 . . | . 6 . | . . 3 |
    | 4 . . | 8 . 3 | . . 1 |
    | 7 . . | . 2 . | . . 6 |
    +-------+-------+-------+
    | . 6 . | . . . | 2 8 . |
    | . . . | 4 1 9 | . . 5 |
    | . . . | . 8 . | . 7 9 |
    +-------+-------+-------+
     */
        // Print sudoku
        public void printSudokuBoard(int[][] board, boolean is_sol)
        {

            for (int i = 0; i<N; i++) {
                if (i % 3 == 0) {
                    System.out.println("+----------+----------+----------+");
//                    System.out.println("+-----------+-----------+-----------+");
                }
//                System.out.print("| ");
                for (int j = 0; j < N; j++){
                    if (j % 3 == 0) {
                        System.out.print("| ");
                    }
                    if (!is_sol && board[i][j] == 0) {
                        System.out.print(" . ");
                    } else {
                        System.out.print(" " +board[i][j] + " ");
                    }
                }
                System.out.println("| ");
//                System.out.println("+-----------+-----------+-----------+");
            }
            System.out.println("+----------+----------+----------+");
            System.out.println();
        }


    /**
     * @return the starting or initial board
     */
    public int[][] getInitialBoard() {
        return initial_board;
    }

    /**
     * @param initial_board : set the initial board of this game to the 2-d integer array
     */
    public void setInitialBoard(int[][] initial_board) {
        this.initial_board = initial_board;
    }

    /**
     * @param current_state : set the current state to 2D integer array
     */
    public void setCurrentState(int[][] current_state) {
        this.board = current_state;
    }

    /**
     * @return get the current state of the game with Sudoku board
     */
    public int[][] getCurrentState() {
        return board;
    }

    public int[][] cloneArray(int[][] source){
        int[][] destination = new int[source.length][];

        for (int i = 0; i < destination.length; ++i) {

            // allocating space for each row of destination array
            destination[i] = new int[source[i].length];

            for (int j = 0; j < destination[i].length; ++j) {
                destination[i][j] = source[i][j];
            }
        }
        return destination;
    }


    public String boardtoString(int[][] board){
        String a = new String();
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                a = a + board[i][j] + " ";
            }
            a = a + "\n";
        }
        return a;
    }

    /**
     * @return the boolean 2-d array that represents the starting board with 1 for values shown
     */
    public boolean[][] getStart() {
        return start;
    }

    /**
     * @param start the boolean 2-d array that represents the starting board with 1 for values shown
     */
    public void setStart(boolean[][] start) {
        this.start = start;
    }

    /**
     * @return max # of misses allowed
     */
    public int getMAX_MISSES() {
        return MAX_MISSES;
    }


    /**
     * @param MAX_MISSES : max number of misses
     */
    public void setMAX_MISSES(int MAX_MISSES) {
        this.MAX_MISSES = MAX_MISSES;
    }
}




