public class Queen extends Piece {
    /**
     * constructor that creates a queen of the given color
     * @param color of the queen
     */
    public Queen(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            character = (char)9819;
        }
        else {
            character = (char)9813;
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
