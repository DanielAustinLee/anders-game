package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;


/**
 * Created by Daniel on 11/18/2017.
 */
public class Player extends Entity {

    static Player player = null;

    private static long cooldown = 500;
    private static long lastAction;
    public Image sprite;

    private Player(int x, int y)
    {
        super(x, y, 32, 32);

        try
        {
            String workingDir = System.getProperty("user.dir");
            sprite = ImageIO.read(new File(workingDir + "\\Game0.0.1\\src\\game\\player_sprite.jpg"));
        } catch (IOException e)
        {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }

    }

    public static Player getPlayer()
    {
        if (player == null)
        {
            player = new Player(200, 300);

        }
        return player;
    }

    @Override
    public void action()
    {
        if (System.currentTimeMillis() - lastAction > cooldown)
        {
            shoot();
            lastAction = System.currentTimeMillis();
        }
    }

    public void shoot()
    {
        Bullet b = new Bullet(this.x, this.y);
        b.setOrientation(this.orientation);
    }

}
