package animal;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

public class Body extends Part{

    private float x, y;
    private Point headP, armP, arm2P, legP, leg2P, tailP;

    public Body(float x, float y, Image image)
    {
        super(PartType.BODY, image, null);
        this.x = x;
        this.y = y;
        box = new Rectangle(x,y, image.getWidth(), image.getHeight());

        headP = new Point(x+box.getWidth()*0.9f, y+(box.getHeight()*0.33f));
        armP = new Point(x+box.getWidth()*0.8f, y+box.getHeight()*0.4f);
        arm2P = new Point(x+box.getWidth()*0.7f, y+box.getHeight()*0.3f);
        legP = new Point (x+box.getWidth()*0.3f, y+box.getHeight()*0.3f);
        leg2P = new Point (x+box.getWidth()*0.2f, y+box.getHeight()*0.2f);
        tailP = new Point(x, y+box.getHeight()*0.4f);
    }

    public void attach(Part p)
    {
        switch(p.type()){
            case HEAD:
                p.attachTo(headP);
                break;
            case ARM:
                p.attachTo(armP);
                break;
            case ARM2:
                p.attachTo(arm2P);
                break;
            case LEG:
                p.attachTo(legP);
                break;
            case LEG2:
                p.attachTo(leg2P);
                break;
            case TAIL:
                p.attachTo(tailP);
                break;
        }
    }
}
