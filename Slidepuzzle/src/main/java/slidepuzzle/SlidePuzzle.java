package slidepuzzle;

import javax.swing.JFrame;

class SlidePuzzle {

   

    public static void main(String[] args) {

        JFrame window = new JFrame("Slide Puzzle");
<<<<<<< HEAD
         SlidePuzzleModel puzzle = new SlidePuzzleModel();
=======

        SlidePuzzleModel puzzle = new SlidePuzzleModel();

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new SlidePuzzleGUI());

        window.pack();

        window.show();  

        window.setResizable(false);
<<<<<<< HEAD
        System.out.println(puzzle.get_contents().length);
        
       
//         System.out.println(puzzle.faceOnTile(0, 0));
//         System.out.println(puzzle.faceOnTile(0, 1));
//         System.out.println(puzzle.faceOnTile(0, 2));
//         System.out.println(puzzle.faceOnTile(1, 0));
//         System.out.println(puzzle.faceOnTile(1, 1));
//         System.out.println(puzzle.faceOnTile(1, 2));
        
=======
        
        System.out.println(puzzle.get_contents());

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

>>>>>>> cb2f511c50c0cb41607b9b246279c52e569e9f35
    }

}

 

 

 
