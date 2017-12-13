package game.Systems.Draw;


import game.Systems.Entities.Entity;
import game.Systems.Entities.EntityManager;
import game.Systems.Entities.Player;
import game.Systems.Messaging.*;
import game.Systems.System;

import java.awt.*;
import java.awt.image.BufferedImage;
import static game.Game.windowHeight;
import static game.Game.windowWidth;

public class Render extends System {

    public Camera cam;
    //Should this be a singleton like the other systems????
    //Or should the other systems be singletons at all???

    private static BufferedImage backBuffer;

    public Render(int width, int height){
        super();
        backBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        cam = new Camera(Player.getPlayer().getX(), Player.getPlayer().getY());
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
        Graphics bbg = backBuffer.getGraphics();

        cam.move(Player.getPlayer().getX(), Player.getPlayer().getY());

        //background
        bbg.setColor(Color.GREEN);
        bbg.fillRect(0, 0, windowWidth, windowHeight);


        bbg.setColor(Color.BLACK);


        //Should probably be an ITERATOR
        for (Entity e : EntityManager.entityPool) {

            if (cam.inFrame(e.getX(), e.getY(), windowWidth, windowHeight)) {

                bbg.drawOval(windowWidth / 2 + (e.getX() - cam.getX()), windowHeight / 2 + (e.getY() - cam.getY()), e.getWidth(), e.getHeight());
                bbg.drawOval(windowWidth / 2 + (e.getX() - cam.getX()), windowHeight / 2 + (e.getY() - cam.getY()), 1,1);

            }
        }

        return backBuffer;
    }

    public void update(){}
}
