package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static game.Controller.c;

/**
 * Created by Daniel on 11/14/2017.
 */
public class MouseHandler implements MouseListener
{
    public boolean clicked = false;
    public boolean onScreen;

    public MouseHandler(Component c){c.addMouseListener(this);}

    public boolean isMouseClicked(){ return clicked; }



    @Override
    public void mouseClicked(MouseEvent e){    }

    @Override
    public void mousePressed(MouseEvent e) { c.mouseClick(); }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {
        onScreen = true;
    }

    @Override
    public void mouseExited(MouseEvent e) { onScreen = false; }
}
