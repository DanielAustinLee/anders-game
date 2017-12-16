package game.Systems.Draw;

class Camera {

    private int x;
    private int y;

    Camera(int x, int y){
        this.x = x;
        this.y = y;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){return this.x;}

    int getY(){return this.y;}

    boolean inFrame(int x, int y, int windowWidth, int windowHeight)
    {
        return (x < this.x + windowWidth/2 && x > this.x - windowWidth/2 && y < this.y + windowHeight/2 && y > this.y - windowHeight/2);

    }
}
