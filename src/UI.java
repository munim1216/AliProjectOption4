import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class UI implements ActionListener {
    private final JFrame WINDOW;
    private JButton startGame;
    private JButton closeGame;
    private JButton action1;
    private JButton action2;
    private JButton action3;
    private JButton action4;
    private JPanel buttonPanel;
    private JLayeredPane buttonLayer;
    private JPanel spritePanel;
    private JLayeredPane spriteLayer;

    public UI () {
        WINDOW = new JFrame();
        WINDOW.setSize(900, 800);
        WINDOW.setResizable(false);
        WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW.setLayout(new BorderLayout(0, 200));

        createButtonPanel();
        spritePanel = new JPanel();
        spriteLayer = new JLayeredPane();
        spritePanel.add(spriteLayer);
        
        
        startGame = new JButton();
        formatButton(startGame);
        startGame.setActionCommand("startGame");

        closeGame = new JButton();
        formatButton(closeGame);
        closeGame.setActionCommand("closeGame");

        spritePanel.setLayout(new GridLayout(1, 2,30,0));
        spriteLayer.add(startGame, 0);
        spriteLayer.add(closeGame, 1);

        WINDOW.add(spritePanel, BorderLayout.CENTER);
        WINDOW.add(spritePanel, BorderLayout.NORTH);
        WINDOW.add(buttonPanel, BorderLayout.SOUTH);

        spriteLayer.setVisible(true);
        spritePanel.setVisible(true);
        WINDOW.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        JButton button;
        try {
            button = (JButton) obj;
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }

        String buttonText = button.getActionCommand();
        System.out.println(buttonText);
        switch (buttonText) {
            case "startGame" -> newGame();
            case "closeGame" -> endGame();
            default -> throw new RuntimeException("Error :" + buttonText);
        }
    }

    public void newGame() {
        throw new UnsupportedOperationException();
    }
    public void endGame() {
        throw new UnsupportedOperationException();
    }

    private void formatButton(JButton button) {
        button.setPreferredSize(new Dimension(225,150));
        button.addActionListener(this);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());

        action1 = new JButton();
        formatButton(action1);
        action1.setActionCommand("action1");

        action2 = new JButton();
        formatButton(action2);
        action2.setActionCommand("action2");

        action3 = new JButton();
        formatButton(action3);
        action3.setActionCommand("action3");

        action4 = new JButton();
        formatButton(action4);
        action4.setActionCommand("action4");

        buttonPanel.add(action1);
        buttonPanel.add(action2);
        buttonPanel.add(action3);
        buttonPanel.add(action4);
    }
}
