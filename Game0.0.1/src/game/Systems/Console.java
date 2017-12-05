package game.Systems;

import game.Messaging.EntityMessage;
import game.Messaging.InputMessage;
import game.Messaging.Message;
import game.Systems.System;

public class Console extends System {

    private static Console instance;

    private Console() {
        super();
    }

    public static Console getConsole(){
        if (instance == null){
            instance = new Console();
        }

        return instance;
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

        if (msg instanceof EntityMessage){
            print("ID: " + ((EntityMessage) msg).id);
            print("X: " + ((EntityMessage) msg).x);
            print("Y: " + ((EntityMessage) msg).y);
        }

        print("");

    }


    private void print(int i)
    {
        java.lang.System.out.println(i);
    }

    private void print(String s)
    {
        java.lang.System.out.println(s);
    }
}
