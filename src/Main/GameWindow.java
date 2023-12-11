package Main;

import javax.swing.*;

public class GameWindow {
    private JFrame jframe;
    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();


        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null); //set location at center screen
        jframe.setResizable(false);
        jframe.pack(); //fit the size of Window to the preferred size of component
        jframe.setVisible(true);
    }
}
