public class Queen extends Piece {
    /**
     * a char of the queen, either white or black
     */
    private char piece;
    /**
     * constructor that creates a queen of the given color
     * @param color of the queen
     */
    public Queen(String color) {
        super(color);
        if (color.equals("white")) {
            piece = (char)9819;
        }
        else {
            piece = (char)9813;
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the queen begins
     * @param endingSpot where the queen ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        // stub
        return false;

        // check to see if a move from the given startingSpot to the given endingSpot
        // is legal for this piece

    }
}
