public class EmptyPiece extends Piece {
    /**
     * constructor that creates a dummy piece
     * purpose: the getPiece function in the board class must return a Piece. This will allow it to return an
     * empty piece if the given location doesn't contain a game piece.
     * @param color will be "empty"
     * @param row the given row
     * @param col the given column
     */
    public EmptyPiece(String color, int row, int col) {
        super(color, row, col);
    }

    /**
     * will always return true because the empty piece will never be moved, so this function will never be called
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true
     */
    @Override
    public boolean isValidMove(Piece[][] board, int startRow, int startCol, int endRow, int endCol) {
        // always return true because an empty piece will never be moved
        return true;
    }
}