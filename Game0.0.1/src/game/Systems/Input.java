package game.Systems;

import game.Systems.Messaging.InputMessage;
import game.Systems.Messaging.Message;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input extends System implements KeyListener, MouseListener {


    private static boolean[] keys = new boolean[256];
    private static boolean mouse = false;

    public Input(Component c)
    {
        super();
        c.addKeyListener(this);
        c.addMouseListener(this);
    }

    @Override
    public void handleMessage(Message msg) {
        for (int i = 0; i < keys.length; i++){
            if (keys[i])
                getController().postMessage(new InputMessage(keys, mouse));
        }
    }

    @Override
    public boolean canHandle(Message msg) {
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
            keys[e.getKeyCode()] = true;
        getController().postMessage(new InputMessage(keys, mouse));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
            keys[e.getKeyCode()] = false;
        getController().postMessage(new InputMessage(keys, mouse));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouse = true;
        getController().postMessage(new InputMessage(keys, mouse));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse = false;
        getController().postMessage(new InputMessage(keys, mouse));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //update doesn't really fit here... should this be a system?
    public void update(){}
}
