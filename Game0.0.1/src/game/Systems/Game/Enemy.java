package game.Systems.Game;

import game.Systems.Entities.Entity;

/**
 * Created by Daniel on 11/18/2017.
 */
public class Enemy extends Entity
{

    private long count = 0;

    public Enemy(int x, int y)
    {
        super(x, y, 30,30);
    }

    //TODO Make enemies do things

    @Override
    public void action()
    {
        if (count % 500 < 250)
            moveDown(1);
        else
            moveUp(1);
        count++;
    }
}
