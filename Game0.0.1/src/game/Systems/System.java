package game.Systems;

import game.Controller;
import game.Systems.Messaging.Message;

//this could possibly be an interface as well, but then each system would have to be responsible for
//attaching to controller
public abstract class System{



    private Controller c;

    public System(){
        c = Controller.getController();
        c.systems.add(this);
    }

    public Controller getController() {
        return c;
    }


    public abstract void update();
    public abstract boolean canHandle(Message msg);
    public abstract void handleMessage(Message msg);
}
