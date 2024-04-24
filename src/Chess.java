import java.util.HashMap;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        // hashmap that contains the names of all the players who have ever played and the number of wins they have
        HashMap<String, Integer> players = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player 1's name");
        String name1 = sc.next();
        if (!players.containsKey(name1)) {
            players.put(name1, 0);
        }

        System.out.println("Enter player 2's name");
        String name2 = sc.next();
        if (!players.containsKey(name2)) {
            players.put(name2, 0);
        }
    }



    // idea: we have to use two different kinds of collections
    // we can use a list (arraylist probably) easily for the game
    // i think we should use a map to track which users have won which times
    // kind of like an ultimate chess game that takes the users names before the game
    // and stores the winner in a map with an int that represents the number of times they have won

    // another question: how will we print the chess symbols on the game board? and the colors?
}
