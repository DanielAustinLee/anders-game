package game.Systems.Messaging;

public class EntityMessage implements Message {
    public int id;
    public int x;
    public int y;

    public EntityMessage(int _id, int _x, int _y){
        this.id = _id;
        this.x = _x;
        this.y = _y;
    }
}
