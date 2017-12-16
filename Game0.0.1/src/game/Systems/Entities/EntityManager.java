package game.Systems.Entities;

import game.Systems.Messaging.EntityMessage;
import game.Systems.Messaging.InputMessage;
import game.Systems.Messaging.Message;
import game.Systems.System;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager extends System {

    private static EntityManager instance = null;
    public static CopyOnWriteArrayList<Entity> entityPool;

    public static Player player = Player.getPlayer();
    private EntityManager()
    {
        entityPool = new CopyOnWriteArrayList(new ArrayList<Entity>(256));

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
        for (Entity e : entityPool)
        {
            e.action();
            if (!e.equals(player) && e.checkCollision(player))
            {
                entityPool.remove(e);
            }
        }
    }

    public void remove(Entity e)
    {

        for (Iterator<Entity> it = entityPool.iterator(); it.hasNext();)
        {
            Entity currentEntity = it.next();
            if (currentEntity.equals(e)){
                it.remove();
            }
        }
    }


}
