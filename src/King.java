public class King extends Piece {
    /**
     * constructor that creates a King of the given color
     * @param color of the king
     */
    public King(String color, char row, int col) {
        //set position and color of the King piece
        super(color,row,col);
        if (color.equals("white")) {
            setChar((char)9818); // ascii character for the white king
        }
        else {
            setChar((char)9812); // ascii character for the black king
        }
    }

    /**
     * checks to see if the move is valid based on rules
     * king can only move one spot in any direction (horizontal, vertical, diagonal) (can move backward)
     * @param board the current board
     * @param startRow the row of the piece the user wants to move
     * @param startCol the column of the piece of the user wants to move
     * @param endRow the row where the user wants to move to
     * @param endCol the column where the user wants to move to
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        // Calculate absolute differences in row and column indices
        int diffX = Math.abs(startRow - endRow);
        int diffY = Math.abs(startCol - endCol);

        // return true if the differences are both less than or equal to one (move is only one square in any direction)
        return diffX <= 1 && diffY <= 1;
    }
}
