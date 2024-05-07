import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ChessGUI extends JFrame {

    private final JPanel boardPanel;
    private final JButton[][] squares;
    private final Game game;

    public ChessGUI(Game game) {
        this.game = game;

        setTitle("Chess Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(8, 8));
        squares = new JButton[8][8];
        initializeBoard();
        getContentPane().add(boardPanel);

        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(70, 70));
                square.addActionListener(new SquareListener(i, j));
                boardPanel.add(square);
                squares[i][j] = square;
            }
        }
        updateBoard();
    }

    private void updateBoard() {
        Piece[][] pieces = game.getGameBoard().getBoard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = pieces[i][j];
                if (piece != null) {
                    squares[i][j].setIcon(new ImageIcon(getPieceImagePath(piece)));
                } else {
                    squares[i][j].setIcon(null);
                }
            }
        }
    }

    private String getPieceImagePath(Piece piece) {
        // Assuming you have images for each piece with file names like "white_king.png", "black_rook.png", etc.
        String color = piece.getColor().equals("white") ? "white" : "black";
        String name = piece.getClass().getSimpleName().toLowerCase();
        return "path_to_images_folder/" + color + "_" + name + ".png";
    }

    private class SquareListener implements ActionListener {
        private final int row;
        private final int col;

        public SquareListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Map<String, Integer> move = Map.of(
                        "startRow", game.getPlayerMove().get("startRow"),
                        "startCol", game.getPlayerMove().get("startCol"),
                        "endRow", row,
                        "endCol", col
                );
                game.getGameBoard().play(game.getCurrentPlayer(), move.get("startRow"), move.get("startCol"), move.get("endRow"), move.get("endCol"));
                updateBoard();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(ChessGUI.this, "Invalid move! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Player p1 = new Player("Player 1", "white");
        Player p2 = new Player("Player 2", "black");
        Game game = new Game(p1, p2);
        ChessGUI chessGUI = new ChessGUI(game);
    }
}


