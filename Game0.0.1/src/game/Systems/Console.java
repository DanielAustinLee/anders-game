package game.Systems;

import game.Systems.Messaging.EntityMessage;
import game.Systems.Messaging.InputMessage;
import game.Systems.Messaging.Message;

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
            //is there a better way to do this? seems slow
            for (int i = 0; i < ((InputMessage) msg).keysPressed.length; i++)
            {
                if (((InputMessage) msg).keysPressed[i])
                {
                    print((char)i);
                }
            }
        }

        if (msg instanceof EntityMessage){
            print("ID: " + ((EntityMessage) msg).id);
            print("X: " + ((EntityMessage) msg).x);
            print("Y: " + ((EntityMessage) msg).y);
        }


        print("");

    }

    public void update(){}


    private void print(int i)
    {
        java.lang.System.out.println(i);
    }

    private void print(String s)
    {
        java.lang.System.out.println(s);
    }


    private void print(char c)
    {
        java.lang.System.out.println(c);
    }
}
