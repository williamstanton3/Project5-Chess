abstract class Piece {
    private char character;
    private String color;
    private int row;
    private int col;

    /**
     * Constructor that holds all the specs of the piece
     * @param color determines which team this piece is attached too
     * @param row (position)
     * @param col (position)
     */
    public Piece (String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;

    }

    /**
     * Abstract method to test whether a move can be made by a certain piece
     * @param
     * @return a boolean as to weather certain positions are valid
     */
    public abstract boolean isValidMove(Piece [][] board, int startRow, int startCol, int endRow, int endCol);

    /**
     * gets the chess character
     * @return the ches character
     */
    public char getCharacter() {
        return character;
    }
    /**
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }
    /**
     *
     * @return the col
     */
    public int getCol(){
        return col;
    }

    public String getColor() {
        return color;
    }


    public void setChar(char newChar){
        character = newChar;
    }


    /**
     * checks to see if there is a piece in the way if move is straight (horizontal/vertical)
     * written in Piece class so it can be accessed by both the rook and queen classes
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true if there is a piece in the way, false if there is not
     */
    public boolean pieceInWayStraight(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        String direction = "";

        // finds direction of move
        if (startCol < endCol) {
            direction = "right";
        } else if (startCol > endCol) {
            direction = "left";
        } else if (startRow > endRow) {
            direction = "up";
        } else if (startRow < endRow) {
            direction = "down";
        }

        // if move is up
        if (direction.equals("up")) {
            for (int i = startRow - 1; i > endRow; i--) {
                if (board[i][startCol] != null) {
                    System.out.println(i);
                    return true;
                }
            }
        }

        // if move is down
        if (direction.equals("down")) {
            for (int i = startRow + 1; i < endRow; i++) {
                if (board[i][startCol] != null) {
                    return true;
                }
            }
        }

        // if move is left
        if (direction.equals("left")) {
            for (int i = startCol - 1; i > endCol; i--) {
                if (board[startRow][i] != null) {
                    return true;
                }
            }
        }

        // if move is right
        if (direction.equals("right")) {
            for (int i = startCol + 1; i < endCol; i++) {
                if (board[startRow][i] != null) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * checks to see if there is a piece in the way if the move is diagonal
     * also written in piece class so it can be accessed by queen class as well as bishop class
     * @param board
     * @param startRow
     * @param startCol
     * @param endRow
     * @param endCol
     * @return
     */
    public boolean pieceInWayDiagonal(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {
        String directionHor;
        String directionVert;

        if (startCol < endCol) {
            directionHor = "right";
        }
        else {
            directionHor = "left";
        }

        if (startRow > endRow) {
            directionVert = "up";
        }
        else {
            directionVert = "down";
        }

        // if move is up and right
        if (directionHor.equals("right") && (directionVert.equals("up"))) {
            int j = startCol + 1;
            for (int i = startRow -1; i > endRow; i--) {
                if (board[i][j] != null) {
                    return true;
                }
                j++;
            }
        }

        // if move is up and left
        if (directionHor.equals("left") && (directionVert.equals("up"))) {
            int j = startCol -1;
            for (int i = startRow -1; i > endRow; i--) {
                if (board[i][j] != null) {
                    return true;
                }
                j++;
            }
        }

        // if move is down and right
        if (directionHor.equals("right") && (directionVert.equals("down"))) {
            int j = startCol + 1;
            for (int i = startRow +1; i < endRow; i++) {
                if (board[i][j] != null) {
                    return true;
                }
                j++;
            }
        }

        // if move is down and left
        if (directionHor.equals("left") && (directionVert.equals("down"))) {
            int j = startCol -1;
            for (int i = startRow +1; i < endRow; i++) {
                if (board[i][j] != null) {
                    return true;
                }
                j++;
            }
        }

        return false;

    }

}
