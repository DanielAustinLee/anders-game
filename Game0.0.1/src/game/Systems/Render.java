package game.Systems;

import game.Entities.Entity;
import game.Game;
import game.Messaging.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.Game.windowHeight;
import static game.Game.windowWidth;

public class Render extends System  {

    private static BufferedImage backBuffer;

    public Render(int width, int height){
        super();
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public boolean canHandle(Message msg) {
        return msg instanceof DrawMessage;
    }

    @Override
    public void handleMessage(Message msg) {
    }

    public BufferedImage render()
    {
        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.GREEN);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);
        bbg.drawOval(EntityManager.player.getX(), EntityManager.player.getY(), 10, 10);
        //for (Entity e : EntityManager.entityPool)
        //{
        //    bbg.drawOval(e.getX(),e.getY(),10,10);
        //    java.lang.System.out.println(e.getX());
        //}

        return backBuffer;
    }
}
