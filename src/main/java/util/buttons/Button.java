package util.buttons;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import util.MyFont;

public class Button {

    private Image button;
    private UnicodeFont font;

    private String text;
    private MouseOverArea mouseArea;
    private float x, y;

    public Button(String text, Image image, float x, float y)
    {
        this.text = text;
        this.button = image;
        this.x = x;
        this.y = y;
        try {
            this.font = MyFont.createFont(30f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(GameContainer gc)
    {
        mouseArea = new MouseOverArea(gc, button, 0, 0);
        mouseArea.setX(x - mouseArea.getWidth()/2);
        mouseArea.setY(y - mouseArea.getHeight()/2);
    }

    public void render(GameContainer gc, Graphics g)
    {
        mouseArea.render(gc, g);

        g.setFont(font);
        g.setColor(Color.black);

        g.drawString(text, x - 45, y - 10);

    }

    public void addHoverOverImage(Image image) {
        mouseArea.setMouseOverImage(image);
    }

    public void addPressedImage(Image image){
        mouseArea.setMouseDownImage(image);
    }

    public void addListener(ComponentListener listener) {
        mouseArea.addListener(listener);
    }

    public boolean equals(Object c)
    {
        return mouseArea.equals(c);
    }
}
