package game.Systems.Entities;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Bullet extends Entity {


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
