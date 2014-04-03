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
        
        
    }
}