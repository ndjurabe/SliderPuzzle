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
    public void checkIfTile0x1NotNull() {
        assertNotNull(puzzle.getFace(0,1));
    }
}
