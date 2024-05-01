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

    public int getPosition() {
        return position;
    }
    /**
     *
     * @param newRow
     */

    public void setRow(char newRow){
        row = newRow;
    }
    /**
     *
     * @param newCol
     */
    public void setCol(int newCol){
        col = newCol;
    }
    public void setChar(char newChar){
        character = newChar;
    }

//    /**
//     *
//     * @param x position that we want the piece moved to
//     * @param y position that we want the piece moved to
//     * @return the new positional coordinates
//     */
//    public Integer move(int x, int y) {
//        if(isValidMove(x,y)){
//            setRow(x);
//            setCol(y);
//        }
//        return getRow() + getCol();
//    }

    public boolean isEmpty() {
        return !color.equals("white") && !color.equals("black");
    }

}
