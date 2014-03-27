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
 *
 *
 * @author ndjurabe@cs
 *
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

//    @Test
//    public void checkThatNoTilesAreSame() {
//        for (int i = 0; i < 2; i++) {
//            assertFalse(puzzle.getFace(i, i).equals(puzzle.getFace(i + 1, i)));
//        }
//    }
    @Test
    public void exchangeTilesTest(){
        Tile firstTile = puzzle.get_contents()[0][1];
        puzzle.exchangeTiles(0,1,1,0);
        assertFalse(firstTile.equals(puzzle.get_contents()[0][1]));
        
    }
    @Test
    public void getFaceTest(){
        assertEquals(puzzle.get_contents()[row][col].getFace(),puzzle.getFace(row, col));
    }

    @Test
    public void isLegalRowColTest() {
        assertTrue(puzzle.isLegalRowCol(0, 1));
    }

    @Test
    public void isLegalRowColTest2() {
        assertFalse(puzzle.isLegalRowCol(5, 1));
    }

    @Test
    public void isLegalRowColTest3() {
        assertFalse(puzzle.isLegalRowCol(0, -1));
    }

    @Test
    public void tileDoesNotMoveIfSlotNotEmptyTest() {

        if (!(puzzle.moveIfEmpty(row, col, -1, 0) || puzzle.moveIfEmpty(row, col, 1, 0)
                || puzzle.moveIfEmpty(row, col, 0, -1) || puzzle.moveIfEmpty(row, col, 0, 1))) {
            assertFalse(puzzle.moveTile(row, col));
        }




    }
}