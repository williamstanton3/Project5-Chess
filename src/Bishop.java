public class Bishop extends Piece {

    /**
     * constructor that creates a bishop of the given color
     * @param color of the bishop
     */
    public Bishop(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9821);
        }
        else {
            setChar((char)9815);
        }
    }

    /**
     * checks to see if a given move is valid based on the rules of the game
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        //valid moves are in all directions for one square.

        // Check if the move is valid (diagonal)
        return (startRow - startCol == endRow - endCol);
    }
}
