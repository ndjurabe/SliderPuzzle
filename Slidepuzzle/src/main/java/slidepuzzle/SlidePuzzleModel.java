package slidepuzzle;

class SlidePuzzleModel {
//     private static final int newROWS = 3;
//    private static final int newCOLS = 3;

    private static final int ROWS = 3;
    private static final int COLS = 3;
<<<<<<< HEAD
    
    private Tile[][] contents;  // All tiles.
    private Tile     emptyTile; // The empty space.
    
    
 
=======

    private Tile[][] contents;  // All tiles.
    private Tile     emptyTile; // The empty space.



>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
    public SlidePuzzleModel() {
        contents = new Tile[ROWS][COLS];
       reset();               // shuffle the tiles, including the empty one
    }



    String getFace(int row, int col) {
        return contents[row][col].getFace();
<<<<<<< HEAD
    }
    
    public Tile[][] get_contents(){
        return contents;
    }
    
    public void reset() {
   
=======
    }

    public Tile[][] get_contents(){
        return contents;
    }

    public void reset() {

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
         //create a new, ordered puzzle
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
             contents[r][c] = new Tile(r, c, "" + (r*COLS+c+1));
<<<<<<< HEAD
           
            }
        }  
        
        emptyTile = contents[ROWS-1][COLS-1];
        emptyTile.setFace(null);
        
=======

            }
        }

        emptyTile = contents[ROWS-1][COLS-1];
        emptyTile.setFace(null);

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
      //randomize tiles
       for (int r=0; r<ROWS; r++) {
           for (int c=0; c<COLS; c++) {
        int newtilerow = (int)(Math.random()*ROWS);
       int newtilecol = (int)(Math.random()*COLS);
<<<<<<< HEAD
       
     
              exchangeTiles(r, c, newtilerow, newtilecol);
               

         }
       }
       
       
     
   }
    
//    public String faceOnTile(int r, int c){
//        
=======


              exchangeTiles(r, c, newtilerow, newtilecol);


         }
       }



   }

//    public String faceOnTile(int r, int c){
//
>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
//        for (r=0; r<ROWS; r++) {
//            for (c=0; c<COLS; c++) {
//               return this.getFace(r, c);
//            }
<<<<<<< HEAD
//        }  
//  return "";
//        
//    }
    
    

    public boolean moveTile(int r, int c) {
        
        return moveToEmpty(r, c, -1, 0) || moveToEmpty(r, c, 1, 0)
            || moveToEmpty(r, c, 0, -1) || moveToEmpty(r, c, 0, 1);
    }
    
    
 
    public boolean moveToEmpty(int row, int col, int rdelta, int cdelta) {
        int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;
        
        if (isLegalRowCol(rNeighbor, cNeighbor) 
=======
//        }
//  return "";
//
//    }



    public boolean moveTile(int r, int c) {

        return moveToEmpty(r, c, -1, 0) || moveToEmpty(r, c, 1, 0)
            || moveToEmpty(r, c, 0, -1) || moveToEmpty(r, c, 0, 1);
    }



    public boolean moveToEmpty(int row, int col, int rdelta, int cdelta) {
        int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;

        if (isLegalRowCol(rNeighbor, cNeighbor)
>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
                  && contents[rNeighbor][cNeighbor] == emptyTile) {
            exchangeTiles(row, col, rNeighbor, cNeighbor);
            return true;
        }
        return false;
    }
<<<<<<< HEAD
    
   public boolean checkEmpty(int row, int col, int rdelta, int cdelta){
      int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;
        
       return isLegalRowCol(rNeighbor, cNeighbor) && contents[rNeighbor][cNeighbor] == emptyTile;
       
=======

   public boolean checkEmpty(int row, int col, int rdelta, int cdelta){
      int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;

       return isLegalRowCol(rNeighbor, cNeighbor) && contents[rNeighbor][cNeighbor] == emptyTile;

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
   }

    public boolean isLegalRowCol(int r, int c) {
        return r>=0 && r<ROWS && c>=0 && c<COLS;
<<<<<<< HEAD
    }
    
    
//    private void exchangeFaces(int r1, int c1, int r2, int c2){
//        String temp = this.get_contents()[r1][c1].getFace();
//        this.get_contents()[r1][c1].setFace(this.get_contents()[r2][c2].getFace());
//        this.get_contents()[r2][c2].setFace(temp);
//        
//    }
    
    
    private void exchangeTiles(int r1, int c1, int r2, int c2) {
        Tile temp = contents[r1][c1];
        contents[r1][c1] = contents[r2][c2];
        contents[r2][c2] = temp;
    }
    
=======
    }


//    private void exchangeFaces(int r1, int c1, int r2, int c2){
//        String temp = this.get_contents()[r1][c1].getFace();
//        this.get_contents()[r1][c1].setFace(this.get_contents()[r2][c2].getFace());
//        this.get_contents()[r2][c2].setFace(temp);
//
//    }


    public void exchangeTiles(int r1, int c1, int r2, int c2) {
        Tile temp = contents[r1][c1];
        contents[r1][c1] = contents[r2][c2];
        contents[r2][c2] = temp;
    }

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
    public boolean isGameOver() {
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<ROWS; c++) {
                Tile trc = contents[r][c];
                return trc.isInFinalPosition(r, c);
            }
        }


        return true;
    }
<<<<<<< HEAD

//    public int has9Tiles() {
//        return ROWS*COLS;
//    }

    public int getRows() {
        return ROWS;
        
    }

   public int getCols() {
        return COLS;
    }




}
    
    
    
=======
>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35

//    public int has9Tiles() {
//        return ROWS*COLS;
//    }

    public int getRows() {
        return ROWS;

    }

   public int getCols() {
        return COLS;
    }




}
