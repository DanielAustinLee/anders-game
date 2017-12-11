package game;


import game.Messaging.Message;
import game.Systems.System;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Controller
{

    private final int MSG_BUFF_LEN = 60;

    public static Controller c = null;
    public ArrayList<System> systems;
    private ArrayList<Message> messageBuffer;

    private Controller()
    {
        systems = new ArrayList<>(5);
        messageBuffer = new ArrayList<>(MSG_BUFF_LEN);
    }

    public static Controller getController()
    {
        if (c == null)
        {
            c = new Controller();
        }
        return c;
    }

    public void postMessage(Message msg)
    {
        if (messageBuffer.size() < MSG_BUFF_LEN)
            messageBuffer.add(msg);
    }

    public void update()
    {

        if (messageBuffer.size() > 0) {
            Message msg = messageBuffer.remove(0);

            for (System s : systems) {

                if (s.canHandle(msg)) {
                    s.handleMessage(msg);
                }
            }
        }

    }



}
