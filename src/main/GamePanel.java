package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {

    public double x=100,y=10;
    private double xDir=0.01, yDir=0.01;
    //private MouseInputs mouseInputs;
    private int frame = 0;
    private long lastCheck = 0;
    private Color color = new Color(100, 200, 100);
    private Random random;

    public GamePanel(){
        //mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        //addMouseListener(mouseInputs);
        //addMouseMotionListener(mouseInputs);
        random = new Random();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(color);

        updateRectangle();

        g.fillRect((int)x, (int)y,50,50);
        repaint();
        frame++;
        if(System.currentTimeMillis() - lastCheck > 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frame);
            frame = 0;
        }

    }

    void updateRectangle(){
        x += xDir;
        y += yDir;

        if(x>350 || x<0) {
            xDir *= -1;
            color = new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
        }
        if(y>350 || y<0) {
            yDir *= -1;
            color = new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
        }
    }

}


