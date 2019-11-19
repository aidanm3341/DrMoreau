package combat;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;
import util.MyFont;

import java.awt.*;
import java.io.IOException;

public class AbilityButton {

    private static final int WIDTH = 350, HEIGHT = 65;

    private MouseOverArea area;
    private float x, y;
    private String text;

    public AbilityButton(String text, float x, float y) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public void init(GameContainer gc) throws SlickException {
        Image image = new Image(WIDTH, HEIGHT);
        image.getGraphics().setColor(new Color(0, 0, 0, 0.8f));
        image.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        image.getGraphics().flush();

        Image hoverImage = new Image(WIDTH, HEIGHT);
        hoverImage.getGraphics().setColor(new Color(0, 0, 0, 1f));
        hoverImage.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        hoverImage.getGraphics().flush();

        area = new MouseOverArea(gc, image, (int) x, (int) y);
        area.setMouseOverImage(hoverImage);
    }

    public void render(GameContainer gc, Graphics g) {
        area.render(gc, g);
        g.setColor(Color.white);
        g.drawString(text, x + 20, y + 20);
    }
}
