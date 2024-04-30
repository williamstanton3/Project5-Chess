import java.util.HashMap;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of Player 1: ");
        Player p1 = new Player(sc.next(), "white");
        System.out.println("Enter name of Player 2: ");
        Player p2 = new Player(sc.next(), "black");

        Game g = new Game(p1, p2);
        g.gameLoop();
    }



    // idea: we have to use two different kinds of collections
    // we can use a list (arraylist probably) easily for the game
    // i think we should use a map to track which users have won which times
    // kind of like an ultimate chess game that takes the users names before the game
    // and stores the winner in a map with an int that represents the number of times they have won

    // another question: how will we print the chess symbols on the game board? and the colors?
}
