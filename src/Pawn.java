public class Pawn extends Piece {
    private boolean beenMoved = false;

    /**
     * a constructor that creates a pawn of a given color at a given location
     * @param color the color of the pawn (black or white)
     * @param row the starting row
     * @param col the starting column
     */
    public Pawn(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9823);
        }
        else {
            setChar((char)9817);
        }
    }

    /**
     * checks to see if the given move is valid based on the rules
     * a pawn can move two spots forward on its first move, one spot forward on every other move,
     * but only forward diagonally when attacking another piece
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true if the move is valid, false if it is not
     */
    @Override
    public boolean isValidMove(Piece[][] board, int startRow, int startCol, int endRow, int endCol) {

        // return false if move is backwards
        if (board[startRow][startCol].getColor().equals("white")) {
            if (startRow < endRow) {
                return false;
            }
        }
        if (board[startRow][startCol].getColor().equals("black")) {
            if (endRow < startRow) {
                return false;
            }
        }

        // if move is attacking
        if ((Math.abs(endRow - startRow) == 1) && (Math.abs(endCol - startCol) == 1) && (board[endRow][endCol] != null)) {
            return true;
        }

        // else if move is forward one
        else if (Math.abs(endRow - startRow) == 1 && endCol == startCol) {
            // if ending spot is empty, you can move there
            if (board[endRow][endCol] == null) {
                beenMoved = true;
                return true;
            }
            // if ending spot is taken, you can't move there (you can't attack straight on)
            else {
                return false;
            }

        }

        // On just its first move, the pawn can move two spaces forward
        if (!beenMoved) {
            if (Math.abs(endRow - startRow) == 2 && endCol == startCol) {
                beenMoved = true;
                return true;
            }
        }

        return false;
    }
}