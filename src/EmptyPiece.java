public class EmptyPiece extends Piece {

    /**
     * Constructor that holds all the specs of the piece
     *
     * @param color determines which team this piece is attached too
     * @param row   (position)
     * @param col   (position)
     */
    public EmptyPiece(String color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(Piece[][] board, int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
