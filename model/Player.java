package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Player {
    //for player attributes



    public class PlayerMovement {
        private int x = 100, y = 100;
        private final int speed = 5;
        private boolean up, down, left, right;
        private final Image[][] sprites = new Image[4][4];
        private int direction = 0, frameIndex = 0, animDelay = 5, animCount = 0;

        public PlayerMovement() {
            // load animation frames from /sprites/dir{dir}_{frame}.png
            for (int d = 0; d < sprites.length; d++) {
                for (int f = 0; f < sprites[d].length; f++) {
                    sprites[d][f] = new ImageIcon(
                        getClass().getResource("../sprites/dir" + d + "_" + f + ".png")
                    ).getImage();
                }
            }
        }

        public void update() {
            boolean moving = false;
            if (up)    { y -= speed; direction = 3; moving = true; }
            if (down)  { y += speed; direction = 0; moving = true; }
            if (left)  { x -= speed; direction = 1; moving = true; }
            if (right) { x += speed; direction = 2; moving = true; }

            if (moving) {
                animCount++;
                if (animCount >= animDelay) {
                    animCount = 0;
                    frameIndex = (frameIndex + 1) % sprites[direction].length;
                }
            } else {
                frameIndex = 0;
            }
        }

        public void keyPressed(int keyCode) {
            switch (keyCode) {
                case KeyEvent.VK_W: up = true; break;
                case KeyEvent.VK_S: down = true; break;
                case KeyEvent.VK_A: left = true; break;
                case KeyEvent.VK_D: right = true; break;
            }
        }

        public void keyReleased(int keyCode) {
            switch (keyCode) {
                case KeyEvent.VK_W: up = false; break;
                case KeyEvent.VK_S: down = false; break;
                case KeyEvent.VK_A: left = false; break;
                case KeyEvent.VK_D: right = false; break;
            }
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public Image getCurrentFrame() { return sprites[direction][frameIndex]; }
    }

    public PlayerMovement createMovement() {
        return new PlayerMovement();
    }
}