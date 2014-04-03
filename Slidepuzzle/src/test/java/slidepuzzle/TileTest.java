<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slidepuzzle;

import java.util.Random;
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
public class TileTest {
     private Tile tile;
     private Tile NewTile;
      int row = (int)Math.random()*2;
        int col = (int)Math.random()*2;
        public String face;
     
    public TileTest() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     
        tile  = new Tile(row, col, null);
        NewTile = new Tile(0, 0, "1");
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
     public void setFaceTest() {
         
     tile.setFace(face);
     
     assertEquals(face, tile.getFace());
         
     }
     
     @Test
     public void isInFinalPositionTest(){
         assertTrue(NewTile.isInFinalPosition(0, 0));
         
     }
     
     
}
=======
 

 

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

 

package slidepuzzle;

 

import java.util.Random;

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

public class TileTest {

     private Tile tile;

     private Tile NewTile;

      int row = (int)Math.random()*2;

        int col = (int)Math.random()*2;

        public String face;

     

    public TileTest() {

       

    }

   

    @BeforeClass

    public static void setUpClass() {

    }

   

    @AfterClass

    public static void tearDownClass() {

    }

   

    @Before

    public void setUp() {

     

        tile  = new Tile(row, col, null);

        NewTile = new Tile(0, 0, "1");

       

    }

   

    @After

    public void tearDown() {

    }

 @Test
 public void setFaceTest(){
     tile.setFace("1");
     assertEquals(NewTile.getFace(),tile.getFace());
     
 }

   

    @Test

     public void getFaceTest() {

         

     tile.setFace(face);

     

     assertEquals(face, tile.getFace());

         

     }

     

     @Test

     public void isInFinalPositionTest(){

         assertTrue(NewTile.isInFinalPosition(0, 0));

         

     }

     

     

}

 

 

 
>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
