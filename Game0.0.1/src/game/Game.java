package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

import static game.Entity.entities;
import static game.Player.player;

/**
 * Created by Daniel on 11/7/2017.
 */
public class Game extends JFrame
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
        Game g = new Game();
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


        p = Player.getPlayer();

        setTitle("Test");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        setVisible(true);

    }

    void update()
    {
        if (keyInput.isKeyDown(KeyEvent.VK_D)) {p.moveRight(1);}
        if (keyInput.isKeyDown(KeyEvent.VK_A)) {p.moveLeft(1);}
        if (keyInput.isKeyDown(KeyEvent.VK_S)) {p.moveDown(1);}
        if (keyInput.isKeyDown(KeyEvent.VK_W)) {p.moveUp(1);}

        if (keyInput.isKeyDown(KeyEvent.VK_LEFT)) {p.orientation += 0.12;}
        if (keyInput.isKeyDown(KeyEvent.VK_RIGHT)) {p.orientation -= 0.12;}

        if (keyInput.isKeyDown(KeyEvent.VK_SPACE)) {p.action();}

        Entity e;

        for (int i = 0; i < entities.size(); i++)
        {

            e = entities.get(i);

            if (e != p)
            {
                e.action();
            }
            if (Math.sqrt(Math.pow(e.x - p.x, 2) + Math.pow(e.y - p.y, 2)) > 300)
            {
                entities.remove(e);
            }
        }



    }

    void draw()
    {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);

        bbg.drawOval(Player.getPlayer().x, Player.getPlayer().y, 20, 20);
        bbg.drawLine(Player.getPlayer().x + 10, Player.getPlayer().y + 10, (int)(Player.getPlayer().x + 10 + 10 * sin(Player.getPlayer().orientation)), (int)(Player.getPlayer().y + 10 + 10 * cos(Player.getPlayer().orientation)) );
        for (Entity e : entities)
        {
            if (e instanceof Bullet)
                bbg.drawOval(e.x, e.y, 10, 10);
        }

        g.drawImage(backBuffer, 0, 0, this);

    }


}
