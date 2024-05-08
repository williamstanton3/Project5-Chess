abstract class Piece {
    /**
     * the chess piece symbol (using ascii characters)
     */
    private char character;
    /**
     * the color of the piece (white or black)
     */
    private String color;
    /**
     * the row that the piece is currently on
     */
    private int row;
    /**
     * the column that the piece is currently on
     */
    private int col;

    /**
     * Constructor that initializes the color and starting location of the piece
     * @param color the color of the piece
     * @param row the starting row
     * @param col the starting column
     */
    public Piece (String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    /**
     * abstract class that is implemented differently in each child class
     * checks to see if a given move is valid based on the state of the board and the rules of chess
     * @param board the current board
     * @param startRow the row of the piece the user wants to move
     * @param startCol the column of the piece of the user wants to move
     * @param endRow the row where the user wants to move to
     * @param endCol the column where the user wants to move to
     * @return true if the move is valid, false if it's not
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
     * gets the color of the piece
     * @return the color (white or black)
     */
    public String getColor() {
        return color;
    }

    /**
     * updates the character of the piece
     * @param newChar the new char
     */
    public void setChar(char newChar){
        character = newChar;
    }


    /**
     * checks to see if there is a piece in the way if move is straight (horizontal/vertical)
     * written in Piece class, so it can be accessed by both the rook and queen classes
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true if there is a piece in the way, false if there is not
     */
    public boolean pieceInWayStraight(Piece [][] board, int startRow, int startCol, int endRow, int endCol) {

        // if move is up
        if (startRow > endRow) {
            for (int i = startRow - 1; i > endRow; i--) {
                if (board[i][startCol] != null) {
                    System.out.println(i);
                    return true;
                }
            }
        }

        // if move is down
        if (startRow < endRow) {
            for (int i = startRow + 1; i < endRow; i++) {
                if (board[i][startCol] != null) {
                    return true;
                }
            }
        }

        // if move is left
        if (startCol > endCol) {
            for (int i = startCol - 1; i > endCol; i--) {
                if (board[startRow][i] != null) {
                    return true;
                }
            }
        }

        // if move is right
        if (startCol < endCol) {
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
     * also written in piece class, so it can be accessed by queen class as well as bishop class
     * @param board the current board
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return true if there is a piece in the way, false if there is not
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
                j--;
            }
        }

        // if move is down and right
        else if (directionHor.equals("right") && (directionVert.equals("down"))) {
            System.out.println("down and right");
            int j = startCol + 1;
            for (int i = startRow +1; i < endRow; i++) {
                if (board[i][j] != null) {
                    System.out.println("ayo");
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
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
                j--;
            }
        }

        return false;

    }

}
