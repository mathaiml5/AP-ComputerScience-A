import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PepysTest.
 *
 * @author  Vishak Srikanth
 * @version 9/29/20
 */
public class PepysTest
{
    @Test
    public void testProbAtLeastOneSix(){
        Pepys pepys = new Pepys();
        assertEquals(0.6651, pepys.probAtLeastOneSix(1000000), 0.001);
        
        
    }
    
    
    @Test
    public void testProbAtLeastTwoSixes(){
        Pepys pepys = new Pepys();
        assertEquals(0.6187, pepys.probAtLeastTwoSixes(1000000), 0.001);
    }
        
}