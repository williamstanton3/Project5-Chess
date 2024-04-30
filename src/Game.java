import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    /**
     * the current gameBoard
     */
    private Board gameBoard;
    /**
     * the current Player (white or black)
     */
    private Player currentPlayer;

    /**
     * creates and runs the game
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        gameBoard = new Board();
        currentPlayer = player1;

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
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    /**
     * a loop that runs until a winner is declared
     */
    public void gameLoop() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            gameBoard.print(); // print new board
            switchPlayer(); // switch the player

            // get move from user
            ArrayList<Integer> move = new ArrayList<>();
            System.out.println(currentPlayer.getName() + "'s move");
            System.out.println("Enter index of piece you want to move: ");
            move.add(sc.nextInt());
            Piece p = gameBoard.getPiece(move.get(0));
            System.out.println("Enter index of piece you want to move to: ");
            move.add(sc.nextInt());

            // try to make the given move from the user, throw exception if move is invalid
            try {
                gameBoard.play(currentPlayer, move.get(0), move.get(1));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
