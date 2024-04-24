abstract class Piece {
    private String color;
    private int xAxis;
    private int yAxis;

    /**
     * Constructor that holds all the specs of the piece
     * @param color determines which team this piece is attached too
     * @param xAxis (position)
     * @param yAxis (position)
     */
    public Piece (String color, Integer xAxis, Integer yAxis) {
        this.color = color;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    /**
     * Abstract method to test whether a move can be made by a certain piece
     * @param startingSpot
     * @param endingSpot
     * @return a boolean as to weather certain positions are valid
     */
    public abstract boolean isValidMove(int startingSpot, int endingSpot);

    /**
     *
     * @return the xAxis
     */
    public int getX(){
        return xAxis;
    }

    /**
     *
     * @return the yAxis
     */
    public int getY(){
        return yAxis;
    }

    /**
     *
     * @param newX
     * @return xAxis as newX
     */
    public int setX(int newX){
        return xAxis = newX;
    }

    /**
     *
     * @param newY
     * @return yAxis as newY
     */
    public int setY(int newY){
        return yAxis = newY;
    }

    /**
     *
     * @param x position that we want the piece moved to
     * @param y position that we want the piece moved to
     * @return the new positional coordinates
     */
    public Integer move(int x, int y){
        if(isValidMove(x,y)){
            setX(x);
            setY(y);
        }
        return getX() + getY();
    }


}
