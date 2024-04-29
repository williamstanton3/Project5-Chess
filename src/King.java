public class King extends Piece {
    /**
     * constructor that creates a King of the given color
     * @param color of the king
     */
    public King(String color, int row, int col) {
        //set position and color of the King piece
        super(color,row,col);
        if (color.equals("white")) {
            setChar((char)9818);
        }
        else {
            setChar((char)9812);
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
        //valid moves are in all directions for one square.

        // Convert positions to row and column
        int startX = startingSpot / 8;
        int startY = startingSpot % 8;
        int endX = endingSpot / 8;
        int endY = endingSpot % 8;
        // Calculate absolute differences in row and column indices
        int diffX = Math.abs(startX - endX);
        int diffY = Math.abs(startY - endY);

        // Check if the move is valid (within one square in all directions)
        return diffX <= 1 && diffY <= 1;
    }
}
