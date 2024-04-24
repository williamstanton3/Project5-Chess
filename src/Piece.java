abstract class Piece {
    private String color;

    public Piece (String color) {
        this.color = color;
    }

    public abstract boolean isValidMove(int startingSpot, int endingSpot);



}
