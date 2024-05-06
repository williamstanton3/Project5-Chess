public class Queen extends Piece {
    /**
     * constructor that creates a queen of the given color
     * @param color of the queen
     */
    public Queen(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9819);
        }
        else {
            setChar((char)9813);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startCol where the queen begins
     * @param endCol where the queen ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are in all directions for one square.

        // Check if the move is valid (within one square in all directions)
        return ((startRow == endRow) || (startCol == endCol) || (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)));

    }
}
