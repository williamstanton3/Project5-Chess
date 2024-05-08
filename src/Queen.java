public class Queen extends Piece {
    /**
     * constructor that creates a queen of the given color
     * @param color of the queen
     */
    public Queen(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9819); // ascii character for white queen
        }
        else {
            setChar((char)9813); // ascii character for black queen
        }
    }

    /**
     * checks to see if the move is valid based on the rules
     * queen can move for any distance in any direction as long as there is no piece in the way
     * @param board the current board
     * @param startRow the row of the piece the user wants to move
     * @param startCol the column of the piece of the user wants to move
     * @param endRow the row where the user wants to move to
     * @param endCol the column where the user wants to move to
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        // move is horizontal or vertical
        if (startRow == endRow || startCol == endCol) {
            if (!pieceInWayStraight(board, startRow, startCol, endRow, endCol)) {
                return true;
            }
        }

        // move is diagonal
        else if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
            if (!pieceInWayDiagonal(board, startRow, startCol, endRow, endCol)) {
                return true;
            }
        }

        return false;

    }
}
