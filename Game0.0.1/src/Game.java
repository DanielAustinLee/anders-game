
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;


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

        if (keyInput.isKeyDown(KeyEvent.VK_SPACE)) {p.shoot();}

        for (Entity e : Entity.entities)
        {
            if (e != p)
            {
                e.action();
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
        for (Entity e : Entity.entities)
        {
            if (e instanceof Bullet)
                bbg.drawOval(e.x, e.y, 10, 10);
        }

        g.drawImage(backBuffer, 0, 0, this);

    }


}
