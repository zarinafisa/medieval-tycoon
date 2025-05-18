package gui;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Medieval Tycoon - Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        CardLayout cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);
        // create game panel
        GamePanel gamePanel = new GamePanel();

        // build the menu card
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(Box.createVerticalGlue());

        JButton newGameButton = new JButton("Start");
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.addActionListener(e -> {
            e.getActionCommand(); // ensure event param is used
            cardLayout.show(getContentPane(), "GAME");
            gamePanel.requestFocusInWindow();
        });

        JButton loadGameButton = new JButton("Load Game");
        loadGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> {
            e.getActionCommand(); 
            System.exit(0);
        });

        menuPanel.add(newGameButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
        menuPanel.add(loadGameButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
        menuPanel.add(exitButton);
        menuPanel.add(Box.createVerticalGlue());

        getContentPane().add(menuPanel, "MENU");
        getContentPane().add(gamePanel, "GAME");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}