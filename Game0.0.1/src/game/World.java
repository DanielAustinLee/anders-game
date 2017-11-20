package game;

/**
 * Created by Daniel on 11/19/2017.
 */
public class World
{
    public static Integer[][] worldMap = new Integer[3][3];

    public World()
    {
        initialize();
    }

    public static void initialize()
    {
        worldMap[0][0] = 0;
        worldMap[0][1] = 0;
        worldMap[0][2] = 0;
        worldMap[1][0] = 0;
        worldMap[1][2] = 0;
        worldMap[2][0] = 0;
        worldMap[2][1] = 0;
        worldMap[2][2] = 0;

        worldMap[1][1] = 1;

    }


}
