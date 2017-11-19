package game;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/18/2017.
 */
public class Enemy extends Entity
{
    static ArrayList<Enemy> enemies = new ArrayList<>(5);

    private boolean patrollingNorth = false;
    private boolean patrollingSouth = true;

    public Enemy(int x, int y)
    {
        super(x, y, 30,30);
        enemies.add(this);
    }

    //TODO Make enemies do things

    @Override
    public void action()
    {
        moveDown(1);
    }
}