public class Board {

    private static final int SIZE = 8;

    private char[][] currentBoard = new char[SIZE][SIZE];

    /**
     * Creates the starting Chess Board
     */
    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                currentBoard[i][j] = ' ';
            }
        }
    }

    /**
     * prints the current Board
     */
    public void print() {
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                System.out.println(currentBoard[j][i]);
                if (i < SIZE - 1) {
                    System.out.println("|");
                }
            }
            System.out.println();
            if (j < SIZE - 1) {
                for (int i = 0; i < (SIZE * 2) - 1; i++) {
                    System.out.println("-");
                }
                System.out.println();
            }
        }
    }

    /**
     * gets the column of a given position
     * @param position a square on the chess board
     * @return the column of that square
     */

    public int getColumn(int position) {
        return (position -1) % SIZE;
    }

    /**
     * gets the row of a given position
     * @param position a square on the chess board
     * @return the row of that square
     */
    public int getRow(int position) {
        return (position -1) % SIZE;
    }

    /**
     * Add a move to the board
     * @param currentPlayer white or black
     * @param startingSpot the location of the piece the user wants to move
     * @param endingSpot the location where the user wants to move the piece
     * @throws Exception if the location is invalid or is taken by a piece of the same color as user
     */
    public void play(String currentPlayer, int startingSpot, int endingSpot) throws Exception{
        if (endingSpot < 0 || endingSpot > SIZE * SIZE) {
            throw new Exception("CANNOT PLAY THERE");
        }
        int row = getRow(endingSpot);
        int col = getColumn(endingSpot);
        // first, check to see if the move is valid (based on rules)

        if (currentPlayer.equals("white")) {
            // if the white player is trying to move to a spot with another white piece
            if (isWhite(row, col)) {
                throw new Exception("CANNOT PLAY THERE");
            }
            else {
                // update board
            }
        }
        else { // currentPlayer is black
            if (isBlack(row, col)) {
                throw new Exception("CANNOT PLAY THERE");
            }
            else {
                // update board
            }
        }
        // first, check to see if the move is valid (based on rules)
        // check to see if there is a piece in the endingSpot
        // if there is, check to see which color it is
        // if its color is the same as the currentPlayer's, invalid move
        // if it's not, move the piece to the endingSpot, get rid of old piece
    }

    /**
     * checks to see if the char at a given location is white
     * @param row of the location
     * @param col of the location
     * @return true or false
     */
    public boolean isWhite(int row, int col) {
        for (int i = 9818; i < 9823; i++) {
            if (currentBoard[row][col] == (char)i) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if the cahr at a given locaiton is black
     * @param row of the location
     * @param col of the location
     * @return true of false
     */
    public boolean isBlack(int row, int col) {
        for (int i = 9812; i < 9817; i++) {
            if (currentBoard[row][col] == (char)i) {
                return true;
            }
        }
        return false;
    }
}


