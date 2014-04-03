package slidepuzzle;

import java.util.Objects;
/**
 * 
 * @author nargiza
 * 
 * class for each separate tile
 */
class Tile {
    
    /**
     * initialized variables and parameters 
     * 
     * row (parameter)
     * col(-umn parameter) and 
     * face (face of the tile parameter of type String)
     */
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
    
    /**
     * checks if the tile is in the intended position
     * @param r row parameter of where the tile should be
     * @param c column parameter of where the tile should be
     * @return true if the tile's coordinates/parameters are the same as where they should be
     */
    public boolean isInFinalPosition(int r, int c) {
        return r==row && c==col;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (!Objects.equals(this.face, other.face)) {
            return false;
        }
        return true;
    }
    
    
}