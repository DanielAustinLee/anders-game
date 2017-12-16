package game.Systems.Entities;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Entity
{

    private static EntityManager manager = EntityManager.getEntityManager();
    private static int entityCount = 0;


    public boolean visible;

    int id;
    int x;
    int y;
    int width;
    int height;
    double orientation;



    public Entity(int _x, int _y, int _width, int _height)
    {

        visible = true;
        manager.add(this);

        this.width = _width;
        this.height = _height;

        this.id = entityCount;
        this.x = _x;
        this.y = _y;

        this.orientation = 0.00;
        entityCount++;
    }

    public int getId(){
        return this.id;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void moveUp(int amount)
    {
        y = y - amount;
    }

    public void moveDown(int amount)
    {
        y = y + amount;
    }

    public void moveRight(int amount)
    {
        x = x + amount;
    }

    public void moveLeft(int amount)
    {
        x = x - amount;
    }

    public void turn(double amount) { orientation = orientation + amount; }

    public void setOrientation(double o) { orientation = o; }

    public void moveForward(int amount)
    {
        x += amount * sin(orientation);
        y += amount * cos(orientation);
    }

    public void action(){}

    public boolean equals(Entity e) { return this.getId() == e.getId(); }

    public Hitbox getHitbox(){
        return (new Hitbox(this));
    }

    public boolean checkCollision(Entity other){
        return getHitbox().isColliding(other.getHitbox());
    }

    public void kill(){
        visible = false;
        manager.remove(this);
    }

}
