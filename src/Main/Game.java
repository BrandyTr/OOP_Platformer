package Main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override //GAME LOOP
    public void run() {
        double timePerFrame = 1000000000 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime(); //present time

        int frames = 0;
        long lastCheck = System.currentTimeMillis();


        while (true) {

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {

                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }
            //frames increment by 1 => repaint 1 frame until satisfy if condition
            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

    }
}
