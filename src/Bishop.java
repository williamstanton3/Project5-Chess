public class Bishop extends Piece {

    /**
     * constructor that creates a bishop of the given color
     * @param color of the bishop
     */
    public Bishop(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            character = (char)9821;
        }
        else {
            character = (char)9815;
        }
    }

    /**
     * checks to see if a given move is valid based on the rules of the game
     * @param endingSpot where the bishop ends
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(int startingSpot, int endingSpot) {
        //valid moves are in all directions for one square.

        // Convert positions to row and column
        int startX = startingSpot / 8;
        int startY = startingSpot % 8;
        int endX = endingSpot / 8;
        int endY = endingSpot % 8;

        // Check if the move is valid (within one square in all directions)
        return (startX - startY == endX - endY);

    }
}
