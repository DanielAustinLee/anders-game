package game;

import static game.Player.player;
/**
 * Created by Daniel on 11/14/2017.
 */
public class Controller
{

 //TODO Create this entire class
    public Controller()
    {}

    public void keyW()
    {
        player.moveUp(1);
    }

    public void keyA()
    {
        player.moveLeft(1);
    }

    public void keyS()
    {
        player.moveDown(1);
    }

    public void keyD()
    {
        player.moveRight(1);
    }

    public void keyLeft()
    {
        player.turn(0.10);
    }

    public void keyRight()
    {
        player.turn(-0.10);
    }

    public void keySpace()
    {
        player.action();
    }


}
