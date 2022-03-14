package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    int x=100,y=100;

    public GamePanel(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int e = keyEvent.getKeyCode();
                if(e == KeyEvent.VK_UP) y -= 5;
                if(e == KeyEvent.VK_DOWN) y += 5;
                if(e == KeyEvent.VK_LEFT) x -= 5;
                if(e == KeyEvent.VK_RIGHT) x += 5;

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }

        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(x,y,50,50);

        repaint();
    }
}
