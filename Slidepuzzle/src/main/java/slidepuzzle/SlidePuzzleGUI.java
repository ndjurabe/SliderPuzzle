package slidepuzzle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author nargiza
 *
 * The graphic user interface
 *
 */
class SlidePuzzleGUI extends JPanel {
    // instance variables

    private GraphicsPanel SPgraphics;
    private SlidePuzzleModel SPmodel = new SlidePuzzleModel();
    private Component frame;

    /**
     * constructor of the class where the the graphics are set up
     */
    public SlidePuzzleGUI() {
        //pressing button New Game resets the game
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameAction());


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(newGameButton);

        //graphics panel
        SPgraphics = new GraphicsPanel();

        //layout settings
        this.setLayout(new BorderLayout());
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(SPgraphics, BorderLayout.CENTER);
//        if (SPmodel.isGameOver()) {
//            JOptionPane.showMessageDialog(frame, "You win!");
//        }

    }

    /**
     *
     * panel graphics class
     *
     */
    class GraphicsPanel extends JPanel implements MouseListener {

        private static final int ROWS = 3;
        private static final int COLUMNS = 3;
        private static final int CELL_SIZE = 80; // Pixels
        private Font biggerFont;

        /**
         * constructor
         *
         * sets the font and the background color of the panel
         */
        public GraphicsPanel() {
            biggerFont = new Font("SansSerif", Font.BOLD, CELL_SIZE / 2);
            this.setPreferredSize(
                    new Dimension(CELL_SIZE * COLUMNS, CELL_SIZE * ROWS));
            this.setBackground(Color.GREEN);
            this.addMouseListener(this);  // Listen own mouse events.
        }

        /**
         * method that decides how each tile looks including how the number on
         * the tile looks
         *
         * @param g -- the graphic equivalent of a single tile
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLUMNS; c++) {
                    int x = c * CELL_SIZE;
                    int y = r * CELL_SIZE;
                    String text = SPmodel.getFace(r, c);
                    if (text != null) {
                        g.setColor(Color.gray);
                        g.fillRect(x + 2, y + 2, CELL_SIZE - 4, CELL_SIZE - 4);
                        g.setColor(Color.GREEN);
                        g.setFont(biggerFont);
                        g.drawString(text, x + 20, y + (3 * CELL_SIZE) / 4);
                    }
                }
            }
        }

        /**
         * method that keeps repainting the panel as the game progresses
         *
         * @param e - event of when the mouse is pressed
         */
        public void mousePressed(MouseEvent e) {
            //--- map x,y coordinates into a row and column.
            int col = e.getX() / CELL_SIZE;
            int row = e.getY() / CELL_SIZE;
            SlidePuzzleModel newPuzzle = new SlidePuzzleModel();
            newPuzzle.OrderPuzzle();
            if (!SPmodel.moveTile(row, col)) {

                Toolkit.getDefaultToolkit().beep();
            }
            else if(SPmodel.equals(newPuzzle)){
        JOptionPane.showMessageDialog(frame, "You win!");
            }

            this.repaint();

        }

//implementing an Action listener
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    /**
     * ActionListener type class
     *
     * when the program is ran or when the "new game" button is pressed, this
     */
    public class NewGameAction implements ActionListener {

        private Component frame;

        /**
         * when the program is ran or when the "new game" button is pressed,
         * this method takes care to restart the game.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
//            if(SPmodel.isGameOver()){
//        JOptionPane.showMessageDialog(frame, "You win!");
//            }
            SPmodel.reset();
            SPgraphics.repaint();

        }
    }
}