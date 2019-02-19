package screens.draganddrop;

import animal.Part;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

public class PartDraggable extends Draggable {

    private Part part;

    public PartDraggable(DragArea home, int width, int height, Part part) {
        super(home, width, height);
        this.part = part;
    }

    public void render(GUIContext gc, Graphics g){
        Image partImage = part.getImage().getScaledCopy(0.5f);
        g.drawImage(partImage, getX() - partImage.getWidth()/2, getY() - partImage.getHeight()/2);
    }
}
