import java.util.*;

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

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public int toInt(char c) {
        char [] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return i;
            }
        }
        return -1;
    }

    public Map<String, Integer> getPlayerMove() {
        Map<String, Integer> userMove = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                // get starting piece from user
                int startRow;
                int startCol;
                System.out.println(currentPlayer.getName() + "'s move");
                System.out.print("Enter the row and column of the piece you want to move: ");
                char startRowChar = sc.next().charAt(0);
                startRow = toInt(startRowChar);
                startCol = sc.nextInt();

                Piece p = gameBoard.getPiece(startRow, startCol);
                // get location where the user wants to move the piece
                int endRow;
                int endCol;
                System.out.print("Enter the row and column of the piece you want to move: ");
                char endRowChar = sc.next().charAt(0);
                endRow = toInt(endRowChar);
                endCol = sc.nextInt();

                // add the moves to the map
                userMove.put("startRow", startRow);
                userMove.put("startCol", startCol);
                userMove.put("endRow", endRow);
                userMove.put("endCol", endCol);

                return userMove;
            }
            catch (InputMismatchException e) {
                System.out.println("Bad Input");
                sc.nextLine();
            }
        }
    }

    /**
     * a loop that runs until a winner is declared
     */
    public void gameLoop() {
        public void gameLoop() {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> userMove;
        int moves = 0;

        while (moves < 400) {
            gameBoard.print();
            boolean validMove = false;
            try {
                userMove = getPlayerMove();
                gameBoard.play(currentPlayer, userMove.get("startRow"), userMove.get("startCol"), userMove.get("endRow"), userMove.get("endCol"));

                if (gameBoard.hasWon(currentPlayer.getColor())) {
                    gameBoard.print();
                    System.out.println(currentPlayer.getName() + " WINS");
                    break;
                }

                switchPlayer();
                moves ++;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        while (moves < 50) {
            gameBoard.print(); // print new board

            userMove = getPlayerMove();

            while(true) {
                // try to make the given move from the user, throw exception if move is invalid
                try {
                    gameBoard.play(currentPlayer, userMove.get("startRow"), userMove.get("startCol"), userMove.get("endRow"), userMove.get("endCol"));
                    break;
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            switchPlayer(); // switch the player
            moves++;
        }
    }
}
