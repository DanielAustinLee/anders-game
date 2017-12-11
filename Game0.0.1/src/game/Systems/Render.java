package game.Systems;


import game.Entities.Entity;
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
        if (msg instanceof DrawMessage){
            render();
        }
    }

    public BufferedImage render()
    {
        //TODO figure out how to center camera on player
        //create a camera class, draw all objects on screen?
        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.GREEN);
        bbg.fillRect(0, 0, windowWidth, windowHeight);


        bbg.setColor(Color.BLACK);
        //Should probably be an ITERATOR
        for (Entity e : EntityManager.entityPool){

            bbg.drawOval(e.getX(),e.getY(),e.getWidth(),e.getHeight());
        }

        return backBuffer;
    }
}
