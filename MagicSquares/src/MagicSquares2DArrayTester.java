import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals; //for integer arrays only
import org.junit.rules.Timeout;
import org.junit.Rule;


/**
 * JUnit4 test class MagicSquares2DArrayTester
 *
 * @author Vishak Srikanth
 * @version 11/3/20
 */
public class MagicSquares2DArrayTester {

// example arrays for testing
private int[][] basic, allneg, nonsquare, negatives, rowmagic, colmagic, 
                magic, notmagic1, notmagic2, latin, notlatin;

    /**
     * Sets up the test fixture with some arrays to test.
     * This method is called before every test case method.
     */
   @Before public void setUp() {
        basic = new int[][] { {1,2,3}, {4,5,6}, {7,8,9} };
        allneg = new int[][] { {-10,-12,-3}, {-4,-5,-6,-8}, {-7,-8} }; //all neg and ragged
        nonsquare = new int[][] { {1,2,3}, {4,5}, {6,7,8,9} };
        negatives = new int[][] { {1,-2,3}, {4,5,6}, {-7,8,-9} };
        rowmagic = new int[][] { {1,2,3}, {-1,5,2}, {4,0,2} };
        colmagic = new int[][] { {1,-1,4,10}, {3,5,0,-6} };
        latin = new int[][] { {1,2,3}, {2,3,1}, {3,1,2} };
        notlatin = new int[][] { {2,1,3}, {2,3,1}, {3,1,2} };
        magic = new int[][] { {2,2,2}, {2,2,2}, {2,2,2}   };
        notmagic1 = new int[][] { {1,2,3}, {4,5,6}, {6,8,9} }; //diag sums are not equal
        notmagic2 = new int[][] { {1,5,3}, {4,5,6}, {7,8,9} }; //diag sums are equal but rows are not


    }

/** 
 * Test max is found correctly (last element in the search)
 */
@Test public void testMaxNormal() {
    assertEquals(9,MagicSquares2DArray.max(basic));
}

/**
 * Test max correct when all vals are negative 
 */
@Test public void testMaxAllNeg() {
    assertEquals(-3,MagicSquares2DArray.max(allneg));
}

/**
 * Test row sum calculated correctly including for nonsquare arrays
 */
@Test public void testRowSum() {
    assertEquals(6, MagicSquares2DArray.rowSum(basic, 0));
    assertEquals(15, MagicSquares2DArray.rowSum(basic, 1));
    assertEquals(24, MagicSquares2DArray.rowSum(basic, 2));
    assertEquals(30, MagicSquares2DArray.rowSum(nonsquare, 2));
}

/**
 * Test column sum calculated correctly for standard cases
 */
@Test public void testColumnSum() {
    assertEquals(12, MagicSquares2DArray.columnSum(basic, 0));
    assertEquals(15, MagicSquares2DArray.columnSum(basic, 1));
    assertEquals(18, MagicSquares2DArray.columnSum(basic, 2));
}


/**
 * Test column sum calculated correctly for nonsquare arrays
 * This checks for sum of incomplete columns (from ragged arrays)
 */
@Test public void testColumnSumRagged() {
    assertEquals(11, MagicSquares2DArray.columnSum(nonsquare, 2));
    assertEquals(9, MagicSquares2DArray.columnSum(nonsquare, 3));
}

/**
 * Checks array of row sums correctly calculated
 */
@Test public void testAllRowSums() {
    int[] expected = new int[] {6,15,24};
    int[] actual = MagicSquares2DArray.allRowSums(basic);
        assertArrayEquals(expected, actual);
}


/**
 * Test for row magic with a valid magic square
 */
@Test public void testIsRowMagicTrue() {
    assertEquals(true, MagicSquares2DArray.isRowMagic(rowmagic) );
}

/**
 * Test for row magic where row sums are not the same
 */
@Test public void testIsRowMagicFalse() {
   assertEquals(false, MagicSquares2DArray.isRowMagic(basic) );

}

/**
 * Test col magic where col sums are the same
 */
@Test public void testIsColumnMagicTrue() {
    assertEquals(true, MagicSquares2DArray.isColumnMagic(colmagic) );
}

/**
 * Test col magic where col sums are not the same
 */
@Test public void testIsColumnMagicFalse() {
    assertEquals(false, MagicSquares2DArray.isColumnMagic(rowmagic) );
}

/**
 * Test for square arrays
 */
@Test public void testIsSquareTrue() {
  assertEquals(true, MagicSquares2DArray.isSquare(basic));
}

/**
 * Test for non-square arrays
 */
@Test public void testIsSquareFalse() {
  assertEquals(false, MagicSquares2DArray.isSquare(nonsquare));
}

/**
 * Test where all conditions for magic square are met
 */
@Test public void testIsMagicTrue() {
    assertEquals(true, MagicSquares2DArray.isMagic(magic) );
}

/**
 * Test magic square false because row and col sums are not the same
 */
@Test public void testIsMagicNotSquare() {
    assertEquals(false, MagicSquares2DArray.isMagic(allneg) );
}


/**
 * Test magic square false because row and col sums are the same BUT diags are not
 */
@Test public void testIsMagicFalseBadDiags() {
   assertEquals(false, MagicSquares2DArray.isMagic(notmagic1) );
}

/**
 * Test magic square false because (only) row sums are not the same
 */
@Test public void testIsMagicFalseBadRows() {
       assertEquals(false, MagicSquares2DArray.isMagic(notmagic2) );
    }



}