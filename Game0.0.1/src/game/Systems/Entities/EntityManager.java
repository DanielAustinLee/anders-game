package game.Systems.Entities;

import game.Systems.Messaging.EntityMessage;
import game.Systems.Messaging.InputMessage;
import game.Systems.Messaging.Message;
import game.Systems.System;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager extends System {

    private static EntityManager instance = null;
    public static ArrayList<Entity> entityPool;

    public static Player player = Player.getPlayer();
    private EntityManager()
    {
        entityPool = new ArrayList<>(256);

    }

    @Override
    public boolean canHandle(Message msg) {

        return (msg instanceof InputMessage);
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg instanceof InputMessage) {
            player.action((InputMessage) msg);
        }

    }

    public static EntityManager getEntityManager()
    {
        if (instance == null)
        {
            instance = new EntityManager();
        }

        return instance;
    }

    public void add(Entity e)
    {
        entityPool.add(e);
        getController().postMessage(new EntityMessage(e.getId(), e.getX(), e.getY()));
    }

    public void update()
    {
        Iterator<Entity> iterator = entityPool.iterator();
        while (iterator.hasNext())
        {
            Entity e = iterator.next();
            e.action();

            if (!e.equals(player) && player.checkCollision(e))
                java.lang.System.out.println("COLLISION");
        }
    }

    public void remove(Entity e)
    {
        entityPool.remove(e);
    }


}
