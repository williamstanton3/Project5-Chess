import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class scratch extends JFrame {
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static final String COLS = "ABCDEFGH";

    public scratch() {
        initializeGUI();
    }

    private void initializeGUI() {
        // Set up the main GUI
        gui.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gui.add(chessBoard);

        // Initialize the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[j][i] = b;
            }
        }

        // Set up the chess board
        for (int i = 0; i < 8; i++) {
            chessBoard.add(new JLabel("" + (8 - i), SwingConstants.CENTER));
            for (int j = 0; j < 8; j++) {
                chessBoard.add(chessBoardSquares[j][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            chessBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }

        // Set up the main frame
        setContentPane(gui);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            scratch cg = new scratch();
            Player p1 = new Player("Bill", "white");
            Player p2 = new Player("Charlie", "black");
            Game g = new Game(p1, p2);
            g.gameLoop();
        });
    }
}
