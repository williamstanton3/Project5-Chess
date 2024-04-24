abstract class Piece {
    private String color;
    private char piece;

    public Piece (String color) {
        this.color = color;
    }

    public char getPiece() {
        return piece;
    }

    public abstract boolean isValidMove(int startingSpot, int endingSpot);



}
