public class Pawn extends Piece {
    private boolean beenMoved = false;

    /**
     * constructor that creates a pawn of the given color
     * @param color of the pawn
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
     * checks to see if a given move is valid based on the rules of the game
     * @return true if the move is valid, false if it's not
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

        // on any move, the pawn can move one space forward
        if (Math.abs(endRow - startRow) == 1 && endCol == startCol) {
            beenMoved = true;
            return true;
        }

        // On just its first move, the pawn can move two spaces forward
        if (!beenMoved) {
            if (Math.abs(endRow - startRow) == 2 && endCol == startCol) {
                beenMoved = true;
                return true;
            }
        }

        // If there is an enemy piece in the diagonal, it can move there
        if ((Math.abs(endCol - startCol) == 1) && (endRow - startRow == 1)) {
            if (!(board[endRow][endCol] == null)) {
                return true;
            }
        }

        return false;
    }
}