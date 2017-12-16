package game.Systems.Game;

import game.Systems.Entities.Entity;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Bullet extends Entity {

    //public static CopyOnWriteArrayList<Bullet> bulletPool = new CopyOnWriteArrayList<>(new ArrayList<Bullet>(64));

    public Bullet(int x, int y)
    {
        super(x , y, 5, 5);
    }



    @Override
    public void action()
    {
        this.moveForward(5);
    }
}
