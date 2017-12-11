package game;

import game.Entities.Entity;
import game.Systems.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.System;
import javax.swing.*;

import static game.Controller.getController;
import static game.Systems.EntityManager.getEntityManager;
import static game.Systems.Console.getConsole;

/**
 * Created by Daniel on 11/7/2017.
 */
public class Game extends JFrame
{

    private boolean isRunning;
    private int fps;

    public static final int windowWidth = 600;
    public static final int windowHeight = 400;

    int rotation = 0;


    public BufferedImage backBuffer;
    private Input input;
    private Controller controller;
    private Console console;
    private EntityManager entityManager;
    private Render render;


    public static void main(String[] a)
    {
        Game g = new Game();
        g.run();
        java.lang.System.exit(0);

    }

    public void run()
    {

        initialize();

        long time;

        while (isRunning)
        {
            time = java.lang.System.currentTimeMillis();
            update();
            draw();
            time = (1000 / fps) - (java.lang.System.currentTimeMillis() - time);


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
        //game state variables, initialize input handler
        isRunning = true;
        fps = 60;
        input = new Input(this);

        //Initialize controller and console
        controller = getController();
        console = getConsole();

        //Initialize entity manager
        entityManager = getEntityManager();
        render = new Render(windowWidth, windowHeight);

        entityManager.add(new Entity(100, 100, 10, 10));



        //set up window
        setTitle("Anders Game");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        setVisible(true);



    }

    void update()
    {
        controller.update();
    }



    //Should this method be an interface to a drawing system?
    void draw()
    {
        Graphics g = getGraphics();
        backBuffer = render.render();
        g.drawImage(backBuffer, 0, 0, this);

    }


    ///////////////MOVE TO A PHYSICS SYSTEM///////////
    /*
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
    */

}
