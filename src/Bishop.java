public class Bishop extends Piece {
    /**
     * a char of the bishop, either white or black
     */
    private char piece;

    /**
     * constructor that creates a bishop of the given color
     * @param color of the bishop
     */
    public Bishop(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            piece = (char)9821;
        }
        else {
            piece = (char)9815;
        }
    }

    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the bishop begins
     * @param endingSpot where the bishop ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        return false; // stub

    }
}
