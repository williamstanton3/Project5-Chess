public class Pawn extends Piece {
    private boolean beenMoved = false;

    /**
     * constructor that creates a pawn of the given color
     * @param color of the pawn
     */
    public Pawn(String color, char row, int col) {
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
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        // On its first move, the pawn can move two spaces
        if (!beenMoved) {
            if (endRow - startRow == 2 && endCol == startCol) {
                beenMoved = true;
                return true;
            }
        }
        // On any other move, the pawn can only move one space
        else {
            if (endRow - startRow == 1 && endCol == startCol) {
                return true;
            }
        }

        // If there is an enemy piece in the diagonal, it can move there
        if (Math.abs(endCol - startCol) == 1 && endRow - startRow == 1) {
            if (Board.isFull(endRow, endCol)) {
                return true;
            }
        }
        return false;
    }
 }