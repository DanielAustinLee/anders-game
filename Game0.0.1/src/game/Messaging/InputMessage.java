package game.Messaging;

public class InputMessage extends Message {

    public boolean mouseClick = false;
    public char keyPressed;

    public InputMessage(boolean mouseDown, char key)
    {
        super();
        mouseClick = mouseDown;
        keyPressed = key;
    }

}
