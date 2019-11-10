package game.base;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    private static int windowWidth = 600;
    private static int windowHeight = 400;

    private static boolean running;

    protected static Window mainWindow;

    private Window()
    {
        initialize();
        //run();
    }

/*    protected void run()
    {
        while (running)
        {

        }
    }*/

    private void initialize()
    {
        //Set window settings
        setTitle("Anders Game");
        setSize(windowWidth, windowHeight);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        running = true;

    }



    public void terminate()
    {
        running = false;
        setVisible(false);
    }

    protected static Window getWindow()
    {
        if (mainWindow == null)
        {
            mainWindow = new Window();
        }
        return mainWindow;
    }

    protected static boolean isRunning()
    {
        return running;
    }
}
