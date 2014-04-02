package slidepuzzle;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SlidePuzzleModelTest1 {
    private SlidePuzzleModel puzzle;
    private int row = (int) Math.random() * 2;
    private int col = (int) Math.random() * 2;
    
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
     public void only1EmptyTileTest(){
         int numberofemptytiles = 0;
         
          for (int r=0; r<puzzle.getRows(); r++) {
           for (int c=0; c<puzzle.getCols(); c++) {
               
               if(puzzle.get_contents()[r][c].getFace() == null){
                   numberofemptytiles++;
                   
               }              
           }
          }
            assertEquals(numberofemptytiles, 1);

     }
     
      @Test
    public void getFaceTest(){
        assertEquals(puzzle.get_contents()[row][col].getFace(),puzzle.getFace(row, col));
    }
      
      @Test
      public void get_contentsTest(){
          
          
      }




}

