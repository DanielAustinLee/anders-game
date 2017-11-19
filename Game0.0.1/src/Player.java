/**
 * Created by Daniel on 11/18/2017.
 */
public class Player extends Entity {

    public static Player player = null;

    private Player(int x, int y)
    {
        super(x, y);
    }

    public static Player getPlayer()
    {
        if (player == null)
        {
            player = new Player(200, 300);

        }
        return player;
    }

    public void shoot()
    {
        Bullet b = new Bullet(this.x, this.y);
        b.orientation = this.orientation;
    }

}
