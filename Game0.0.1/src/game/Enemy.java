package game;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/18/2017.
 */
public class Enemy extends Entity
{
    static ArrayList<Enemy> enemies = new ArrayList<>(5);

    public Enemy(int x, int y)
    {
        super(x, y);
        enemies.add(this);
    }
}
