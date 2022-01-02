/**
 * MagicSquares2DArray is an exercise to understand 2D arrays with various methods such as finding row sums, column sums, checking for
 * symmetry and determining if a given 2d "sqaure" array is a magic square. (Note: Magic square is a 2D array where both row and column lengths are the
 * same and every row, column, and major diagonal sum to same value)
 *
 * @author Vishak Srikanth
 * @version 11/3/20
 */
public class MagicSquares2DArray
{
      // returns the maximum value in the 2d parameter array 
    /**
     * Method max: determine maximum 
     *
     * @param a 2d parameter array
     * @return the maximum value in the 2d array(max_current): an integer
     */
    public static int max(int[][] a) 
    {
        //check if array is 0 by 0 
        if(a.length>0 && a[0].length>0) {
        //set max for first entry on top left in the array
        int max_current = a[0][0];
        //if there is an element greater than the current maximum update the
        //current maximum to the entry
        for( int i=0; i< a.length ; i++) {
          for( int j=0; j<a[i].length; j++){
              if(a[i][j] > max_current){
                  max_current= a[i][j];
                }
            }
        }
        return max_current;
    }
    //if array is 0 by 0 ,return 0 by default
     else {
        return 0; 
        }
    }

    // returns the sum of the elements in row r of a.
    /**
     * Method rowSum: determine sum of entries in rth row
     *
     * @param a: 2d parameter array
     * @return sum: the sum of the value in row r of the 2d array
     * (sum): an integer
     */
    public static int rowSum(int[][] a, int r)
    {
        //if there is not an row r with length greater than 0
        //return the sum to be the empty sum which is 0
        if(r> a.length || a[r].length==0) {
          return 0;
        }
        //if the rth row has non-zero length sum all the values in row r
        //using a for loop
        else {
            //intiialize sum to empty sum
          int sum=0;
          for(int k=0; k<a[r].length ; k++) {
             sum = sum + a[r][k]; 
        }
          return sum;
         }
    }

    //returns the sum of the elements in column c of a 
    //(careful with rows of different lengths!).
    /**
     * Method columnSum: determine sum of entries in a specified column of the
     * 2d array
     *
     * @param a: 2d parameter array
     * @return sumCol: the sum of the value in column c of the 2d array ,an integer
     */
    public static int columnSum(int[][] a, int c)
    {
      //initialize sum to the empty sum or 0
      int sumCol = 0; 
      //if there exists an entry in the current column being looked at
      // the column r then add the entry in th current row and column c
      //to be added to the current sum
        for(int l=0; l< a.length ;l++) {
           if(a[l].length > c) {
               sumCol = sumCol + a[l][c];
          }
      }
      return sumCol;
     }
    // calculates the row sum for every row and returns each of the values 
    //in an array. 
    // index i of the return array contains the sum of elements in row i.
    /**
     * Method allRowSums: determine an array with each entry being the sum
     * of the entries in each row
     *
     * @param a: 2d parameter array
     * @return sum: sum_rows[], an array of integers
     * 
     */
    public static int[] allRowSums(int[][] a)
    {
        int [] sum_rows = new int[a.length];
        for(int l=0; l<a.length; l++) {
           sum_rows[l] = rowSum(a,l);
        }
        return sum_rows;
    }
        
    // checks if the array is row-magic (this means that every row has the 
    //same row sum).
    /**
     * Method isRowMagic: checks if all rows have the same row sum and returns true if the rows have the same row sum and false if the rows have different
     * row sums
     *
     * @param a: 2d parameter array
     * @return sum: rowMagic, a boolean
     * 
     */
    public static boolean isRowMagic(int[][] a)
    {
        //set RowMagic to true by default
        boolean rowMagic =true;
        //if the array has 1 or more rows find the row sum for all rows by using the allRowSums methords and if any row is not equal to the first row 
        //sum the row sums cannot be equal so set rowMagic to false
        if(a.length>0) {
          int [] sum = allRowSums(a);
          int row_sum =sum[0];
         for(int m=0; m <a.length; m++) {
          if(sum[m]!= row_sum) {
              rowMagic=false;
            }
         }
        }
        //return rowMagic which is true by default even if the array has 0 rows
         return rowMagic;
    }

    //checks if the array is column-magic (this means that every column 
    //has the same column sum).
    /**
     * Method isColumnMagic: checks if all columns have the same column sum and returns true if the columns have the same row sum and false if the 
     * columns have different column sums
     *
     * @param a: 2d parameter array
     * @return sum: columnMagic, a boolean
     * 
     */
    public static boolean isColumnMagic(int[][] a)
    {
        //assume columnMagic is true
        boolean columnMagic =true;
        //find length of longest row to determine number of columns that need to be in our sum
        int max_row_length =0;
        for(int n=0;n<a.length; n++) {
          if(a[n].length>max_row_length) {
              max_row_length = a[n].length;
            }
        }
        //if any column sum is different from the first column sum ,the array is not column magic  
        for(int o=0;o<max_row_length;o++) {
          if(columnSum(a,0) != columnSum(a,o) ) {
              columnMagic = false;
            }
    }
       //even if the array has 0 columns true will be returned and the method will work
       return columnMagic;
    } 
    // checks if the array is square (i.e. every row has the same length 
    //as a itself).
    /**
     * Method isColumnMagic: checks if the arrays is a square array and returns true if the array is square and false if the array is not square
     *
     * @param a: 2d parameter array
     * @return sum: square, a boolean
     * 
     */
    public static boolean isSquare(int[][] a)
    {
        //set square to true by default
        boolean square = true;
        //if we find a row with length different from the length of a ,a is not square (if the square has 0 rows then square becomes true(for loop
        //condition is never satisfied))
        for(int p=0;p<a.length;p++) {
          if(a.length != a[p].length) {
             square = false;
            }
        }
        return square;
    }

    // checks if the array is a magic square. This means that it must be 
    //square,  and that all row sums, all column sums, 
    //and the two diagonal-sums must all be equal. 
    /**
     * Method isMagic: checks if the array is a magic square in which all rows have the same sum which is equal to the sum of all the columns which is 
     * equal to the sum on each of the two diagonal sums and checks if the array is square and finally returns whether the square is a magic square 
     * 
     *
     * @param a: 2d parameter array
     * @return:  a boolean which states whether or not the square is a magic square
     * 
     */
    public static boolean isMagic(int[][] a)
    {
        //First Check if array a is a square array and it is rowmagic and columnmagic
        if(isSquare(a)== true && (isRowMagic(a)==true && isColumnMagic(a)==true)){
            //check if array is empty to avoid IndexOutofBound error
            if(a.length != 0 && a[0].length !=0) {
                // check if row sums and column sums are equal
                if (rowSum(a,0)==columnSum(a,0)){
                  int diagTopLeftToBottomRightSum = 0;
                  //Compute both diagnonal sums for top left -> bottom right and top right
                  // to bototm left
                  for( int q=0; q<a.length; q++) {
                      diagTopLeftToBottomRightSum = diagTopLeftToBottomRightSum + a[q][q];
                    }
                  int diagTopRightToBottomLeftSum = 0;
                  for( int r=0; r<a.length; r++) {
                      diagTopRightToBottomLeftSum = diagTopRightToBottomLeftSum + a[r][a[0].length-1-r];
                    }
                  // Check if both diagonal sums are equal to each other and also equal
                  // the rowsums and columnsums
                  if(diagTopRightToBottomLeftSum == diagTopLeftToBottomRightSum && diagTopRightToBottomLeftSum==rowSum(a,0)){
                      return true;
                    }
                  // If the above checks don't pass then it is not a magic square
                  else{
                      return false;
                    }
                }
                else{
                 return false;
                }
            }
            //If array is empty i.e. 0 x 0 return true 
            else{
             return true;
            }
        }
        else {
          return false;
        }
        
    }
}
