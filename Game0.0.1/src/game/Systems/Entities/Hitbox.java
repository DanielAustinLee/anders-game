package game.Systems.Entities;

public class Hitbox {

    Entity e;


    public Hitbox(Entity entity){
        this.e = entity;
    }

    public boolean isColliding(Hitbox other){

        return !(e.getX() + e.getWidth() < other.e.getX() || other.e.getX() + other.e.getWidth() < e.getX() || e.getY() + e.getHeight() < other.e.getY() || other.e.getY() + e.getHeight() < e.getY() );

    }

}
