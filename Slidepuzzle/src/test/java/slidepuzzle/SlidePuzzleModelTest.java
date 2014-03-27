/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidepuzzle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ndjurabe@cs
 */
public class SlidePuzzleModelTest {

    private SlidePuzzleModel puzzle;
    private int row = (int) Math.random() * 2;
    private int col = (int) Math.random() * 2;
    private int newRow = 0;
    private int newCol = 0;

    public SlidePuzzleModelTest() {
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkThatTileFaceNotNull() {

        assertNotNull(puzzle.getFace(row, col));

    }

    @Test
    public void checkThatNoTilesAreSame() {
        puzzle.reset();
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {

                assertFalse(puzzle.getFace(i, j).equals(puzzle.getFace(i - 1, j)));
            }

        }

    }
   
//    @Test
//    public void tileDoesNotMoveItIsEmptyTest(){
//       if(!puzzle.moveTile(row, col)){
//           assertNull(puzzle._contents[row][col].getFace());
//           
//       }
//          
//       
//        
//    }
//    
//    

}
