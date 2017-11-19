import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Daniel on 11/14/2017.
 */
public class MouseHandler implements MouseListener
{
    public boolean clicked = false;

    public MouseHandler(Component c){c.addMouseListener(this);}

    public boolean isMouseClicked(){ return clicked; }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse down");
    }

    @Override
    public void mousePressed(MouseEvent e) {  }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse up");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse on screen");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse off screen");
    }
}
