
package slidepuzzle;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SlidePuzzleGUI extends JPanel {
   // instance variables
    private GraphicsPanel    SPgraphics;
    private SlidePuzzleModel SPmodel = new SlidePuzzleModel();
 


    public SlidePuzzleGUI() {
        //create a button and add a listener to it
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameAction());

        //panel to restart game maybe?
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(newGameButton);
        
        //graphics panel
        SPgraphics = new GraphicsPanel();
        
        //layout settings
        this.setLayout(new BorderLayout());
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(SPgraphics, BorderLayout.CENTER);
    }//end constructor


    //complains, move the graphics panel inside?
    class GraphicsPanel extends JPanel implements MouseListener {
        private static final int ROWS = 3;
        private static final int COLUMNS = 3;
        
        private static final int CELL_SIZE = 80; // Pixels
        private Font _biggerFont;
        
        
      
        public GraphicsPanel() {
            _biggerFont = new Font("SansSerif", Font.BOLD, CELL_SIZE/2);
            this.setPreferredSize(
                   new Dimension(CELL_SIZE * COLUMNS, CELL_SIZE*ROWS));
            this.setBackground(Color.black);
            this.addMouseListener(this);  // Listen own mouse events.
        }//end constructor
        
        
 
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int r=0; r<ROWS; r++) {
                for (int c=0; c<COLUMNS; c++) {
                    int x = c * CELL_SIZE;
                    int y = r * CELL_SIZE;
                    String text = SPmodel.getFace(r, c);
                    if (text != null) {
                        g.setColor(Color.gray);
                        g.fillRect(x+2, y+2, CELL_SIZE-4, CELL_SIZE-4);
                        g.setColor(Color.black);
                        g.setFont(_biggerFont);
                        g.drawString(text, x+20, y+(3*CELL_SIZE)/4);
                    }
                }
            }
        }//end paintComponent
        
        
 
        public void mousePressed(MouseEvent e) {
            //--- map x,y coordinates into a row and column.
            int col = e.getX()/CELL_SIZE;
            int row = e.getY()/CELL_SIZE;
          
            if (!SPmodel.moveTile(row, col)) {
               
                Toolkit.getDefaultToolkit().beep();
            }
            
            this.repaint(); 
        }
        
        
        //========================================== ignore these events
        @Override
        public void mouseClicked (MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered (MouseEvent e) {}
        @Override
        public void mouseExited  (MouseEvent e) {}
    }
    
  
    public class NewGameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SPmodel.reset();
            SPgraphics.repaint();
        }
    }

}