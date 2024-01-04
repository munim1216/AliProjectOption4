import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class UI implements ActionListener {
    private final JFrame WINDOW;
    private JButton startGame;
    private JButton closeGame;
    private JPanel buttonPanel;
    private JPanel spritePanel;
    private JPanel startPanel;
    public UI () {
        WINDOW = new JFrame();
        WINDOW.setSize(900, 800);
        WINDOW.setResizable(false);
        WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        spritePanel = new JPanel();
        startPanel = new JPanel();

        startGame = new JButton();
        formatButton(startGame);
        closeGame = new JButton();
        formatButton(closeGame);

        startPanel.setLayout(new GridLayout(1, 2));
        startPanel.add(startGame);
        startPanel.add(closeGame);
        WINDOW.add(startPanel);
        startPanel.setVisible(true);
        WINDOW.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = (Object) ae;
        JButton button;
        try {
            button = (JButton) obj;
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }

        String buttonText = button.getText();
        switch (buttonText) {
            case "startGame" -> newGame();
            case "closeGame" -> endGame();
            default -> throw new RuntimeException("Error");
        }
    }

    public void newGame() {
        throw new UnsupportedOperationException();
    }
    public void endGame() {
        throw new UnsupportedOperationException();
    }

    private void formatButton(JButton button) {
        button.setSize(225,150);
        button.addActionListener(this);
    }
}
