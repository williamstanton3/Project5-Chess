import java.util.HashMap;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        // gets the names of the 2 players and creates the 2 player objects
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of Player 1: ");
        Player p1 = new Player(sc.next(), "white");
        System.out.print("Enter name of Player 2: ");
        Player p2 = new Player(sc.next(), "black");

        System.out.println();
        System.out.println(p1.getName() + ", you are white. " + p2.getName() +", you are black.");
        System.out.println("BEGIN! " + p1.getName() + " vs. " + p2.getName());

        // runs the game loop
        Game g = new Game(p1, p2);
        g.gameLoop();
    }
}
