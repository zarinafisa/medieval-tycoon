package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Player;
import model.Player.PlayerMovement;

public class GamePanel extends JPanel {
    private final PlayerMovement playerMovement = new Player().createMovement();
    private final Timer timer;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        // forward key events to movement controller
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                playerMovement.keyPressed(e.getKeyCode());
            }
            @Override public void keyReleased(KeyEvent e) {
                playerMovement.keyReleased(e.getKeyCode());
            }
        });

        int delay = 1000 / 60;
        timer = new Timer(delay, e -> {
            playerMovement.update();
            repaint();
        });
        timer.start();
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(
            playerMovement.getCurrentFrame(),
            playerMovement.getX(),
            playerMovement.getY(),
            this
        );
    }
}
