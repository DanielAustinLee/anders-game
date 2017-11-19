package game;

import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Entity
{
    public int x;
    public int y;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int width;
    public int height;
    public double orientation;



    public Entity(int _x, int _y, int _width, int _height)
    {
        this.width = _width;
        this.height = _height;

        this.x1 = _x;
        this.y1 = _y;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
        this.x = x1 + width/2;
        this.y = y1 + height/2;
        this.orientation = 0.00;
    }

    public void moveUp(int amount)
    {
        y1 = y1 - amount;
        y2 = y2 - amount;
        y = y - amount;
    }

    public void moveDown(int amount)
    {
        y1 = y1 + amount;
        y2 = y2 + amount;
        y = y + amount;
    }

    public void moveRight(int amount)
    {
        x1 = x1 + amount;
        x2 = x2 + amount;
        x = x + amount;
    }

    public void moveLeft(int amount)
    {
        x1 = x1 - amount;
        x2 = x2 - amount;
        x = x - amount;
    }

    public void turn(double amount) { orientation = orientation + amount; }

    public void setOrientation(double o) { orientation = o; }

    public void moveForward(int amount)
    {
        x1 += amount * sin(orientation);
        y1 += amount * cos(orientation);
        x2 += amount * sin(orientation);
        y2 += amount * cos(orientation);
        x += amount * sin(orientation);
        y += amount * cos(orientation);
    }

    public void action(){}

}