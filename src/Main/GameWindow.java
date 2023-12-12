package Main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
        jframe.addWindowFocusListener(new WindowFocusListener() { //Detect when lose focus
            @Override
            public void windowGainedFocus(WindowEvent e) {
                //System.out.println("Bye");
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });
    }
}
