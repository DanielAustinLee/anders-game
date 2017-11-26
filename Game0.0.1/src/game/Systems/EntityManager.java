package game.Entities;

import java.util.ArrayList;

public class EntityManager {

    private static EntityManager instance;
    private static ArrayList<Entity> entityPool;

    private EntityManager()
    {
        entityPool = new ArrayList<>(256);
    }

    public static EntityManager getEntityManager()
    {
        if (instance == null)
        {
            instance = new EntityManager();
        }

        return instance;
    }

    void add(Entity e)
    {
        entityPool.add(e);
    }


}
