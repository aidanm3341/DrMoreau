package screens.draganddrop;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;

public class Draggable {

    private DragArea home;
    private Rectangle rect;
    private boolean isClicked;

    public Draggable(DragArea home)
    {
        home.link(this);
        rect = new Rectangle(0, 0, 100, 100);
        goHome();
    }

    public void init(GameContainer gc){
        goHome();
    }

    public void render(GUIContext gc, Graphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }


    public Rectangle getRect(){
        return rect;
    }
    public void setHome(DragArea home){
        this.home = home;
    }
    public void setX(float x){
        rect.setCenterX(x);
    }
    public void setY(float y){
        rect.setCenterY(y);
    }
    public void setWidth(float width){rect.setWidth(width);}
    public void setHeight(float height){rect.setHeight(height);}
    public float getX(){
        return rect.getCenterX();
    }
    public float getY(){
        return rect.getCenterY();
    }
    public boolean isClicked() {
        return isClicked;
    }
    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
    public boolean contains(float x, float y){
        return rect.contains(x, y);
    }
    public DragArea getHome(){
        return home;
    }

    public void goHome()
    {
        rect.setCenterX(home.getHomex());
        rect.setCenterY(home.getHomey());
    }
}
