package screens;

import animal.PartFactory;
import main.Main;
import main.MainController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import screens.draganddrop.DragAndDropManager;
import screens.draganddrop.DragArea;
import screens.draganddrop.Draggable;
import screens.draganddrop.PartDraggable;
import util.Button;
import util.ResourceLoader;

import java.util.ArrayList;

public class Upgrade extends Screen implements ComponentListener {

    private MainController main;

    private DragAndDropManager dndManager;
    private ArrayList<Draggable> draggables;
    private ArrayList<DragArea> dragAreas;
    private DragArea headArea, bodyArea, arm1Area, arm2Area, leg1Area, leg2Area, tailArea, puddle1, puddle2, puddle3;
    private Image puddle;
    private Button nextButton;
    public int getID() {
        return Main.UPGRADE;
    }

    public Upgrade(MainController main)
    {
        this.main = main;
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


        draggables.add(new PartDraggable(headArea, PartFactory.getPart("dog_head")));
        draggables.add(new PartDraggable(bodyArea,  PartFactory.getPart("ostrich_head")));
        draggables.add(new PartDraggable(puddle1,  PartFactory.getPart("dog_leg")));
        draggables.add(new PartDraggable(leg1Area,  PartFactory.getPart("blue_leg")));
        draggables.add(new PartDraggable(arm2Area,  PartFactory.getPart("dog_arm")));
        draggables.add(new PartDraggable(tailArea,  PartFactory.getPart("dog_arm")));
        draggables.add(new PartDraggable(puddle2, PartFactory.getPart("dog_body")));
        draggables.add(new PartDraggable(puddle3, PartFactory.getPart("dog_leg")));

        for(Draggable d : draggables) {
            d.init(gc);
            dndManager.attach(d);
        }
        for(DragArea da : dragAreas)
            dndManager.attach(da);

        puddle = ResourceLoader.getImage("upgradePuddle");

        nextButton = new Button("Next", ResourceLoader.getImage("basicButton"), gc.getWidth() - 150, gc.getHeight() - 75);
        nextButton.init(gc);
        nextButton.addListener(this);
        nextButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        nextButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        super.render(gc, sbg, g);

        g.drawImage(puddle, gc.getWidth()/2, 100);
        for(DragArea d : dragAreas)
            d.render(gc, g);
        for(Draggable d : draggables)
            d.render(gc, g);

        nextButton.render(gc, g);
    }


    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.TRAVEL);
    }
}
