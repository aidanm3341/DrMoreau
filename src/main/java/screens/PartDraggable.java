package screens;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class PartDraggable extends AbstractComponent {

    private Rectangle rect;
    private boolean isClicked;
    private float homex, homey;

    public PartDraggable(GUIContext gc, int x, int y, int width, int height)
    {
        super(gc);
        rect = new Rectangle(x, y, width, height);
    }

    public void init(GameContainer gc){
    }

    public void update(GameContainer gc, int delta) {

    }

    public void render(GUIContext gc, Graphics g)
    {
        g.draw(rect);
    }

    public void mouseClicked(int oldx, int oldy, int newx, int newy) {

    }

    public void mousePressed(int button, int mx, int my) {
        if(!isClicked) {
            isClicked = true;
            homex = rect.getX();
            homey = rect.getY();
        }
    }

    public void mouseReleased(int button, int mx, int my) {
        if(isClicked) {
            isClicked = false;
            rect.setX(homex);
            rect.setY(homey);
        }
    }

    public void mouseMoved(int oldx, int oldy, int newx, int newy) { }

    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        if(rect.contains(oldx, oldy)) {
            rect.setX(rect.getX() + newx - oldx);
            rect.setY(rect.getY() + newy - oldy);
        }
    }


    public void setLocation(int i, int i1) { }
    public int getX() {
        return (int)rect.getX();
    }
    public int getY() {
        return (int)rect.getY();
    }
    public int getWidth() {
        return (int)rect.getWidth();
    }
    public int getHeight() {
        return (int)rect.getHeight();
    }
}
