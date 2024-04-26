public class Board {

    private static final int SIZE = 8;

    private Piece[][] currentBoard = new Piece[SIZE][SIZE];

    /**
     * Creates the starting Chess Board
     */
    public Board() {
        // initialize black pieces
        // pawn 1
        Pawn blackPawn1 = new Pawn("black", 1, 0);
        currentBoard[1][0] = blackPawn1;
        // pawn 2
        Pawn blackPawn2 = new Pawn("black", 1, 1);
        currentBoard[1][1] = blackPawn2;
        // pawn 3
        Pawn blackPawn3 = new Pawn("black", 1, 2);
        currentBoard[1][2] = blackPawn3;
        // pawn 4
        Pawn blackPawn4 = new Pawn("black", 1, 3);
        currentBoard[1][3] = blackPawn4;
        // pawn 5
        Pawn blackPawn5 = new Pawn("black", 1, 4);
        currentBoard[1][4] = blackPawn5;
        // pawn 6
        Pawn blackPawn6 = new Pawn("black", 1, 5);
        currentBoard[1][5] = blackPawn6;
        // pawn 7
        Pawn blackPawn7 = new Pawn("black", 1, 6);
        currentBoard[1][6] = blackPawn7;
        // pawn 8
        Pawn blackPawn8 = new Pawn("black", 1, 7);
        currentBoard[1][7] = blackPawn8;
        // black rook 1
        Rook blackRook1 = new Rook("black", 0, 0);
        currentBoard[0][0] = blackRook1;
        // black knight 1
        Knight blackKnight1 = new Knight("black", 0, 1);
        currentBoard[0][1] = blackKnight1;
        // black bishop 1
        Bishop blackBishop1 = new Bishop("black", 0, 2);
        currentBoard[0][2] = blackBishop1;
        // black queen
        Queen blackQueen = new Queen("black", 0, 3);
        currentBoard[0][3] = blackQueen;
        // black king
        King blackKing = new King("black", 0, 4);
        currentBoard[0][4] = blackKing;
        // black bishop 2
        Bishop blackBishop2 = new Bishop("black", 0, 5);
        currentBoard[0][5] = blackBishop2;
        // black knight 2
        Knight blackKnight2 = new Knight("black", 0, 6);
        currentBoard[0][6] = blackKnight2;
        // black rook 2
        Rook blackRook2 = new Rook("black", 0, 7);
        currentBoard[0][7] = blackRook2;


        // initialize white pieces
        // pawn 1
        Pawn whitePawn1 = new Pawn("white", 1, 0);
        currentBoard[6][0] = whitePawn1;
        // pawn 2
        Pawn whitePawn2 = new Pawn("white", 1, 1);
        currentBoard[6][1] = whitePawn2;
        // pawn 3
        Pawn whitePawn3 = new Pawn("white", 1, 2);
        currentBoard[6][2] = whitePawn3;
        // pawn 4
        Pawn whitePawn4 = new Pawn("white", 1, 3);
        currentBoard[6][3] = whitePawn4;
        // pawn 5
        Pawn whitePawn5 = new Pawn("white", 1, 4);
        currentBoard[6][4] = whitePawn5;
        // pawn 6
        Pawn whitePawn6 = new Pawn("white", 1, 5);
        currentBoard[6][5] = whitePawn6;
        // pawn 7
        Pawn whitePawn7 = new Pawn("white", 1, 6);
        currentBoard[6][6] = whitePawn7;
        // pawn 8
        Pawn whitePawn8 = new Pawn("white", 1, 7);
        currentBoard[6][7] = whitePawn8;
        // black rook 1
        Rook whiteRook1 = new Rook("white", 0, 0);
        currentBoard[7][0] = whiteRook1;
        // black knight 1
        Knight whiteKnight1 = new Knight("white", 0, 1);
        currentBoard[7][1] = whiteKnight1;
        // black bishop 1
        Bishop whiteBishop1 = new Bishop("white", 0, 2);
        currentBoard[7][2] = whiteBishop1;
        // black queen
        Queen whiteQueen = new Queen("white", 0, 3);
        currentBoard[7][3] = whiteQueen;
        // black king
        King whiteKing = new King("white", 0, 4);
        currentBoard[7][4] = whiteKing;
        // black bishop 2
        Bishop whiteBishop2 = new Bishop("white", 0, 5);
        currentBoard[7][5] = whiteBishop2;
        // black knight 2
        Knight whiteKnight2 = new Knight("white", 0, 6);
        currentBoard[7][6] = whiteKnight2;
        // black rook 2
        Rook whiteRook2 = new Rook("white", 0, 7);
        currentBoard[7][7] = whiteRook2;
    }

    /**
     * prints the current Board
     */
    public void print() {
        for (int row = 0; row < SIZE; row++) {
            System.out.println("");
            System.out.println("---------------------------------");

            for (int col = 0; col < SIZE; col++) {
                if (currentBoard[row][col] == null) {
                    System.out.print("| " + " " + " ");
                }
                else {
                    System.out.print("| " + currentBoard[row][col].getCharacter() + " ");
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("---------------------------------");
    }
    /**
     * gets the column of a given position
     * @param position a square on the chess board
     * @return the column of that square
     */

    public int getColumn(int position) {
        return (position -1) % SIZE;
    }

    /**
     * gets the row of a given position
     * @param position a square on the chess board
     * @return the row of that square
     */
    public int getRow(int position) {
        return (position -1) % SIZE;
    }

    /**
     * Add a move to the board
     * @param currentPlayer white or black
     * @param startingSpot the location of the piece the user wants to move
     * @param endingSpot the location where the user wants to move the piece
     * @throws Exception if the location is invalid or is taken by a piece of the same color as user
     */
    public void play(String currentPlayer, int startingSpot, int endingSpot) throws Exception{
        if (endingSpot < 0 || endingSpot > SIZE * SIZE) {
            throw new Exception("CANNOT PLAY THERE");
        }
        int row = getRow(endingSpot);
        int col = getColumn(endingSpot);
        // first, check to see if the move is valid (based on rules)

        if (currentPlayer.equals("white")) {
            // if the white player is trying to move to a spot with another white piece
            if (isWhite(row, col)) {
                throw new Exception("CANNOT PLAY THERE");
            }
            else {
                // update board
            }
        }
        else { // currentPlayer is black
            if (isBlack(row, col)) {
                throw new Exception("CANNOT PLAY THERE");
            }
            else {
                // update board
            }
        }
        // first, check to see if the move is valid (based on rules)
        // check to see if there is a piece in the endingSpot
        // if there is, check to see which color it is
        // if its color is the same as the currentPlayer's, invalid move
        // if it's not, move the piece to the endingSpot, get rid of old piece
    }

    /**
     * checks to see if the char at a given location is white
     * @param row of the location
     * @param col of the location
     * @return true or false
     */
    public boolean isWhite(int row, int col) {
        for (int i = 9818; i < 9823; i++) {
            if (currentBoard[row][col].getCharacter() == (char)i) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if the char at a given location is black
     * @param row of the location
     * @param col of the location
     * @return true of false
     */
    public boolean isBlack(int row, int col) {
        for (int i = 9812; i < 9817; i++) {
            if (currentBoard[row][col].getCharacter() == (char)i) {
                return true;
            }
        }
        return false;
    }
}


