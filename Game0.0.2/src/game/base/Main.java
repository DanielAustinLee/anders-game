package game.base;

import game.base.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main
{
    private static int fps = 60;
    private static Window gameWindow = Window.getWindow();

    public static void main(String[] args)
    {

        long time;

        //main loop should decouple updating and drawing

        while (gameWindow.isRunning())
        {
            time = java.lang.System.currentTimeMillis();
            tick();
            time = (1000 / fps) - (java.lang.System.currentTimeMillis() - time);


            if (time > 0)
            {
                try
                {
                    Thread.sleep(time);
                }
                catch (Exception e){}
            }

        }

    }

    private static void tick()
    {
        System.out.println("Running");
    }





}
