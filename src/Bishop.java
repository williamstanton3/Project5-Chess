public class Bishop extends Piece {
    /**
     * a constructor that creates a bishop of a given color at a given location
     * @param color the color of the bishop (black or white)
     * @param row the starting row
     * @param col the starting column
     */
    public Bishop(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9821); // ascii character for white bishop
        }
        else {
            setChar((char)9815); // ascii character for black bishop
        }
    }

    /**
     * checks to see if the given move is valid based on the rules
     * a bishop can move diagonally in any direction for any distance, but cannot jump over pieces
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true if the move is valid, false if it is not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        // if move is not diagonal, return false
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // if there is a piece in the way, return false
        if (pieceInWayDiagonal(board, startRow, startCol, endRow, endCol)) {
            return false;
        }

        // else, return true
        return true;
    }
}
