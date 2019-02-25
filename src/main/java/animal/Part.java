package animal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

public class Part{

    protected Rectangle box;
    private Image image;
    private PartType type;
    private Point bodyConnector;

    public Part(PartType type, Image image, Point bodyConnector)
    {
        this.image = image;
        this.type = type;
        box = new Rectangle(-1000, -1000, image.getWidth(), image.getHeight());
        this.bodyConnector = bodyConnector;
    }

    public void attachTo(Point point)
    {
        box.setX(point.getX() - bodyConnector.getX());
        box.setY(point.getY() - bodyConnector.getY());
    }

    public void render(GameContainer gc, Graphics g)
    {
        //g.draw(box);
        g.drawImage(image, box.getX(), box.getY());
    }

    public Image getImage(){
        return image;
    }

    public PartType getType(){
        return type;
    }

    public float getWidth(){
        return box.getWidth();
    }

    public float getHeight(){
        return box.getHeight();
    }
}
