package game.Messaging;

public class InputMessage extends Message {

    public boolean[] keysPressed;
    public boolean mouseDown;

    public InputMessage(boolean[] keysPressed, boolean mouseDown)
    {
        super();
        this.keysPressed = keysPressed;
        this.mouseDown = mouseDown;
    }



}
