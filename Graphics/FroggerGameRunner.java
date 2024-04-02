package Graphics;

import javax.swing.*;
import java.awt.*;

public class FroggerGameRunner extends JPanel {

    private FroggerGameGraphics chickenGame;
    private static final Point START_POSITION = new Point(300,500);

    public static void main(String[] args) throws InterruptedException {

        JFrame gameFrame = new JFrame("The Frogger Game");
        FroggerGameGraphics runner = new FroggerGameGraphics();
        gameFrame.add(runner);
        gameFrame.setSize(600,600);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.graphicsGameLoop(gameFrame);

    }

}
