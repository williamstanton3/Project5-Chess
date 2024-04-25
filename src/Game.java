import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    /**
     * an arrayList that holds all the white pieces on the baord
     */
    private ArrayList<Piece> whiteAlive = new ArrayList<>();
    /**
     * an arrayList that holds all the black pieces on the board
     */
    private ArrayList<Piece> blackAlive = new ArrayList<>();
    /**
     * an arrayList that holds all the white pieces that have been killed
     */
    private ArrayList<Piece> whiteDead = new ArrayList<>();
    /**
     * an arrayList that holds all the black pieces that have been killed
     */
    private ArrayList<Piece> blackDead = new ArrayList<>();

    /**
     * the current gameBoard
     */
    private Board gameBoard;
    /**
     * the current Player (white or black)
     */
    private String currentPlayer;

    /**
     * creates and runs the game
     */
    public Game() {
        gameBoard = new Board();
        currentPlayer = "white";

        // create piece classes for both teams
        // 8 pawns, 2 rooks, 2 knights, 2 bishops, 1 king, 1 queen for each
    }

    /**
     * gets a move from the user
     * @return an arraylist with the original location and the new location of the piece the user wants to move
     */
    public ArrayList<Integer> getPlayerMove() {
        ArrayList<Integer> move = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // take the location of the piece the user wants to move
        // and the location where the user wants to move to

        return move;
    }

    /**
     * a loop that runs until a winner is declared
     */
    public void gameLoop() {
        while (true) { // neither player has won
            // run the game
        }
    }
}
