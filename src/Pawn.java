public class Pawn extends Piece {
    /**
     * constructor that creates a pawn of the given color
     * @param color of the pawn
     */
    public Pawn(String color, int row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            character = (char)9823;
        }
        else {
            character = (char)9817;
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
        //on it's first move the pawn can move two spaces
        //on any other move it can only move one space
        //if there is an enemy in front of it, it can move in a diagonal
        // Convert positions to row and column
        int startX = startingSpot / 8;
        int startY = startingSpot % 8;
        int endX = endingSpot / 8;
        int endY = endingSpot % 8;


        return true; // stub

    }
}
