public class Rook extends Piece {
    /**
     * a char of the rook, either white or black
     */
    private char piece;
    /**
     * constructor that creates a rook of the given color
     * @param color of the rook
     */
    public Rook(String color) {
        super(color);
        if (color.equals("white")) {
            piece = (char)9820;
        }
        else {
            piece = (char)9814;
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param startingSpot where the rook begins
     * @param endingSpot where the rook ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        return false; // stub

    }

}
