package slidepuzzle;

import javax.swing.JFrame;

/**
 * 
 * @author nargiza
 * 
 * Main class
 */

class SlidePuzzle {

   /**
    * 
    * main
    * 
    * @param args command lines
    */

    public static void main(String[] args) {

        JFrame window = new JFrame("Slide Puzzle");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new SlidePuzzleGUI());

        window.pack();

        window.show();  

        window.setResizable(false);
        
        
        
}}

 

 

 
