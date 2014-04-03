package slidepuzzle;

import java.util.ArrayList;
import java.util.List;
import static javax.swing.text.html.HTML.Attribute.COLS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SlidePuzzleModelTest1 {

    private SlidePuzzleModel puzzle;
    private int row = (int) Math.random() * 2;
    private int col = (int) Math.random() * 2;
    private Tile emptytile;
    

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
    public void has9TilesTest() {
        assertEquals(puzzle.getRows() * puzzle.getCols(), 9);
    }

    @Test

    public void only1EmptyTileTest() {
        int numberofemptytiles = 0;

        for (int r = 0; r < puzzle.getRows(); r++) {
            for (int c = 0; c < puzzle.getCols(); c++) {

                if (puzzle.get_contents()[r][c].getFace() == null) {
                    numberofemptytiles++;

                }
            }
        }
        assertEquals(numberofemptytiles, 1);

    }

    @Test
    public void getFaceTest() {
        assertEquals(puzzle.get_contents()[row][col].getFace(), puzzle.getFace(row, col));

    }

    @Test
    public void get_contentsTest() {
        Tile[][] samecontents = puzzle.get_contents();

        Assert.assertArrayEquals(puzzle.get_contents(), samecontents);

    }

    @Test
    public void orderPuzzleTest() {
        SlidePuzzleModel newpuzzle = new SlidePuzzleModel();
        for (int r = 0; r < newpuzzle.getRows(); r++) {
            for (int c = 0; c < newpuzzle.getCols(); c++) {
                //list all the tiles in order and check that their content is in order
                for (int i = 1; i <= 8; i++) {
                    newpuzzle.get_contents()[r][c] = new Tile(r, c, "" + (r * newpuzzle.getCols() + c + 1));

                }
            }
            //make one of the tiles an empty tile
            Tile emptyTile = newpuzzle.get_contents()[newpuzzle.getRows() - 1][newpuzzle.getCols() - 1];
            emptyTile.setFace(null);

                //list all the tiles in the 'ordered' puzzle and check where the two have same content
        }

        puzzle.OrderPuzzle();

        for (int r = 0; r < newpuzzle.getRows(); r++) {
            for (int c = 0; c < newpuzzle.getCols(); c++) {
                assertEquals(newpuzzle.get_contents()[r][c].getFace(), puzzle.get_contents()[r][c].getFace());

            }
        }

    }
    
    
    @Test
    public void randomizeTilesTest(){
        List<String> listoffaces = new ArrayList<String>();
        puzzle.randomizeTiles();
        for (int r = 0; r < puzzle.getRows(); r++) {
            for (int c = 0; c < puzzle.getCols(); c++) {
                
                listoffaces.add(puzzle.get_contents()[r][c].getFace());
                
            }
        
        
    }
       List<String> newlist = new ArrayList<String>();
        for(String face:listoffaces){
            
            if(!newlist.contains(face)){
                newlist.add(face);
            }
            
        }
        
        assertEquals(listoffaces,newlist);


}
    
    @Test
    
    public void checkEmptyTest(){
        
     
     emptytile = puzzle.get_contents()[0][1];
     emptytile.setFace(null); 
        
        
        assertTrue(puzzle.checkEmpty(0, 0, 0, 1));
        assertTrue(puzzle.checkEmpty(1, 0, -1, 1));
        
        
    }
    
    @Test
    
    public void moveTileTest(){

     puzzle.OrderPuzzle();
     assertFalse(puzzle.moveTile(0, 0));
     assertTrue(puzzle.moveTile(2, 1));

        
    }
    
    @Test
    
    public void moveToEmptyTest(){
         

     puzzle.OrderPuzzle();
     assertTrue(puzzle.moveToEmpty(1, 2, 1, 0));


    }
    
    
   @Test
    public void isLegalRowColTest() {
        assertTrue(puzzle.isLegalRowCol(0, 1));
        assertTrue(puzzle.isLegalRowCol(0, 0));
        assertTrue(puzzle.isLegalRowCol(2, 2));
        assertTrue(puzzle.isLegalRowCol(1, 1));
        assertFalse(puzzle.isLegalRowCol(5, 1)); 
        assertFalse(puzzle.isLegalRowCol(0, -1));
        assertFalse(puzzle.isLegalRowCol(8, 20)); 
        assertFalse(puzzle.isLegalRowCol(-57, 0));
        assertTrue(puzzle.isLegalRowCol(2, 1));
        assertFalse(puzzle.isLegalRowCol(3, 3));
        assertFalse(puzzle.isLegalRowCol(0, 7));
        assertFalse(puzzle.isLegalRowCol(-9, -27));
        
        
    }

   
    
    
    @Test
    
    public void exchangeTilesTest(){
        Tile orig00tile = puzzle.get_contents()[0][0];
       puzzle.exchangeTiles(0, 0, 0, 1);
       assertNotSame(orig00tile,puzzle.get_contents()[0][0]);
        assertSame(orig00tile,puzzle.get_contents()[0][1]);
        
    }
    
    @Test
    public void isGameOverTest(){
        puzzle.OrderPuzzle();
        assertTrue(puzzle.isGameOver());
    }
    
    @Test
    public void moveToEmptyTest2(){
         emptytile = puzzle.get_contents()[0][1];
     emptytile.setFace(null); 
     puzzle.get_contents()[0][0].setFace("1");
     
     assertFalse(puzzle.moveToEmpty(0, 0, 0, 0));
     assertFalse(puzzle.moveToEmpty(0, 0, 0, 2));
     assertFalse(puzzle.moveToEmpty(0, 0, 0, -1));
     assertFalse(puzzle.moveToEmpty(0, 0, 1, -1));
     assertFalse(puzzle.moveToEmpty(0, 0, -2, 0));
        
    }
    @Test
    public void moveToEmptyTest3(){
      puzzle.OrderPuzzle();
     puzzle.exchangeTiles(2, 2, 2, 1);
     puzzle.exchangeTiles(2, 1, 1, 1);
     assertTrue(puzzle.moveTile(0, 1));

}
        @Test
    public void moveToEmptyTest4(){
      puzzle.OrderPuzzle();
     puzzle.exchangeTiles(2, 2, 2, 1);
     puzzle.exchangeTiles(2, 1, 1, 1);
    
     assertTrue(puzzle.moveTile(1, 0));

}
        
            @Test
    public void moveToEmptyTest5(){
      puzzle.OrderPuzzle();
     puzzle.exchangeTiles(2, 2, 2, 1);
     puzzle.exchangeTiles(2, 1, 1, 1);
   
     assertTrue(puzzle.moveTile(1, 2));
   
}
                @Test
    public void moveToEmptyTest6(){
      puzzle.OrderPuzzle();
     puzzle.exchangeTiles(2, 2, 2, 1);
     puzzle.exchangeTiles(2, 1, 1, 1);
   
     assertTrue(puzzle.moveTile(2, 1));
}
}