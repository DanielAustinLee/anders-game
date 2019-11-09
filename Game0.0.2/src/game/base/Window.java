package game.base;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    private static int windowWidth = 600;
    private static int windowHeight = 400;

    private boolean isRunning;

    protected static Window mainWindow;

    private BufferedImage backBuffer;
    private Graphics gfxObject = getGraphics();

    public static void main(String[] args)
    {
        Window mainWindow = new Window();
        mainWindow.run();
        java.lang.System.exit(0);
    }

    protected void run()
    {
        initialize();
        while (isRunning)
        {

        }
    }

    private void initialize()
    {
        //Set window settings
        setTitle("Anders Game");
        setSize(windowWidth, windowHeight);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Initialize back buffer
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
    }

    public void draw(BufferedImage biNextImage)
    {
        gfxObject.drawImage(backBuffer, 0, 0, this);
        backBuffer  = biNextImage;
    }

    public void terminate()
    {
        isRunning = false;
    }
}
