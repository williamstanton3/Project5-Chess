import java.util.ArrayList;

public class Board {
    /**
     * an arrayList that holds all the white pieces on the baord
     */
    private ArrayList<Piece> whiteAlive = new ArrayList<>();
    /**
     * an arrayList that holds all the black pieces on the board
     */
    private ArrayList<Piece> blackAlive = new ArrayList<>();
    /**
     * an arrayList that holds all the white pieces that have been killed
     */
    private ArrayList<Piece> whiteDead = new ArrayList<>();
    /**
     * an arrayList that holds all the black pieces that have been killed
     */
    private ArrayList<Piece> blackDead = new ArrayList<>();

    private static final int SIZE = 8;

    private static Piece[][] currentBoard = new Piece[SIZE][SIZE];

    private King blackKing;

    private King whiteKing;

    /**
     * Creates the starting Chess Board
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
     * prints the current Board
     */
    public void print() {
        for (int row = 0; row < SIZE; row++) {
            System.out.println("");
            System.out.println("---------------------------------");

            for (int col = 0; col < SIZE; col++) {
                if (currentBoard[row][col] == null) {
                    System.out.print("|    ");
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
        if (position == 0) {
            return 1;
        }
        return (position -1) % SIZE;
    }

    /**
     * gets the row of a given position
     * @param position a square on the chess board
     * @return the row of that square
     */
    public int getRow(int position) {
        if (position == 0) {
            return 1;
        }
        return (position -1) % SIZE;
    }

    public Piece getPiece (int row, int col) {
        if (currentBoard[row][col] == null) {
            return null;
        }
        else {
            return currentBoard[row][col];
        }
    }

    public static boolean isFull(int row, int col) {
        if (currentBoard[row][col] != null) {
            return true;
        }
        return false;
    }

    public boolean hasWon(String color) {
        if (color.equals("white")) {
            if (!blackAlive.contains(blackKing)) {
                return true;
            }
        }
        if (color.equals("black")) {
            if (!whiteAlive.contains(whiteKing)) {
                return true;
            }
        }

        return false;
    }

    public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        currentBoard[endRow][endCol] = getPiece(startRow, startCol);
        currentBoard[startRow][startCol] = null;
    }


    /**
     * Add a move to the board
     * @param currentPlayer white or black
     * @param startRow the location of the piece the user wants to move
     * @param endRow the location where the user wants to move the piece
     * @throws Exception if the location is invalid or is taken by a piece of the same color as user
     */
    public void play(Player currentPlayer, int startRow, int startCol, int endRow, int endCol) throws Exception {
        while (true) {
            if (endCol < 0 || endCol > SIZE * SIZE) {
                throw new Exception("CANNOT PLAY THERE");
            }

            // checks to see if the starting piece is valid
            if (!currentPlayer.getColor().equals(getPiece(startRow, startCol).getColor())) {
                throw new Exception("CANNOT PLAY THERE: THAT'S NOT YOUR PIECE");
            }

            // checks to see if ending spot is valid
            if (isFull(endRow, endCol)) {
                if (currentPlayer.getColor().equals(getPiece(endRow, endCol).getColor())) {
                    throw new Exception("CANNOT PLAY THERE: YOU CAN'T MOVE TO A SPOT WHERE YOU ALREADY HAVE A PIECE");
                }
            }

            // checks to see if the move is valid based on the rules
            else if (!getPiece(startRow, endRow).isValidMove(startRow, startCol, endRow, endCol)) {
                throw new Exception("CANNOT MAKE THAT MOVE: IT'S AGAINST THE RULES");
            }

            // checks to see if endingSpot is empty
            else if (currentBoard[endRow][endCol].isEmpty()) {
                movePiece(startRow, startCol, endRow, endCol);
                break;
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


