package main;
public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private final int FPS_SET = 120;
    Thread gameThread;

    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();
    }

    void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1_000_000_000.0 / FPS_SET;
        long lastTime = System.nanoTime();
        long now = System.nanoTime();

        while (true){
            now = System.nanoTime();
            if(now - lastTime >= timePerFrame){
                gamePanel.repaint();
                lastTime = System.nanoTime();
                //System.out.println("time per frame: " + timePerFrame);
            }
        }

    }
}
