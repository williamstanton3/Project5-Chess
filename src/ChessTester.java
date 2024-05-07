import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;

public class ChessTester {

    private Game game;

    @BeforeEach
    public void setUp() {
        Player p1 = new Player("Player 1", "white");
        Player p2 = new Player("Player 2", "black");
        game = new Game(p1, p2);
    }

    @Test
    public void testBoardInitialization() {
        Board board = game.getGameBoard();
        assertNotNull(board);

        // Check the initial setup of the board
        assertEquals(Rook.class, board.getPiece(0, 0).getClass());
        assertEquals(Knight.class, board.getPiece(0, 1).getClass());
        assertEquals(Bishop.class, board.getPiece(0, 2).getClass());
        assertEquals(Queen.class, board.getPiece(0, 3).getClass());
        assertEquals(King.class, board.getPiece(0, 4).getClass());
        assertEquals(Bishop.class, board.getPiece(0, 5).getClass());
        assertEquals(Knight.class, board.getPiece(0, 6).getClass());
        assertEquals(Rook.class, board.getPiece(0, 7).getClass());

        for (int col = 0; col < 8; col++) {
            assertEquals(Pawn.class, board.getPiece(1, col).getClass());
        }

    }


    @Test
    public void testPawnMovement() {
        Board board = game.getGameBoard();

        // Place a pawn at a specific position
        Pawn pawn = new Pawn("white", 1, 0);
        board.getBoard()[1][0] = pawn;

        // Test valid moves for the pawn

        //ToDo: figure out why these tests are failing
//        assertTrue(pawn.isValidMove(board.getBoard(), 1, 0, 2, 0)); // Move one square forward
//        assertTrue(pawn.isValidMove(board.getBoard(), 1, 0, 3, 0)); // Move two squares forward (first move)

        Pawn pawnEnemy = new Pawn("black", 2, 1);
        board.getBoard()[1][0] = pawnEnemy;
//        assertTrue(pawn.isValidMove(board.getBoard(), 1, 0, 2, 1)); // Diagonal capture

        // Test invalid moves for the pawn
        assertFalse(pawn.isValidMove(board.getBoard(), 1, 0, 1, 1)); // Move diagonally without capture
        assertFalse(pawn.isValidMove(board.getBoard(), 1, 0, 0, 0)); // Move backward
        assertFalse(pawn.isValidMove(board.getBoard(), 1, 0, 4, 0)); // Move three squares forward
    }


    @Test
    public void testRookMovement() {
        Board board = game.getGameBoard();

        // Place a rook at a specific position
        Rook rook = new Rook("white", 0, 0);
        board.getBoard()[0][0] = rook;

        // Test valid moves for the rook
        assertTrue(rook.isValidMove(board.getBoard(), 0, 0, 3, 0)); // Move vertically
        assertTrue(rook.isValidMove(board.getBoard(), 0, 0, 0, 3)); // Move horizontally

        // Test invalid moves for the rook
        assertFalse(rook.isValidMove(board.getBoard(), 0, 0, 1, 1)); // Move diagonally
        assertFalse(rook.isValidMove(board.getBoard(), 0, 0, 0, 7)); // Move backward
    }


    @Test
    public void testKnightMovement() {
        Board board = game.getGameBoard();

        // Place a knight at a specific position
        Knight knight = new Knight("white", (char) 0, 2);
        board.getBoard()[0][1] = knight;

        // Test valid moves for the knight
        assertTrue(knight.isValidMove(board.getBoard(), 0, 1, 2, 0)); // L-shaped move
        assertTrue(knight.isValidMove(board.getBoard(), 0, 1, 2, 2)); // L-shaped move
        assertTrue(knight.isValidMove(board.getBoard(), 0, 1, 1, 3)); // L-shaped move

        // Test invalid moves for the knight
        assertFalse(knight.isValidMove(board.getBoard(), 0, 1, 3, 1)); // Invalid move
        assertFalse(knight.isValidMove(board.getBoard(), 0, 1, 3, 2)); // Invalid move
    }

    @Test
    public void testBishopMovement() {
        Board board = game.getGameBoard();

        // Place a bishop at a specific position
        Bishop bishop = new Bishop("white", (char) 0, 2);
        board.getBoard()[0][2] = bishop;

        // Test valid moves for the bishop
        assertTrue(bishop.isValidMove(board.getBoard(), 0, 2, 1, 3)); // Diagonal move
        assertTrue(bishop.isValidMove(board.getBoard(), 0, 2, 1, 1)); // Diagonal move

        // Test invalid moves for the bishop
        assertFalse(bishop.isValidMove(board.getBoard(), 0, 2, 1, 2)); // Horizontal move
        assertFalse(bishop.isValidMove(board.getBoard(), 2, 1, 2, 2)); // Vertical move
    }

    @Test
    public void testQueenMovement() {
        Board board = game.getGameBoard();

        // Place a queen at a specific position
        Queen queen = new Queen("white", 'A', 3); // Assuming 'A' is a valid row value
        board.getBoard()[0][3] = queen;

        // Test valid moves for the queen
        assertTrue(queen.isValidMove(board.getBoard(), 0, 3, 2, 3)); // Vertical move
        assertTrue(queen.isValidMove(board.getBoard(), 0, 3, 0, 6)); // Horizontal move
        assertTrue(queen.isValidMove(board.getBoard(), 0, 3, 1, 4)); // Diagonal move

        // Test invalid moves for the queen
        assertFalse(queen.isValidMove(board.getBoard(), 0, 3, 3, 4)); // Invalid move
    }


    @Test
    public void testKingMovement() {
        Board board = game.getGameBoard();

        // Place a king at a specific position
        King king = new King("white", (char) 0, 4);
        board.getBoard()[0][4] = king;

        // Test valid moves for the king
        assertTrue(king.isValidMove(board.getBoard(), 0, 4, 1, 4)); // Move one square forward
        assertTrue(king.isValidMove(board.getBoard(), 0, 4, 0, 3)); // Move one square left

        // Test invalid moves for the king
        assertFalse(king.isValidMove(board.getBoard(), 0, 4, 2, 4)); // Move two squares forward
        assertFalse(king.isValidMove(board.getBoard(), 0, 4, 0, 6)); // Move two squares right
    }

    @Test
    public void testPawnCannotJumpOver() {
        Board board = game.getGameBoard();

        // Place pawns at specific positions
        Pawn pawn1 = new Pawn("white", 1, 0);
        Pawn pawn2 = new Pawn("black", 2, 0);
        board.getBoard()[1][0] = pawn1;
        board.getBoard()[2][0] = pawn2;

        // Attempt to move the first pawn over the second pawn
        assertFalse(pawn1.isValidMove(board.getBoard(), 1, 0, 3, 0)); // Should not be able to jump over the second pawn
    }

    @Test
    public void testRookCannotJumpOver() {
        Board board = game.getGameBoard();

        // Place rooks at specific positions
        Rook rook1 = new Rook("white", 1, 0);
        Pawn pawn = new Pawn("black", 2, 0);
        board.getBoard()[1][0] = rook1;
        board.getBoard()[2][0] = pawn;

        // Attempt to move the rook over the pawn
        assertFalse(rook1.isValidMove(board.getBoard(), 1, 0, 3, 0)); // Should not be able to jump over the pawn
    }

    @Test
    public void testBishopCannotJumpOver() {
        Board board = game.getGameBoard();

        // Place bishops at specific positions
        Bishop bishop1 = new Bishop("white", (char) 1, 1);
        Pawn pawn = new Pawn("black", 2, 0);
        board.getBoard()[1][1] = bishop1;
        board.getBoard()[2][2] = pawn;
        // Attempt to move the bishop over the pawn
        assertFalse(bishop1.isValidMove(board.getBoard(), 1, 1, 3, 3)); // Should not be able to jump over the pawn
    }

    @Test
    public void testQueenCannotJumpOver() {
        Board board = game.getGameBoard();

        // Place queens at specific positions
        Queen queen1 = new Queen("white", (char) 1, 2);
        Pawn pawn = new Pawn("white", 2, 2);
        board.getBoard()[1][2] = queen1;
        board.getBoard()[2][0] = pawn;

        // Attempt to move the queen over the pawn
        assertFalse(queen1.isValidMove(board.getBoard(), 1, 2, 3, 2)); // Should not be able to jump over the pawn
    }

    @Test
    public void testKingCannotJumpOver() {
        Board board = game.getGameBoard();

        // Place kings at specific positions
        King king1 = new King("white", (char) 0, 4);
        Pawn pawn = new Pawn("black", 2, 0);
        board.getBoard()[0][4] = king1;
        board.getBoard()[2][0] = pawn;

        // Attempt to move the king over the pawn
        assertFalse(king1.isValidMove(board.getBoard(), 0, 4, 2, 4)); // Should not be able to jump over the pawn
    }

    @Test
    public void testCannotMoveEmptySpace() {
        Board board = game.getGameBoard();

        // Attempt to move from an empty space
        assertFalse(board.getPiece(2, 0).isValidMove(board.getBoard(), 2, 0, 3, 0)); // Should not be able to move from an empty space
    }
}