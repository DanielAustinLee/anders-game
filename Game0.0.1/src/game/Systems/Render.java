package game.Systems;

import game.Messaging.*;

public class Render extends System  {


    @Override
    public boolean canHandle(Message msg) {
        return msg instanceof DrawMessage;
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg instanceof EntityMessage) {

        }
    }
}
