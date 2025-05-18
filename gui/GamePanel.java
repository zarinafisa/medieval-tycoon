package gui;

import camera.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import model.Player.*;
import model.Player.PlayerMovement;
import model.Player.PlayerSkin;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable {
    private Player player = new Player("tauwus");
    private PlayerMovement playerMovement;
    private PlayerSkin PlayerSkin;
    private Thread gameThread;
    private int FPS = 60;
    private TileManager tileManager;
    private Camera camera;
    
      public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        playerMovement = player.createMovement();
        PlayerSkin = player.createNametag();
        tileManager = new TileManager(this);
        camera = new Camera(this, tileManager);

        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                playerMovement.keyPressed(e.getKeyCode());
            }
            @Override public void keyReleased(KeyEvent e) {
                playerMovement.keyReleased(e.getKeyCode());
            }
        });
        
        // no stuck keys
        addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                playerMovement.resetKeys();
            }
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();
        gameThread = new Thread(this);
        gameThread.start();
    }    
    @Override
    public void run() {
        final double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while (gameThread != null) {
            playerMovement.update();
            repaint();
            
            try {
                double remaining = nextDrawTime - System.nanoTime();
                long sleepMs = Math.max(0, (long)(remaining / 1_000_000));
                
                if (sleepMs > 0) {
                    Thread.sleep(sleepMs);
                }
                
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                System.out.println("Game thread was interrupted: " + ex.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
    }    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        camera.update(playerMovement, tileManager, this);
        tileManager.draw(g2d, camera.getX(), camera.getY());
        PlayerSkin.render(g, playerMovement.getX() - camera.getX(), playerMovement.getY() - camera.getY(), playerMovement.getCurrentFrame());
    }

    
    public Player getPlayer() {
        return player;
    }
    public TileManager getTileManager() {
        return tileManager;
    }
}
