public class Rook extends Piece {
    /**
     * constructor that creates a rook of the given color
     * @param color of the rook
     */
    public Rook(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9820);
        }
        else {
            setChar((char)9814);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are up, down, left, or right for any direction

        if (startRow != endRow && startCol != endCol) {
            System.out.println("hey 1");
            return false;
        }

        if (pieceInWayRook(board, startRow, startCol, endRow, endCol)) {
            System.out.println("hey 2");
            return false;
        }

         return true;
    }

}
