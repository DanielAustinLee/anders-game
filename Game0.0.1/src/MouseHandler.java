import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Daniel on 11/14/2017.
 */
public class MouseHandler implements MouseListener
{
    private boolean clicked = false;

    public MouseHandler(Component c){c.addMouseListener(this);}

    public boolean isMouseClicked(){ return clicked; }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
