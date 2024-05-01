public class Knight extends Piece {
    /**
     * constructor that creates a Knight of the given color
     * @param color of the knight
     */
    public Knight(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9822);
        }
        else {
            setChar((char)9816);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are in all directions for one square.

        // Calculate absolute differences in row and column indices
        int diffX = Math.abs(startRow - endRow);
        int diffY = Math.abs(startCol - endCol);

        // Check if the move is valid (within one square in all directions)
        return ((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2));
    }
}
