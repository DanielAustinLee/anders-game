package game.Systems;

import game.Entities.*;
import game.Messaging.EntityMessage;
import game.Messaging.InputMessage;
import game.Messaging.Message;

import java.util.ArrayList;

public class EntityManager extends System {

    private static EntityManager instance;
    private static ArrayList<Entity> entityPool;

    private static Player player = Player.getPlayer();

    private EntityManager()
    {
        entityPool = new ArrayList<>(256);
    }

    @Override
    public boolean canHandle(Message msg) {
        return (msg instanceof EntityMessage);
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg instanceof InputMessage) {
            char key = ((InputMessage) msg).keyPressed;
            player.action(key);
        }

        for (Entity e: entityPool){
            getController().postMessage(new EntityMessage(e.getId(), e.getX(), e.getY()));
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


}
