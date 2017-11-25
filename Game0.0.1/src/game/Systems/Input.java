package game.Systems;

import game.Messaging.InputMessage;
import game.Messaging.Message;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input extends System implements KeyListener, MouseListener {

    private boolean mouseDown = false;

    public Input(Component c)
    {
        super();
        c.addKeyListener(this);
        c.addMouseListener(this);
    }

    @Override
    public void handleMessage(Message msg) {

    }

    @Override
    public boolean canHandle(Message msg) {
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        getController().postMessage(new InputMessage(mouseDown, e.getKeyChar()));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        getController().postMessage(new InputMessage(mouseDown, '`'));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDown = true;
        getController().postMessage(new InputMessage(mouseDown, '`'));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDown = false;
        getController().postMessage(new InputMessage(mouseDown, '`'));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
