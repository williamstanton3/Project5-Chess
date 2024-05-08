public class Knight extends Piece {
    /**
     * constructor that creates a Knight of the given color
     * @param color of the knight
     */
    public Knight(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9822); // ascii character for white knight
        }
        else {
            setChar((char)9816); // ascii character for black knight
        }
    }

    /**
     * checks to see if the move is valid based on the rules
     * the knight can move on an "L" shaped pattern in any direction (2 up 1 over, 2 over 1 up, ...)
     * the knight is also the only piece that can jump over any pieces
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

        // return true if move is in "L" shape
        return ((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2));
    }
}
