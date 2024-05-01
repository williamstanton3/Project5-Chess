public class King extends Piece {
    /**
     * constructor that creates a King of the given color
     * @param color of the king
     */
    public King(String color, char row, int col) {
        //set position and color of the King piece
        super(color,row,col);
        if (color.equals("white")) {
            setChar((char)9818);
        }
        else {
            setChar((char)9812);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     *
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are in all directions for one square.

        // Calculate absolute differences in row and column indices
        int diffX = Math.abs(startRow - endRow);
        int diffY = Math.abs(startCol - endCol);

        // Check if the move is valid (within one square in all directions)
        return diffX <= 1 && diffY <= 1;
    }
}
