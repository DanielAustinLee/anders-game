package game.Systems;

public class Camera {

    private int x;
    private int y;

    public Camera(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public boolean inFrame(int x, int y, int windowWidth, int windowHeight)
    {
        return (x < this.x + windowWidth/2 && x > this.x - windowWidth/2 && y < this.y + windowHeight/2 && y > this.y - windowHeight/2);

    }
}
