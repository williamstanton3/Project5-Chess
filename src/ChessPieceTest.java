import org.junit.Test;
import static org.junit.Assert.*;

public class ChessPieceTest {

    @Test
    public void testKnightIsValidMove() {
        Piece knight = new Knight("white", 'A', 1); // Create a white knight at A1
        // Test valid moves for the knight
        assertTrue(knight.isValidMove(null, 0, 0, 2, 1)); // Should be true
        assertTrue(knight.isValidMove(null, 0, 0, 1, 2)); // Should be true
        assertTrue(knight.isValidMove(null, 0, 0, 3, 2)); // Should be false (invalid move)
    }

    @Test
    public void testBishopIsValidMove() {
        Piece bishop = new Bishop("black", 'C', 3); // Create a black bishop at C3
        // Test valid moves for the bishop
        assertTrue(bishop.isValidMove(null, 2, 2, 0, 0)); // Should be true
        assertTrue(bishop.isValidMove(null, 2, 2, 5, 5)); // Should be true
        assertFalse(bishop.isValidMove(null, 2, 2, 4, 3)); // Should be false (invalid move)
    }

    @Test
    public void testPawnIsValidMove() {
        Piece pawn = new Pawn("white", 'E', 2); // Create a white pawn at E2
        // Test valid moves for the pawn
        assertTrue(pawn.isValidMove(null, 4, 3, 5, 3)); // Should be true
        assertFalse(pawn.isValidMove(null, 4, 3, 6, 3)); // Should be false (invalid move)
    }

    @Test
    public void testKingIsValidMove() {
        Piece king = new King("black", 'D', 5); // Create a black king at D5
        // Test valid moves for the king
        assertTrue(king.isValidMove(null, 3, 4, 4, 5)); // Should be true
        assertFalse(king.isValidMove(null, 3, 4, 5, 6)); // Should be false (invalid move)
    }

    @Test
    public void testRookIsValidMove() {
        Piece rook = new Rook("white", 0, 7); // Create a white rook at H1
        // Test valid moves for the rook
        assertTrue(rook.isValidMove(null, 7, 7, 7, 0)); // Should be true
        assertFalse(rook.isValidMove(null, 7, 7, 5, 6)); // Should be false (invalid move)
    }

    @Test
    public void testMultipleMoves() {
        Piece knight = new Knight("white", 'C', 3); // Create a white knight at C3
        // Test multiple valid moves for the knight
        assertTrue(knight.isValidMove(null, 2, 2, 0, 1)); // Should be true
        assertTrue(knight.isValidMove(null, 2, 2, 4, 1)); // Should be true
    }

    @Test
    public void testBoundaryCases() {
        Piece bishop = new Bishop("black", 'A', 1); // Create a black bishop at A1
        // Test boundary cases for the bishop
        assertTrue(bishop.isValidMove(null, 0, 0, 7, 7)); // Should be true (diagonal to opposite corner)
        assertFalse(bishop.isValidMove(null, 0, 0, 0, 2)); // Should be false (horizontal move)
        assertFalse(bishop.isValidMove(null, 0, 0, 2, 0)); // Should be false (vertical move)
    }

    @Test
    public void testInvalidMoves() {
        Piece pawn = new Pawn("white", 'D', 4); // Create a white pawn at D4
        // Test invalid moves for the pawn
        assertFalse(pawn.isValidMove(null, 3, 4, 5, 4)); // Should be false (moving two squares forward)
        assertFalse(pawn.isValidMove(null, 3, 4, 4, 3)); // Should be false (diagonal move without capturing)
    }

    @Test
    public void testCapturingOpponentPiece() {
        Piece pawn = new Pawn("black", 'E', 5); // Create a black pawn at E5
        // Place an opponent piece at F4
        Piece opponentPiece = new Pawn("white", 'F', 4);
        // Test capturing opponent piece
        assertTrue(pawn.isValidMove(null, 4, 5, 5, 4)); // Should be true (capture opponent piece)
    }
}


