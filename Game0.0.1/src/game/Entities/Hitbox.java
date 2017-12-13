package game.Entities;

public class Hitbox {

    int x;
    int y;
    int height;
    int width;


    public Hitbox(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isColliding(Hitbox other){
        return (false);
    }

}
