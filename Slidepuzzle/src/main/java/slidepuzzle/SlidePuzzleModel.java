package slidepuzzle;

import java.awt.Component;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 * @author nargiza
 *
 * Game Logic
 *
 */
class SlidePuzzleModel {

    /**
     * number of rows and columns
     */
    private static final int ROWS = 3;
    private static final int COLS = 3;
    /**
     * All the tiles are in contents while the empty tile is defined by
     * emptyTile
     */
    private Tile[][] contents;  // All tiles.
    private Tile emptyTile; // The empty space.
    private Component frame;

    /**
     * constructor of the class, where the dimensions of the contents are given
     * and the puzzle is reset
     */
    public SlidePuzzleModel() {
        contents = new Tile[ROWS][COLS];
        reset();               // shuffle the tiles, including the empty one
    }

    /**
     * Method to get the face value on a specific tile: e.g. "1" on the tile
     * [0][0]
     *
     * @param row the row of the given tile
     * @param col the column of the given tile
     * @return returns the face value
     */
    String getFace(int row, int col) {
        return contents[row][col].getFace();

    }

    public Tile[][] get_contents() {
        return contents;
    }

    /**
     * resets the puzzle game
     *
     * @see SlidePuzzleModel.OrderPuzzle()
     *
     * @see SlidePuzzleModel.randomizeTiles
     *
     */
    public void reset() {

        this.OrderPuzzle();
        this.randomizeTiles();
    }

    /**
     * Orders puzzle
     *
     * Goes through the puzzle's contents and assigns face values in the correct
     * order Also places the empty tile as the very last tile
     *
     */
    public void OrderPuzzle() {

        //create a new, ordered puzzle
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                contents[r][c] = new Tile(r, c, "" + (r * COLS + c + 1));

            }
        }
        //make one of the tiles an empty tile
        emptyTile = contents[ROWS - 1][COLS - 1];
        emptyTile.setFace(null);

    }
    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Arrays.deepHashCode(this.contents);
        hash = 13 * hash + Objects.hashCode(this.emptyTile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SlidePuzzleModel other = (SlidePuzzleModel) obj;
        if (!Arrays.deepEquals(this.contents, other.contents)) {
            return false;
        }
        if (!Objects.equals(this.emptyTile, other.emptyTile)) {
            return false;
        }
        return true;
    }

    /**
     * Randomizes tiles in the puzzle
     *
     * Takes some existing puzzles tiles and assigns them to different locations
     *
     * In other words, exchanges the tiles' places
     */
    public void randomizeTiles() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int newtilerow = (int) (Math.random() * ROWS);
                int newtilecol = (int) (Math.random() * COLS);

                exchangeTiles(r, c, newtilerow, newtilecol);

            }
        }

    }

    /**
     * Checks if tile can be moved
     *
     * Using the parameters of the given tile, the method checks whether there
     * are any available empty slots and if there are, moves the tile to the
     * empty slot
     *
     * @param r the row parameter of the given tile
     * @param c the column parameter of the given tile
     * @return true if tile can be moved and false if it can't
     */
    public boolean moveTile(int r, int c) {
   

        return moveToEmpty(r, c, -1, 0) || moveToEmpty(r, c, 1, 0)
                || moveToEmpty(r, c, 0, -1) || moveToEmpty(r, c, 0, 1);
    }

    /**
     * Checks if tile can be moved to a specific empty slot
     *
     * @param row parameter of the given tile
     * @param col -umn parameter of the given tile
     * @param rdelta the amount of rows away from the given tile that the
     * program needs to go to check for empty tile
     * @param cdelta the amount of columns away from the given tile that the
     * program needs to go to check for empty tile
     * @return true the neighboring tile is empty and the tiles have exchanged
     * places, false otherwise
     */
    public boolean moveToEmpty(int row, int col, int rdelta, int cdelta) {
        int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;

        if (this.checkEmpty(row, col, rdelta, cdelta)) {
            exchangeTiles(row, col, rNeighbor, cNeighbor);
            return true;
        }
        return false;
    }

    /**
     * checks if neighbor tile is empty
     *
     * @param row parameter of the given tile
     * @param col -umn parameter of the given tile
     * @param rdelta the amount of rows away from the given tile that the
     * program needs to go to check for empty tile
     * @param cdelta the amount of columns away from the given tile that the
     * program needs to go to check for empty tile
     * @return true the neighboring tile is empty, false otherwise
     */
    public boolean checkEmpty(int row, int col, int rdelta, int cdelta) {
        int rNeighbor = row + rdelta;
        int cNeighbor = col + cdelta;

        return isLegalRowCol(rNeighbor, cNeighbor) && contents[rNeighbor][cNeighbor].equals(emptyTile);

    }

    /**
     * check that tile of given parameters is in the puzzle
     *
     * @param r row parameter of the tile
     * @param c collumn parameter of the tile
     * @return true when both the row and column values are between 0 and 2, and
     * false otherwise
     */
    public boolean isLegalRowCol(int r, int c) {
        return r >= 0 && r < ROWS && c >= 0 && c < COLS;

    }

    /**
     * exchanges tiles' places
     *
     * @param r1 row parameter of the first tile
     * @param c1 column parameter of the first tile
     * @param r2 row parameter of the second tile
     * @param c2 column parameter of the second tile
     *
     */
    public void exchangeTiles(int r1, int c1, int r2, int c2) {
        Tile temp = contents[r1][c1];
        contents[r1][c1] = contents[r2][c2];
        contents[r2][c2] = temp;
    }

    /**
     * check if all tiles are in correct position
     *
     * @return true if all the tiles are in the "final position" (see class tile
     * for the final position method)
     */



    public int getRows() {
        return ROWS;

    }

    public int getCols() {
        return COLS;
    }

}
