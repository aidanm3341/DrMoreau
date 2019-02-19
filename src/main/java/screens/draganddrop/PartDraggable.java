package screens.draganddrop;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;

public class PartDraggable{

    private PartDragArea home;
    private Rectangle rect;
    private boolean isClicked;

    public PartDraggable(PartDragArea home, int width, int height)
    {
        home.link(this);
        rect = new Rectangle(0, 0, width, height);
        goHome();
    }

    public void init(GameContainer gc){
    }

    public void render(GUIContext gc, Graphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }


    public Rectangle getRect(){
        return rect;
    }
    public void setHome(PartDragArea home){
        this.home = home;
        //this.homex = homex;
        //this.homey = homey;
    }
    public void setX(float x){
        rect.setCenterX(x);
    }
    public void setY(float y){
        rect.setCenterY(y);
    }
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
    public PartDragArea getHome(){
        return home;
    }

    public void goHome()
    {
        rect.setCenterX(home.getHomex());
        rect.setCenterY(home.getHomey());
    }
}
