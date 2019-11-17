package screens.draganddrop;

import data.framework.BodyPart;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;

public class PartDraggable {

    private DragArea home;
    private Rectangle rect;
    private boolean isClicked;

    private BodyPart part;
    private float scale = 0.5f;

    public PartDraggable(DragArea home, BodyPart part)
    {
        home.link(this);
        rect = new Rectangle(0, 0, 100, 100);
        goHome();

        this.part = part;
        setWidth(part.getWidth()*scale);
        setHeight(part.getHeight()*scale);
    }

    public void init(GameContainer gc){
        goHome();
    }

    public void render(GUIContext gc, Graphics g){
        Image partImage = part.getImage().getScaledCopy(scale);
        g.drawImage(partImage, getX() - partImage.getWidth()/2, getY() - partImage.getHeight()/2);
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

    public BodyPart getPart() {
        return part;
    }
}
