public class scratch {

    public static void main(String[] args) {
        // Initialize the chess board
        char[][] board = {
                {'♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'},
                {'♟', '♟', '♟', '♟', '♟', '♟', '♟', '♟'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'♙', '♙', '♙', '♙', '♙', '♙', '♙', '♙'},
                {'♖', '♘', '♗', '♕', '♔', '♗', '♘', '♖'}
        };

        // Print the chess board
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
