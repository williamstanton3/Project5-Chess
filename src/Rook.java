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
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        //valid moves are up, down, left, or right for any direction

        String direction;

        // checks to see if there is a piece in the way
        if ((startRow != endRow) && (startCol != endCol)) {
            return false;
        }
        return true;


        // Check if the move is valid (within one square in all directions)
        return true;
    }

}
