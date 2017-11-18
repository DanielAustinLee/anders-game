
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by Daniel on 11/7/2017.
 */
public class GameTutorial extends JFrame
{

    private boolean isRunning;
    private int fps;

    private int windowWidth = 600;
    private int windowHeight = 400;

    int rotation = 0;


    BufferedImage backBuffer;
    KeyHandler keyInput;
    MouseHandler mouseInput;
    Player p;


    public static void main(String[] a)
    {
        GameTutorial g = new GameTutorial();
        g.run();
        System.exit(0);

    }

    public void run()
    {

        initialize();

        long time;

        while (isRunning)
        {
            time = System.currentTimeMillis();
            update();
            draw();
            time = (1000 / fps) - (System.currentTimeMillis() - time);


            if (time > 0)
            {
                try
                {
                    Thread.sleep(time);
                }
                catch (Exception e){}
            }

        }

        //sets visibility to false after run loop ends
        setVisible(false);


    }

    void initialize()
    {
        isRunning = true;
        fps = 60;

        keyInput = new KeyHandler(this);
        mouseInput = new MouseHandler(this);


        p = new Player(windowWidth/2, windowHeight/2);

        setTitle("Test");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        setVisible(true);

    }

    void update()
    {
        if (keyInput.isKeyDown(KeyEvent.VK_D)) {p.moveRight(5);}
        if (keyInput.isKeyDown(KeyEvent.VK_A)) {p.moveLeft(5);}
        if (keyInput.isKeyDown(KeyEvent.VK_S)) {p.moveDown(5);}
        if (keyInput.isKeyDown(KeyEvent.VK_W)) {p.moveUp(5);}



    }

    void draw()
    {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);
        bbg.drawOval(p.x, p.y, 20, 20);


        g.drawImage(backBuffer, 0, 0, this);

    }


}
