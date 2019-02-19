package screens;

import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.draganddrop.DragAndDropManager;
import screens.draganddrop.DragArea;
import screens.draganddrop.Draggable;
import util.ResourceLoader;

import java.util.ArrayList;

public class Upgrade extends Screen {

    private DragAndDropManager dndManager;
    private ArrayList<Draggable> draggables;
    private ArrayList<DragArea> dragAreas;
    private DragArea headArea, bodyArea, arm1Area, arm2Area, leg1Area, leg2Area, tailArea, puddle1, puddle2, puddle3;
    private Image puddle;
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

        headArea = new DragArea(200, 100, 75, 75);
        bodyArea = new DragArea(175, 200, 125, 250);
        arm1Area = new DragArea(75, 200, 70, 150);
        arm2Area = new DragArea(325, 200, 70, 150);
        leg1Area = new DragArea(160, 475, 75, 150);
        leg2Area = new DragArea(250, 475, 75, 150);
        tailArea = new DragArea(325, 380, 200, 50);
        dragAreas.add(headArea);
        dragAreas.add(bodyArea);
        dragAreas.add(arm1Area);
        dragAreas.add(arm2Area);
        dragAreas.add(leg1Area);
        dragAreas.add(leg2Area);
        dragAreas.add(tailArea);

        puddle1 = new DragArea(1200, 340, 10, 10);
        puddle2 = new DragArea(1120, 490, 10, 10);
        puddle3 = new DragArea(1300, 490, 10, 10);
        dragAreas.add(puddle1);
        dragAreas.add(puddle2);
        dragAreas.add(puddle3);


        draggables.add(new Draggable(headArea, 50, 50));
        draggables.add(new Draggable(bodyArea, 75, 50));

        for(Draggable d : draggables) {
            d.init(gc);
            dndManager.attatch(d);
        }
        for(DragArea da : dragAreas)
            dndManager.attatch(da);

        puddle = ResourceLoader.getImage("upgradePuddle");
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        super.render(gc, sbg, g);

        g.drawImage(puddle, gc.getWidth()/2, 100);
        for(DragArea d : dragAreas)
            d.render(gc, g);
        for(Draggable d : draggables)
            d.render(gc, g);
    }


}
