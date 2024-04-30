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
     * @param startingSpot where the rook begins
     * @param endingSpot where the rook ends
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

        String direction;


        // checks to see if there is a piece in the way
        if ((startX != endX) && (startY != endY)) {
            return false;
        }
        if (startX == endX) {
            for (int i = 0; i < endX - startX; i++) {

            }
        }
        else {
            direction = "vert";
        }


        // Check if the move is valid (within one square in all directions)
        return true;
    }

}
