package game.Messaging;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputMessage extends Message {

    public KeyEvent key = null;
    public boolean[] keysPressed;
    public MouseEvent mouse = null;

    public InputMessage(boolean[] keysPressed)
    {
        super();
        this.keysPressed = keysPressed;
    }

    public InputMessage( MouseEvent mouse)
    {
        super();
        this.mouse = mouse;
    }

}
