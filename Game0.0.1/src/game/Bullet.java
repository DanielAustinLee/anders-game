package game;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Bullet extends Entity {

    static ArrayList<Bullet> bullets = new ArrayList<>(15);

    public Bullet(int x, int y)
    {
        super(x + 5, y + 5, 5, 5);
        bullets.add(this);
    }

    @Override
    public void action()
    {
        this.moveForward(3);
    }
}
