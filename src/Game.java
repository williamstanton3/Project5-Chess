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
    public Game() throws Exception {
        Scanner sc = new Scanner(System.in);
        gameBoard = new Board();
        currentPlayer = "white";
        while(true) {
            ArrayList<Integer> move = new ArrayList<>();
            gameBoard.print();
            System.out.println(currentPlayer + "'s move");
            System.out.println("Enter index of piece you want to move: ");
            move.add(sc.nextInt());
            Piece p = gameBoard.getPiece(move.get(0));
            // if the user is trying to move a piece that's not his
            if (!currentPlayer.equals(p.getColor())) {
                throw new Exception("Can't play there: That's not your piece");
            }
            if (p.getColor() == null) {
                throw new Exception("Can't play there: That's not your piece");
            }
            System.out.println("Enter index of piece you want to move to: ");
            move.add(sc.nextInt());

            // if the user is trying to move to a spot where there is already a piece with the same color
            if (currentPlayer.equals(gameBoard.getPiece(move.get(1)))) {
                throw new Exception("Can't move there, you already have a piece at that spot");
            }
            // if the user tries to move a piece somewhere that isn't according to the rules
            else if (!p.isValidMove(move.get(0), move.get(1))) {
                throw new Exception("Sorry that move is invalid");
            }
            else {
                p.move(move.get(0), move.get(1));
            }
            break; // stub


        }

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
