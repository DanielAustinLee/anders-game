package game.Systems.Messaging;

public class InputMessage implements Message {

    public boolean[] keysPressed;
    public boolean mouseDown;

    public InputMessage(boolean[] keysPressed, boolean mouseDown)
    {
        super();
        this.keysPressed = keysPressed;
        this.mouseDown = mouseDown;
    }



}
