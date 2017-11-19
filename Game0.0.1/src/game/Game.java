package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.swing.*;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

import static game.Bullet.bullets;
import static game.Player.player;
import static game.Enemy.enemies;

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
    Controller c;


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

        c = new Controller();

        p = Player.getPlayer();

        setTitle("Test");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        setVisible(true);

        new Enemy(30, 30);
        new Enemy(200, 300);

    }

    void update()
    {
        if (keyInput.isKeyDown(KeyEvent.VK_D)) {c.keyD();}
        if (keyInput.isKeyDown(KeyEvent.VK_A)) {c.keyA();}
        if (keyInput.isKeyDown(KeyEvent.VK_S)) {c.keyS();}
        if (keyInput.isKeyDown(KeyEvent.VK_W)) {c.keyW();}

        if (keyInput.isKeyDown(KeyEvent.VK_LEFT)) {c.keyLeft();}
        if (keyInput.isKeyDown(KeyEvent.VK_RIGHT)) {c.keyRight();}

        if (keyInput.isKeyDown(KeyEvent.VK_SPACE)) {c.keySpace();}

        Bullet b;

        //this should probably be somewhere else
        for (int i = 0; i < bullets.size(); i++)
        {

            b = bullets.get(i);
            b.action();

            if (Math.sqrt(Math.pow(b.x - p.x, 2) + Math.pow(b.y - p.y, 2)) > 300)
            {
                bullets.remove(b);
            }
        }

        checkCollisions();

    }

    void draw()
    {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);

        //figure out how to draw images

        bbg.drawOval(player.x, player.y, 20, 20);
        bbg.drawLine(player.x + 10, player.y + 10, (int)(player.x + 10 + 10 * sin(player.orientation)), (int)(player.y + 10 + 10 * cos(player.orientation)) );

        //draw bullets
        for (Bullet b : bullets)
        {
            bbg.drawOval(b.x, b.y, 10, 10);
        }

        //draw enemies
        for (Enemy e : enemies)
        {
            bbg.drawOval(e.x, e.y, 30, 30);
        }

        g.drawImage(backBuffer, 0, 0, this);

    }

    void checkCollisions()
    {



        for (Iterator<Enemy> enemyIterator = enemies.iterator(); enemyIterator.hasNext();)
        {
            Enemy e = enemyIterator.next();

            for ( Iterator<Bullet> bulletIterator = bullets.iterator(); bulletIterator.hasNext();)
            {
                Bullet b = bulletIterator.next();

                if (Math.sqrt(Math.pow(b.x - e.x, 2) + Math.pow(b.y - e.y, 2)) < 15)
                {
                    enemyIterator.remove();
                    bulletIterator.remove();
                }
            }

        }
    }

}
