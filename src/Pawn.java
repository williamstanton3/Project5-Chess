public class Pawn extends Piece {
    /**
     * constructor that creates a pawn of the given color
     * @param color of the pawn
     */
    public Pawn(String color, char row, int col) {
        super(color, row, col);
        if (color.equals("white")) {
            setChar((char)9823);
        }
        else {
            setChar((char)9817);
        }
    }
    /**
     * checks to see if a given move is valid based on the rules of the game
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //on it's first move the pawn can move two spaces
        //on any other move it can only move one space
        //if there is an enemy in front of it, it can move in a diagonal

        return true;

    }
}
