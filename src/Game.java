import java.util.*;

public class Game {
    /**
     * the first player in the game
     */
    private Player player1;
    /**
     * the second player in the game
     */
    private Player player2;
    /**
     * the current gameBoard
     */
    Board gameBoard;
    /**
     * the player whose turn it is
     */
    private Player currentPlayer;

    /**
     * constructor that creates a gameBoard with the given players
     * @param player1 the first player (white)
     * @param player2 the second player (black)
     */
    public Game(Player player1, Player player2) {
        //initialize the players
        this.player1 = player1;
        this.player2 = player2;

        //Initialize the board and current player ( set current player to player1)
        gameBoard = new Board();
        currentPlayer = player1;
    }

    /**
     * switches the current Player
     */
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    /**
     * converts a given char to its respective int (A = 0, B = 1, ...)
     * purpose: the user will enter the char of the row in the gameBoard, which must be converted to an int
     * @param c the given char
     * @return and int that corresponds with the given char
     */
    public int toInt(char c) {
        char [] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}; // the 8 rows on the board
        //convert the letters into numerical values to map onto the 2D array
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * gets the player move from the user and stores it in a map of Strings (starting and ending rows and columns) and ints (their values)
     * does not check to see if the move is valid
     * @return a map with the player move
     */
    public Map<String, Integer> getPlayerMove() {
        //initialize user move hashMap
        Map<String, Integer> userMove = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        //initialize the move notation
        int startRow, startCol, endRow, endCol;

        while (true) {
            try {
                System.out.println(currentPlayer.getName() + "'s move");

                // gets starting row from user
                System.out.print("Starting Row: " );
                String startRowString = sc.next().toUpperCase();
                char startRowChar = startRowString.charAt(0);

                startRow = toInt(startRowChar); // converts char to corresponding int

                // gets starting Column from user
                System.out.print("Starting Column: ");
                startCol = sc.nextInt();

                // gets ending row from user
                System.out.print("Ending Row: " );
                String endRowString = sc.next().toUpperCase();
                char endRowChar = endRowString.charAt(0);
                endRow = toInt(endRowChar); // converts char to corresponding int

                // gets ending Column from user
                System.out.print("Ending Column: ");
                endCol = sc.nextInt();


                // add the moves to the map
                userMove.put("startRow", startRow);
                userMove.put("startCol", startCol);
                userMove.put("endRow", endRow);
                userMove.put("endCol", endCol);

                return userMove;
            }

            // throw exception if the user doesn't enter valid input
            catch (InputMismatchException e) {
                System.out.println("Bad Input");
                sc.nextLine();
            }
        }
    }

    /**
     * the game loop that runs until someone wins the game
     * players alternate turns to move a single piece on the board based on the rules of chess
     * the goal is to kill the opponent's king
     */
    public void gameLoop() {
        Map<String, Integer> userMove;
        boolean hasWon = false;

        while (!hasWon) { // iterates until someone wins
            gameBoard.print();

            try {
                userMove = getPlayerMove();
                //retrieve userMove
                gameBoard.play(currentPlayer, userMove.get("startRow"), userMove.get("startCol"), userMove.get("endRow"), userMove.get("endCol"));

                // checks to see if the current player has won
                if (gameBoard.hasWon(currentPlayer.getColor())) {
                    gameBoard.print();
                    System.out.println(currentPlayer.getName() + " WINS");
                    hasWon = true;
                }

                switchPlayer();
            }
            // throws exception if move isn't valid
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Board getGameBoard() {
        return gameBoard; 
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
