
package slidepuzzle;

class Tile {
    
    public int row;     
    public int col;     
    public String face;  
    

    public Tile(int row, int col, String face) {
        this.row = row;
        this.col = col;
        this.face = face;
    }
    
    
   
    public void setFace(String newFace) {
        face = newFace;
    }
    
    
  
    public String getFace() {
        return face;
    }
    
    
    public boolean isInFinalPosition(int r, int c) {
        return r==row && c==col;
    }
}