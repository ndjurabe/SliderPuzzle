package slidepuzzle;

import javax.swing.JFrame;

class SlidePuzzle {

   

    public static void main(String[] args) {

        JFrame window = new JFrame("Slide Puzzle");

        SlidePuzzleModel puzzle = new SlidePuzzleModel();
 SlidePuzzleModel newpuzzle = new SlidePuzzleModel();
           for (int r = 0; r < newpuzzle.getRows(); r++) {
            for (int c = 0; c < newpuzzle.getCols(); c++) {
                //list all the tiles in order and check that their content is in order
                for(int i = 1; i<=8;i++){
                  newpuzzle.get_contents()[r][c] = new Tile(r, c, "" + (r * newpuzzle.getCols() + c + 1));

            }
        }
        //make one of the tiles an empty tile
       Tile emptyTile = newpuzzle.get_contents()[newpuzzle.getRows() - 1][newpuzzle.getCols() - 1];
        emptyTile.setFace(null);
                
                //list all the tiles in the 'ordered' puzzle and check where the two have same content
                
               
                
            }
            
           
           puzzle.OrderPuzzle();
    //    System.out.println(puzzle.get_contents().length);
        
       
//         System.out.println(puzzle.faceOnTile(0, 0));
//         System.out.println(puzzle.faceOnTile(0, 1));
//         System.out.println(puzzle.faceOnTile(0, 2));
//         System.out.println(puzzle.faceOnTile(1, 0));
//         System.out.println(puzzle.faceOnTile(1, 1));
//         System.out.println(puzzle.faceOnTile(1, 2));
        

        
     //   System.out.println(puzzle.get_contents());

//       
//
//         System.out.println(puzzle.get_contents()[0][0].getFace());
//
//          System.out.println(puzzle.get_contents()[0][1].getFace());
//
//           System.out.println(puzzle.get_contents()[0][2].getFace());
//
//            System.out.println(puzzle.get_contents()[1][0].getFace());
//
//             System.out.println(puzzle.get_contents()[1][1].getFace());
//
//              System.out.println(puzzle.get_contents()[1][2].getFace());



           System.out.println(puzzle.get_contents()[0][0].getFace());
           System.out.println(newpuzzle.get_contents()[0][0].getFace());
           System.out.println(newpuzzle.get_contents()[0][1].getFace());
           System.out.println(newpuzzle.get_contents()[0][2].getFace());



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new SlidePuzzleGUI());

        window.pack();

        window.show();  

        window.setResizable(false);
        
        
}}

 

 

 
