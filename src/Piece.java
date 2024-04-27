abstract class Piece {
    protected char character;
    protected String color;
    protected int row;
    protected int col;

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
     * @param endingSpot
     * @return a boolean as to weather certain positions are valid
     */
    public abstract boolean isValidMove(int startingSpot, int endingSpot);

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
    public int getRow(){
        return row;
    }

    /**
     *
     * @return the col
     */
    public int getCol(){
        return col;
    }
    /**
     *
     * @param newRow
     */
    public void setRow(int newRow){
        row = newRow;
    }
    /**
     *
     * @param newCol
     */
    public void setCol(int newCol){
        col = newCol;
    }
    /**
     *
     * @param x position that we want the piece moved to
     * @param y position that we want the piece moved to
     * @return the new positional coordinates
     */
    public Integer move(int x, int y) {
        if(isValidMove(x,y)){
            setRow(x);
            setCol(y);
        }
        return getRow() + getCol();
    }

}
