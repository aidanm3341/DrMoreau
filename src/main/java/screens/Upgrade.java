package screens;

import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.draganddrop.DragAndDropManager;
import screens.draganddrop.PartDragArea;
import screens.draganddrop.PartDraggable;

import java.util.ArrayList;

public class Upgrade extends Screen {

    private DragAndDropManager dndManager;
    private ArrayList<PartDraggable> draggables;
    private ArrayList<PartDragArea> dragAreas;
    private PartDragArea headArea, bodyArea, arm1Area, arm2Area, leg1Area, leg2Area, tailArea;
    public int getID() {
        return Main.UPGRADE;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        dndManager = new DragAndDropManager();
        dndManager.init(gc);

        draggables = new ArrayList<>();
        dragAreas = new ArrayList<>();

        headArea = new PartDragArea(200, 100, 75, 75);
        bodyArea = new PartDragArea(175, 200, 125, 250);
        arm1Area = new PartDragArea(75, 200, 75, 150);
        arm2Area = new PartDragArea(325, 200, 75, 150);
        dragAreas.add(headArea);
        dragAreas.add(bodyArea);
        dragAreas.add(arm1Area);
        dragAreas.add(arm2Area);

        draggables.add(new PartDraggable(headArea, 50, 50));
        draggables.add(new PartDraggable(bodyArea, 75, 50));

        for(PartDraggable d : draggables) {
            d.init(gc);
            dndManager.attatch(d);
        }
        for(PartDragArea da : dragAreas)
            dndManager.attatch(da);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        super.render(gc, sbg, g);
        for(PartDragArea d : dragAreas)
            d.render(gc, g);
        for(PartDraggable d : draggables)
            d.render(gc, g);
    }


}
