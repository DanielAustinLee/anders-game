package game.Systems;

import game.Controller;
import game.Messaging.Message;

public abstract class System{

    private Controller c;

    public System(){
        c = Controller.getController();
        c.systems.add(this);
    }

    public Controller getController() {
        return c;
    }

    public abstract boolean canHandle(Message msg);
    public abstract void handleMessage(Message msg);
}
