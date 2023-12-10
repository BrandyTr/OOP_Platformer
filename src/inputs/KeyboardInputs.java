package inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                gamePanel.changYDelta(-5);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.changYDelta(+5);
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.changXDelta(-5);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.changXDelta(+5);
                break;
        }
    }
}
