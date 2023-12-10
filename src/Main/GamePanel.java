package Main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 1f;
    private float yDir = 1f;

    //FPS
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(47,59,150);
    private Random random;


    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    //Repaint by KEYBOARDS
    public void changXDelta(int value) {
        this.xDelta += value;
    }

    public void changYDelta(int value) {
        this.yDelta += value;
    }


    //Position of rectangle by MOUSE
    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    }

    private void updateRectangle() {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

    private Color getRndColor() {
        int r = random.nextInt(200); //random.nextInt(x): return int between 0 & x
        int g = random.nextInt(200);
        int b = random.nextInt(200);
        return new Color(r,b,g);
    }
}
