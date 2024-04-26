public class Knight extends Piece {
    /**
     * constructor that creates a Knight of the given color
     * @param color of the knight
     */
    public Knight(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            character = (char)9822;
        }
        else {
            character = (char)9816;
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the knight begins
     * @param endingSpot where the knight ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        return false; // stub

    }
}
