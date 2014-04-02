package slidepuzzle;

class SlidePuzzleModel {
//     private static final int newROWS = 3;
//    private static final int newCOLS = 3;

    private static final int ROWS = 3;
    private static final int COLS = 3;

    private Tile[][] contents;  // All tiles.
    private Tile     emptyTile; // The empty space.



    public SlidePuzzleModel() {
        contents = new Tile[ROWS][COLS];
       reset();               // shuffle the tiles, including the empty one
    }



    String getFace(int row, int col) {
        return contents[row][col].getFace();
    }

    public Tile[][] get_contents(){
        return contents;
    }

    public void reset() {

         //create a new, ordered puzzle
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
             contents[r][c] = new Tile(r, c, "" + (r*COLS+c+1));

            }
        }

        emptyTile = contents[ROWS-1][COLS-1];
        emptyTile.setFace(null);

      //randomize tiles
       for (int r=0; r<ROWS; r++) {
           for (int c=0; c<COLS; c++) {
        int newtilerow = (int)(Math.random()*ROWS);
       int newtilecol = (int)(Math.random()*COLS);


              exchangeTiles(r, c, newtilerow, newtilecol);


         }
       }



   }

//    public String faceOnTile(int r, int c){
//
//        for (r=0; r<ROWS; r++) {
//            for (c=0; c<COLS; c++) {
//               return this.getFace(r, c);
//            }
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
                  && contents[rNeighbor][cNeighbor] == emptyTile) {
            exchangeTiles(row, col, rNeighbor, cNeighbor);
            return true;
        }
        return false;
    }

   public boolean checkEmpty(int row, int col, int rdelta, int cdelta){
      int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;

       return isLegalRowCol(rNeighbor, cNeighbor) && contents[rNeighbor][cNeighbor] == emptyTile;

   }

    public boolean isLegalRowCol(int r, int c) {
        return r>=0 && r<ROWS && c>=0 && c<COLS;
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

    public boolean isGameOver() {
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<ROWS; c++) {
                Tile trc = contents[r][c];
                return trc.isInFinalPosition(r, c);
            }
        }


        return true;
    }

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