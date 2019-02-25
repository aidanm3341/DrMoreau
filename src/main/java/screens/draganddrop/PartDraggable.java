package screens.draganddrop;

import animal.Part;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

public class PartDraggable extends Draggable {

    private Part part;
    private float scale = 0.5f;

    public PartDraggable(DragArea home, Part part) {
        super(home);
        this.part = part;
        setWidth(part.getWidth()*scale);
        setHeight(part.getHeight()*scale);
    }

    public void render(GUIContext gc, Graphics g){
        Image partImage = part.getImage().getScaledCopy(scale);
        g.drawImage(partImage, getX() - partImage.getWidth()/2, getY() - partImage.getHeight()/2);
    }
}
