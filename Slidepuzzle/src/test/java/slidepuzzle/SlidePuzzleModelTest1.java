

package slidepuzzle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SlidePuzzleModelTest1 {
    private SlidePuzzleModel puzzle; 
    public SlidePuzzleModelTest1() {
        

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        puzzle = new SlidePuzzleModel();
        puzzle.reset();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

     
     @Test
     public void has9TilesTest(){
         assertEquals(puzzle.getRows()*puzzle.getCols(),9);
     }
     @Test
     public void only1EmptyTile(){
       
         
     }
     
     
     
     
}
