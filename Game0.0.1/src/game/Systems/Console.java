package game.Systems;

import game.Messaging.InputMessage;
import game.Messaging.Message;
import game.Systems.System;

public class Console extends System {

    public Console() {
        super();
    }

    @Override
    public boolean canHandle(Message msg) {
        return true;
    }

    @Override
    public void handleMessage(Message msg) {

        print("Console: ");

        if (msg instanceof InputMessage){
            print("Key Pressed: " + ((InputMessage) msg).keyPressed);
            print("Mouse down: " + ((InputMessage) msg).mouseClick);
        }

    }

    private void print(String s)
    {
        java.lang.System.out.println(s);
    }
}
