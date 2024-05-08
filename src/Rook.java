public class Rook extends Piece {
    /**
     * constructor that creates a rook of the given color
     * @param color of the rook
     */
    public Rook(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9820); // ascii character for white rook
        }
        else {
            setChar((char)9814); // ascii character for black rook
        }
    }

    /**
     * checks to see if the move is valid based on the rules
     * the rook can move horizontally or vertically for any distance as long as there is no piece in the way
     * @param board the current board
     * @param startRow the row of the piece the user wants to move
     * @param startCol the column of the piece of the user wants to move
     * @param endRow the row where the user wants to move to
     * @param endCol the column where the user wants to move to
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        // return false if rook changes row and column (move is not straight)
        if (startRow != endRow && startCol != endCol) {
            return false;
        }

        // return false if there is a piece in te way
        if (pieceInWayStraight(board, startRow, startCol, endRow, endCol)) {
            return false;
        }

        // else, return true
         return true;
    }

}
