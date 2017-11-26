package game.Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
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
    private ImageObserver imageObserver;

    private Player(int x, int y)
    {
        super(x, y, 19, 29);

        try
        {
            String workingDir = java.lang.System.getProperty("user.dir");
            sprite = ImageIO.read(new File(workingDir + "\\Game0.0.1\\src\\game\\player_sprite.jpg"));
            imageObserver = new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            };
        } catch (IOException e)
        {
            String workingDir = java.lang.System.getProperty("user.dir");
            java.lang.System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
        this.width = sprite.getWidth(imageObserver);
        this.height = sprite.getHeight(imageObserver);

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
        if (java.lang.System.currentTimeMillis() - lastAction > cooldown)
        {
            shoot();
            lastAction = java.lang.System.currentTimeMillis();
        }
    }

    public void shoot()
    {
        Bullet b = new Bullet(this.x, this.y);
        b.setOrientation(this.orientation);
    }

}
