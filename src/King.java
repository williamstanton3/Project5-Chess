public class King extends Piece {
    /**
     * a char of the king, either white or black
     */
    private char piece;
    /**
     * constructor that creates a King of the given color
     * @param color of the king
     */
    public King(String color) {
        super(color);
        if (color.equals("white")) {
            piece = (char)9818;
        }
        else {
            piece = (char)9812;
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the king begins
     * @param endingSpot where the king ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        return false; // stub

    }
}
