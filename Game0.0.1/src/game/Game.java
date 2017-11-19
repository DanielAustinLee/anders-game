package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import javax.swing.*;

import static game.Controller.getController;
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
        //game state variables, initialize input handlers
        isRunning = true;
        fps = 60;

        keyInput = new KeyHandler(this);
        mouseInput = new MouseHandler(this);

        //Initialize player and controller
        c = getController();

        p = Player.getPlayer();

        //set up window
        setTitle("Anders Game");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        setVisible(true);


        //make some enemies
        new Enemy(30, 30);
        new Enemy(100, 30);
        new Enemy(150, 30);
        new Enemy(200, 30);
        new Enemy(250, 30);


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



        player.setOrientation(Math.atan2(MouseInfo.getPointerInfo().getLocation().y - player.y, MouseInfo.getPointerInfo().getLocation().x - player.x ));


        for (Enemy e : enemies)
        {
            e.action();
        }

        updateProjectiles();
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

        bbg.drawImage(player.sprite, player.x1, player.y1, player.width, player.height, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

        bbg.drawLine(player.x1 + 10, player.y1 + 10, (int)(player.x1 + 10 + 10 * sin(player.orientation)), (int)(player.y1 + 10 + 10 * cos(player.orientation)) );

        //draw bullets
        for (Bullet b : bullets)
        {
            bbg.drawOval(b.x1, b.y1, 10, 10);
        }

        //draw enemies
        for (Enemy e : enemies)
        {
            bbg.drawOval(e.x1, e.y1, 30, 30);
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

                if (e.x1 <= b.x2 && e.x2 >= b.x1 && e.y1 <= b.y2 && e.y2 >= b.y1 )
                {
                    enemyIterator.remove();
                    bulletIterator.remove();
                }
            }

        }
    }

    void updateProjectiles()
    {

        Bullet b;

        for (int i = 0; i < bullets.size(); i++)
        {

            b = bullets.get(i);
            b.action();

            if (Math.sqrt(Math.pow(b.x1 - p.x1, 2) + Math.pow(b.y1 - p.y1, 2)) > 300)
            {
                bullets.remove(b);
            }
        }

    }

}
