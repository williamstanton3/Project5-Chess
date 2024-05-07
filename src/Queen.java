public class Queen extends Piece {
    /**
     * constructor that creates a queen of the given color
     * @param color of the queen
     */
    public Queen(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9819);
        }
        else {
            setChar((char)9813);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startCol where the queen begins
     * @param endCol where the queen ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are in all directions for any distance


        // check which direction the move is in

        if (startRow == endRow || startCol == endCol) { // move is horizontal or vertical
            if (!pieceInWayStraight(board, startRow, startCol, endRow, endCol)) {
                return true;
            }
        }

//        else if (startCol == endCol) { // move is vertical
//            if (!pieceInWayRook(board, startRow, startCol, endRow, endCol)) {
//                return true;
//            }
//        }

        else if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) // move is diagonal {
            if (!pieceInWayDiagonal(board, startRow, startCol, endRow, endCol)) {
                return true;
            }

        return false;

    }
}
