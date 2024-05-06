abstract class Piece {
    private char character;
    private String color;
    private int row;
    private int col;
    private int position;

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

        position = (col / 8) + row;
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
        if (color.equals("empty")) {
            return ' ';
        }
        return character;
    }

    public String getColor() {
        return color;
    }
    public void setChar(char newChar){
        character = newChar;
    }

    public boolean isEmpty(Piece [][] board, int row, int col) {
        return board[row][col] == null;
    }

}
