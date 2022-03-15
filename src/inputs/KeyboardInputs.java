package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int e = keyEvent.getKeyCode();
        if(e == KeyEvent.VK_UP) gamePanel.y -= 5;
        if(e == KeyEvent.VK_DOWN) gamePanel.y += 5;
        if(e == KeyEvent.VK_LEFT) gamePanel.x -= 5;
        if(e == KeyEvent.VK_RIGHT) gamePanel.x += 5;
    }

    public void keyTyped(KeyEvent keyEvent) {}
    public void keyReleased(KeyEvent keyEvent) {}

}
