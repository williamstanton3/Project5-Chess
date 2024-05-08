import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class scratch {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Create players
        System.out.print("Enter name of Player 1: ");
        Player p1 = new Player(scanner.next(), "white");
        System.out.print("Enter name of Player 2: ");
        Player p2 = new Player(scanner.next(), "black");

        // Initialize the game
        Game game = new Game(p1, p2);

        System.out.println();
        System.out.println(p1.getName() + ", you are white. " + p2.getName() + ", you are black.");
        System.out.println("BEGIN! " + p1.getName() + " vs. " + p2.getName());

        // Run the game loop until someone wins
        while (true) {
            // Player 1's move
            Map<String, Integer> move1 = generateRandomMove();
            game.gameBoard.play(p1, move1.get("startRow"), move1.get("startCol"), move1.get("endRow"), move1.get("endCol"));
            game.gameBoard.print();

            // Player 2's move
            Map<String, Integer> move2 = generateRandomMove();
            game.gameBoard.play(p2, move2.get("startRow"), move2.get("startCol"), move2.get("endRow"), move2.get("endCol"));
            game.gameBoard.print();
        }
    }

    // Helper method to generate a random move
    private static Map<String, Integer> generateRandomMove() {
        Map<String, Integer> move = new HashMap<>();
        Random rand = new Random();
        move.put("startRow", rand.nextInt(8));
        move.put("startCol", rand.nextInt(8));
        move.put("endRow", rand.nextInt(8));
        move.put("endCol", rand.nextInt(8));
        return move;
    }



    //import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ChessTester {
//
//    @Test
//    public void testBoardInitialization() {
//        Board board = new Board();
//        // Test board initialization
//        // Add assertions to validate the initial state of the board
//        Assertions.assertNotNull(board);
//        // Assert the initial positions of specific pieces
//        Assertions.assertTrue(board.getPiece(0, 0) instanceof Rook);
//        Assertions.assertEquals('A', board.getPiece(0, 0).getRow());
//        Assertions.assertEquals(0, board.getPiece(0, 0).getCol());
//        // Add more assertions to validate the positions of other pieces
//    }
//
//    @Test
//    public void testPawnMovement() {
//        Board board = new Board();
//        // Test pawn movement
//        // Add assertions to validate pawn movements
//        // For example:
////        Assertions.assertTrue(board.getPiece(1, 0).isValidMove(board, 1, 0, 2, 0));
////        Assertions.assertFalse(board.getPiece(1, 0).isValidMove(board, 1, 0, 3, 0)); // Invalid double move
//        // Add more assertions to cover various pawn movement scenarios
//    }
//
//    @Test
//    public void testRookMovement() {
//        Board board = new Board();
//        // Test rook movement
//        // Add assertions to validate rook movements
//        // For example:
////        Assertions.assertTrue(board.getPiece(0, 0).isValidMove(board, 0, 0, 0, 3)); // Horizontal move
////        Assertions.assertTrue(board.getPiece(0, 0).isValidMove(board, 0, 0, 3, 0)); // Vertical move
//        // Add more assertions to cover various rook movement scenarios
//    }
//
//    // Add similar test methods for Knight, Bishop, Queen, and King movements
//
//    @Test
//    public void testCheckDetection() {
//        Board board = new Board();
//        // Test check detection
//        // Add assertions to validate check detection
//        // For example:
//        // Simulate a situation where one player's king is under attack
//        board.movePiece(6, 4, 4, 4); // Move a pawn to open up space for the queen to attack
//        //Assertions.assertTrue(board.getPiece(0, 3).isValidMove(board, 0, 3, 3, 3)); // Move queen to check the king
//        Assertions.assertTrue(board.hasWon("black")); // Black king should be in check
//        // Add more assertions to cover various check detection scenarios
//    }
//
//    @Test
//    public void testGameFlow() {
//        // Create two players
//        Player player1 = new Player("Player1", "white");
//        Player player2 = new Player("Player2", "black");
//
//        // Create a new game with the two players
//        Game game = new Game(player1, player2);
//
//        // Simulate a game by making moves
//        // Continue until the game ends (checkmate, stalemate, or draw)
//        // Add assertions to validate game flow
//        Assertions.assertDoesNotThrow(() -> game.gameLoop());
//    }
//
//
//    @Test
//    public void testKnightIsValidMove() {
//        Piece knight = new Knight("white", 'A', 1); // Create a white knight at A1
//        // Test valid moves for the knight
//        Assertions.assertTrue(knight.isValidMove(null, 0, 0, 2, 1)); // Should be true
//        Assertions.assertTrue(knight.isValidMove(null, 0, 0, 1, 2)); // Should be true
//        Assertions.assertFalse(knight.isValidMove(null, 0, 0, 3, 2)); // Should be false (invalid move)
//    }
//
//
//    @Test
//    public void testBishopIsValidMove() {
//        Piece bishop = new Bishop("black", 'A', 2); // Create a black bishop at C3
//        // Test valid moves for the bishop
//        Assertions.assertTrue(bishop.isValidMove(null, 2, 2, 0, 0)); // Should be true
//        Assertions.assertTrue(bishop.isValidMove(null, 2, 2, 5, 5)); // Should be true
//        Assertions.assertFalse(bishop.isValidMove(null, 2, 2, 4, 3)); // Should be false (invalid move)
//    }
//
//    @Test
//    public void testPawnIsValidMove() {
//        Piece pawn = new Pawn("white", 'E', 2); // Create a white pawn at E2
//        // Test valid moves for the pawn
//        Assertions.assertTrue(pawn.isValidMove(null, 4, 3, 5, 3)); // Should be true
//        Assertions.assertFalse(pawn.isValidMove(null, 4, 3, 6, 3)); // Should be false (invalid move)
//    }
//
//    @Test
//    public void testKingIsValidMove() {
//        Piece king = new King("black", 'D', 5); // Create a black king at D5
//        // Test valid moves for the king
//        Assertions.assertTrue(king.isValidMove(null, 3, 4, 4, 5)); // Should be true
//        Assertions.assertFalse(king.isValidMove(null, 3, 4, 5, 6)); // Should be false (invalid move)
//    }
//
//    @Test
//    public void testRookIsValidMove() {
//        Piece rook = new Rook("white", 0, 7); // Create a white rook at H1
//        // Test valid moves for the rook
//        Assertions.assertTrue(rook.isValidMove(null, 7, 7, 7, 0)); // Should be true
//        Assertions.assertFalse(rook.isValidMove(null, 7, 7, 5, 6)); // Should be false (invalid move)
//    }
//
//    @Test
//    public void testMultipleMoves() {
//        Piece knight = new Knight("white", 'C', 3); // Create a white knight at C3
//        // Test multiple valid moves for the knight
//        Assertions.assertTrue(knight.isValidMove(null, 2, 2, 0, 1)); // Should be true
//        Assertions.assertTrue(knight.isValidMove(null, 2, 2, 4, 1)); // Should be true
//    }
//
//    @Test
//    public void testBoundaryCases() {
//        Piece bishop = new Bishop("black", 'A', 1); // Create a black bishop at A1
//        // Test boundary cases for the bishop
//        Assertions.assertTrue(bishop.isValidMove(null, 0, 0, 7, 7)); // Should be true (diagonal to opposite corner)
//        Assertions.assertFalse(bishop.isValidMove(null, 0, 0, 0, 2)); // Should be false (horizontal move)
//        Assertions.assertFalse(bishop.isValidMove(null, 0, 0, 2, 0)); // Should be false (vertical move)
//    }
//
//    @Test
//    public void testInvalidMoves() {
//        Piece pawn = new Pawn("white", 'D', 4); // Create a white pawn at D4
//        // Test invalid moves for the pawn
//    }
//}
}


