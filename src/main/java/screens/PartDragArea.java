package screens;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class PartDragArea{

    private int x, y, width, height;

    public PartDragArea(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void render(GameContainer gc, Graphics g)
    {
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
    }
}
