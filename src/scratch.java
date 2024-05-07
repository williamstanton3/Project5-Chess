import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class scratch {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Create players
        System.out.print("Enter name of Player 1: ");
        Player p1 = new Player(scanner.next(), "white");
        System.out.print("Enter name of Player 2: ");
        Player p2 = new Player(scanner.next(), "black");

        // Initialize the game
        Game game = new Game(p1, p2);

        System.out.println();
        System.out.println(p1.getName() + ", you are white. " + p2.getName() + ", you are black.");
        System.out.println("BEGIN! " + p1.getName() + " vs. " + p2.getName());

        // Run the game loop until someone wins
        while (true) {
            // Player 1's move
            Map<String, Integer> move1 = generateRandomMove();
            game.gameBoard.play(p1, move1.get("startRow"), move1.get("startCol"), move1.get("endRow"), move1.get("endCol"));
            game.gameBoard.print();

            // Player 2's move
            Map<String, Integer> move2 = generateRandomMove();
            game.gameBoard.play(p2, move2.get("startRow"), move2.get("startCol"), move2.get("endRow"), move2.get("endCol"));
            game.gameBoard.print();
        }
    }

    // Helper method to generate a random move
    private static Map<String, Integer> generateRandomMove() {
        Map<String, Integer> move = new HashMap<>();
        Random rand = new Random();
        move.put("startRow", rand.nextInt(8));
        move.put("startCol", rand.nextInt(8));
        move.put("endRow", rand.nextInt(8));
        move.put("endCol", rand.nextInt(8));
        return move;
    }
}


