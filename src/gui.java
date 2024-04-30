import javax.swing.*;
import java.awt.*;


class gui{
    private static void createAndShowChessBoard() {
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel chessBoardPanel = new JPanel(new GridLayout(8, 8));
        boolean isWhite = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(new Dimension(60, 60));
                cell.setBackground(isWhite ? Color.WHITE : Color.GRAY);
                isWhite = !isWhite;
                chessBoardPanel.add(cell);
            }
            isWhite = !isWhite;
        }

        frame.add(chessBoardPanel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My First GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);

            JButton button1 = new JButton("Press to Start");
            button1.addActionListener(e -> createAndShowChessBoard());

            frame.getContentPane().add(button1);
            frame.setVisible(true);
        });
    }
}