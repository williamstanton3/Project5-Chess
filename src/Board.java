import java.util.ArrayList;

public class Board {
    /**
     * an arrayList that holds all the white pieces that have been killed
     */
    private ArrayList<Piece> whiteDead = new ArrayList<>();
    /**
     * an arrayList that holds all the black pieces that have been killed
     */
    private ArrayList<Piece> blackDead = new ArrayList<>();

    /**
     * size of the chess board
     */
    private static final int SIZE = 8;

    /**
     * a 2-D array of Pieces that represents the current chess board
     */
    private static Piece[][] currentBoard = new Piece[SIZE][SIZE];

    /**
     * the black king piece
     * declared outside constructor so it is visible in hasWon method
     */
    private King blackKing;

    /**
     * the white king piece
     * declared outside constructor so it is visible in hasWon method
     */
    private King whiteKing;

    /**
     * Constructor that creates the all the chess pieces and the starting chess board
     */
    public Board() {

        // initialize black pieces
        // pawn 1
        Pawn blackPawn1 = new Pawn("black", 'B', 0);
        currentBoard[1][0] = blackPawn1;
        // pawn 2
        Pawn blackPawn2 = new Pawn("black", 'B', 1);
        currentBoard[1][1] = blackPawn2;
        // pawn 3
        Pawn blackPawn3 = new Pawn("black", 'B', 2);
        currentBoard[1][2] = blackPawn3;
        // pawn 4
        Pawn blackPawn4 = new Pawn("black", 'B', 3);
        currentBoard[1][3] = blackPawn4;
        // pawn 5
        Pawn blackPawn5 = new Pawn("black", 'B', 4);
        currentBoard[1][4] = blackPawn5;
        // pawn 6
        Pawn blackPawn6 = new Pawn("black", 'B', 5);
        currentBoard[1][5] = blackPawn6;
        // pawn 7
        Pawn blackPawn7 = new Pawn("black", 'B', 6);
        currentBoard[1][6] = blackPawn7;
        // pawn 8
        Pawn blackPawn8 = new Pawn("black", 'B', 7);
        currentBoard[1][7] = blackPawn8;
        // black rook 1
        Rook blackRook1 = new Rook("black", 'A', 0);
        currentBoard[0][0] = blackRook1;
        // black knight 1
        Knight blackKnight1 = new Knight("black", 'A', 1);
        currentBoard[0][1] = blackKnight1;
        // black bishop 1
        Bishop blackBishop1 = new Bishop("black", 'A', 2);
        currentBoard[0][2] = blackBishop1;
        // black queen
        Queen blackQueen = new Queen("black", 'A', 3);
        currentBoard[0][3] = blackQueen;
        // black king
        blackKing = new King("black", 'A', 4);
        currentBoard[0][4] = blackKing;
        // black bishop 2
        Bishop blackBishop2 = new Bishop("black", 'A', 5);
        currentBoard[0][5] = blackBishop2;
        // black knight 2
        Knight blackKnight2 = new Knight("black", 'A', 6);
        currentBoard[0][6] = blackKnight2;
        // black rook 2
        Rook blackRook2 = new Rook("black", 'A', 7);
        currentBoard[0][7] = blackRook2;

        // initialize white pieces
        // pawn 1
        Pawn whitePawn1 = new Pawn("white", 'G', 0);
        currentBoard[6][0] = whitePawn1;
        // pawn 2
        Pawn whitePawn2 = new Pawn("white", 'G', 1);
        currentBoard[6][1] = whitePawn2;
        // pawn 3
        Pawn whitePawn3 = new Pawn("white", 'G', 2);
        currentBoard[6][2] = whitePawn3;
        // pawn 4
        Pawn whitePawn4 = new Pawn("white", 'G', 3);
        currentBoard[6][3] = whitePawn4;
        // pawn 5
        Pawn whitePawn5 = new Pawn("white", 'G', 4);
        currentBoard[6][4] = whitePawn5;
        // pawn 6
        Pawn whitePawn6 = new Pawn("white", 'G', 5);
        currentBoard[6][5] = whitePawn6;
        // pawn 7
        Pawn whitePawn7 = new Pawn("white", 'G', 6);
        currentBoard[6][6] = whitePawn7;
        // pawn 8
        Pawn whitePawn8 = new Pawn("white", 'G', 7);
        currentBoard[6][7] = whitePawn8;
        // black rook 1
        Rook whiteRook1 = new Rook("white", 'H', 0);
        currentBoard[7][0] = whiteRook1;
        // black knight 1
        Knight whiteKnight1 = new Knight("white", 'H', 1);
        currentBoard[7][1] = whiteKnight1;
        // black bishop 1
        Bishop whiteBishop1 = new Bishop("white", 'H', 2);
        currentBoard[7][2] = whiteBishop1;
        // black queen
        Queen whiteQueen = new Queen("white", 'H', 3);
        currentBoard[7][3] = whiteQueen;
        // black king
        whiteKing = new King("white", 'H', 4);
        currentBoard[7][4] = whiteKing;
        // black bishop 2
        Bishop whiteBishop2 = new Bishop("white", 'H', 5);
        currentBoard[7][5] = whiteBishop2;
        // black knight 2
        Knight whiteKnight2 = new Knight("white", 'H', 6);
        currentBoard[7][6] = whiteKnight2;
        // black rook 2
        Rook whiteRook2 = new Rook("white", 'H', 7);
        currentBoard[7][7] = whiteRook2;
    }

    /**
     * converts a given int to the corresponding char
     * @param i a given integer
     * @return the corresponding char
     */
    public char toChar(int i) {
        int asciiValue = 65 + i;
        return (char) asciiValue; }

    /**
     * prints the current Board
     */
    public void print() {
        for (int row = 0; row < SIZE; row++) {
            System.out.println();
            System.out.println("   -----------------------------------");
            System.out.print(toChar(row) + "  "); // prints the row chars

            for (int col = 0; col < SIZE; col++) {
                // if the spot doesn't have a piece in it
                if (currentBoard[row][col] == null) {
                    System.out.print("|");
                    for (int i = 0; i < 4; i++) {
                        System.out.print("\u2002");
                    }
                }
                // if the spot has a piece in it
                else {
                    System.out.print("|" + "\u2002" + currentBoard[row][col].getCharacter() + "\u2002");
                }

            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("   -----------------------------------");
        System.out.print("   ");

        // print the column numbers
        for (int i = 0; i < 8; i++) {
            System.out.print("\u2002" + "\u2002" + i + "\u2002" + "\u2002");
        }
        System.out.println();
    }

    /**
     * gets a Piece given a row and column on the board
     * @param row the given row
     * @param col the given column
     * @return the piece at that location or a dummy piece if the location is empty
     */
    public Piece getPiece (int row, int col) {
        // creates a dummy piece to return if the spot given by the row and col is empty
        Piece p = new EmptyPiece("empty", -1, -1);
        if (isEmpty(row, col)) {
            return p;
        }
        else {
            return currentBoard[row][col];
        }
    }

    /**
     * checks to see if a given location on the board is empty
     * @param row the given row
     * @param col the given column
     * @return true if there is no piece at the given location, false if there is
     */
    public boolean isEmpty(int row, int col) {
        return currentBoard[row][col] == null;
    }

    /**
     * checks to see if a player of a given color has won
     * @param color the color of the current player
     * @return true if the current player's opponent's king has been killed (and is in the arrayList of dead pieces)
     */
    public boolean hasWon(String color) {
        if (color.equals("white")) {
            // if the black king is dead, the white player has won
            if (blackDead.contains(blackKing)) {
                return true;
            }
        }
        if (color.equals("black")) {
            // if the white king is dead, the black player has won
            if (whiteDead.contains(whiteKing)) {
                return true;
            }
        }
        return false;
    }

    /**
     * moves a piece on the board given the starting and ending rows and columns
     * @param startRow the starting Row
     * @param startCol the starting Column
     * @param endRow the ending Row
     * @param endCol the ending Column
     */
    public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        currentBoard[endRow][endCol] = getPiece(startRow, startCol); // moves the piece at the starting spot to the ending spot
        currentBoard[startRow][startCol] = null; // makes the starting spot empty now that the piece has moved
    }

    /**
     * takes input and checks to see if the given move is valid based on the state of the board and the rules of the games
     * if the move is valid, it updates the board
     * @param currentPlayer the player whose turn it is
     * @param startRow the row of the piece the player wants to move
     * @param startCol the column of the piece the player wants to move
     * @param endRow the row where the player wants to move his piece
     * @param endCol the column where the player wants to move his piece
     * @throws Exception if the move is invalid for a variety of reasons
     */
    public void play(Player currentPlayer, int startRow, int startCol, int endRow, int endCol) throws Exception {
        // throws exception if endRow or endCol are too large or too small
        if (endCol < 0 || endCol > (SIZE * SIZE) || endRow < 0 || endRow > (SIZE * SIZE)) {
            throw new Exception("CANNOT PLAY THERE. ITS OUTSIDE THE BOARD");
        }

        // throws exception if the starting spot is empty
        else if (isEmpty(startRow, startCol)) {
            throw new Exception("CANNOT PLAY THERE. THE STARTING PIECE IS EMPTY");
        }

        // throws exception if the ending spot is taken by the user
        else if (currentPlayer.getColor().equals(getPiece(endRow, endCol).getColor())) {
            throw new Exception("CANNOT PLAY THERE. YOU ALREADY HAVE A PIECE IN THE ENDING SPOT");
        }

        // throws exception if the currentPlayer's color doesn't equal the starting Piece's color
        else if (!currentPlayer.getColor().equals(getPiece(startRow, startCol).getColor())) {
            throw new Exception("CANNOT PLAY THERE: THAT'S NOT YOUR PIECE");
        }

        // throws exception if move is against the rules
        else if (!getPiece(startRow, startCol).isValidMove(currentBoard, startRow, startCol, endRow, endCol)) {
            throw new Exception("CANNOT MAKE THAT MOVE: IT'S AGAINST THE RULES");
        }

        // if passes the above tests, it is a valid move

        // if the ending spot is empty
        if (isEmpty(endRow, endCol)) {
            movePiece(startRow, startCol, endRow, endCol);
        }

        // if the ending spot is full
        else {
            // add the dead piece to the appropriate arrayList
            if (currentPlayer.getColor().equals("white")) {
                blackDead.add(currentBoard[endRow][endCol]);
            }
            if (currentPlayer.getColor().equals("black")) {
                whiteDead.add(currentBoard[endRow][endCol]);
            }
            movePiece(startRow, startCol, endRow, endCol);
        }
    }

    public Piece[][] getBoard() {
        return currentBoard;
    }
}
