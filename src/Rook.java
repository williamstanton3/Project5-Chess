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
     * @return true if the move is valid, false if it's not
     */
    @Override
    public boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        //valid moves are up, down, left, or right for any direction

        boolean isVert;
        String direction;

        // returns false if the piece tries to change row and column
        if ((startRow != endRow) && (startCol != endCol)) {
            return false;
        }

        // checks to see if move is vertical
        else if (startCol == endCol) {
            isVert = true;
            // checks to see if move is up or down
            if (startRow < endRow) {
                direction = "down";
            }
            else {
                direction = "up";
            }
        }

        // move is horizontal
        else {
            isVert = false;

            // checks to see if the move is left or right
            if (startCol < endCol) {
                direction = "right";
            }
            else {
                direction = "left";
            }
        }

        // returns false if there is a piece in the way
        if (isVert) {
            if (direction.equals("down")) {
                for (int i = startRow; i < endRow; i++) {
                    // if the board at the given index is full, return false because there is a piece in the way
                    if (!board[i][startCol].isEmpty()) {
                        return false;
                    }
                }
            }
            // else direction must be up
            else {
                for (int i = startRow; i > endRow; i--) {
                    // if the board at the given index is full, return false because there is a piece in the way
                    if (!board[i][startCol].isEmpty()) {
                        return false;
                    }
                }
            }
        }




        return true;
    }

}
