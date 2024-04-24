public class Pawn extends Piece {
    /**
     * a char of the pawn, either white or black
     */
    private char piece;
    /**
     * constructor that creates a pawn of the given color
     * @param color of the pawn
     */
    public Pawn(String color) {
        super(color);
        if (color.equals("white")) {
            piece = (char)9823;
        }
        else {
            piece = (char)9817;
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the pawn begins
     * @param endingSpot where the pawn ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        return false; // stub

    }
}
