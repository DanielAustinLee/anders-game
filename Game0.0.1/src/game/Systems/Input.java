package game.Systems;

import game.Messaging.InputMessage;
import game.Messaging.Message;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input extends System implements KeyListener, MouseListener {


    private static boolean[] keys = new boolean[256];

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
                getController().postMessage(new InputMessage(keys));
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
        getController().postMessage(new InputMessage(keys));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
            keys[e.getKeyCode()] = false;
        getController().postMessage(new InputMessage(keys));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        getController().postMessage(new InputMessage(e));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        getController().postMessage(new InputMessage(e));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
