package upgrade;

import main.Main;
import main.MainController;
import main.SidekickData;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import screens.draganddrop.DragAndDropManager;
import screens.draganddrop.DragArea;
import screens.draganddrop.PartDraggable;
import upgrade.bodyparts.AbstractBodyPart;
import upgrade.bodyparts.BodyPart;
import upgrade.bodyparts.PartFactory;
import util.Pool;

import java.util.ArrayList;

public class UpgradeController extends Screen implements ComponentListener {

    private MainController main;
    private UpgradeView view;

    private DragAndDropManager dndManager;
    private ArrayList<PartDraggable> draggables;
    private ArrayList<DragArea> dragAreas;
    private DragArea headArea, bodyArea, armLeftArea, armRightArea, legLeftArea, legRightArea, tailArea, puddle1, puddle2, puddle3;
    public int getID() {
        return Main.UPGRADE;
    }

    public UpgradeController(MainController main)
    {
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        view = new UpgradeView(this);
        view.init(gc);

        dndManager = new DragAndDropManager();
        dndManager.init(gc);

        draggables = new ArrayList<>();
        dragAreas = new ArrayList<>();

        headArea = new DragArea(200, 100, 75, 75);
        bodyArea = new DragArea(175, 200, 125, 250);
        armLeftArea = new DragArea(75, 200, 70, 150);
        armRightArea = new DragArea(325, 200, 70, 150);
        legLeftArea = new DragArea(160, 475, 75, 150);
        legRightArea = new DragArea(250, 475, 75, 150);
        tailArea = new DragArea(325, 380, 200, 50);
        dragAreas.add(headArea);
        dragAreas.add(bodyArea);
        dragAreas.add(armLeftArea);
        dragAreas.add(armRightArea);
        dragAreas.add(legLeftArea);
        dragAreas.add(legRightArea);
        dragAreas.add(tailArea);

        puddle1 = new DragArea(1200, 340, 10, 10);
        puddle2 = new DragArea(1120, 490, 10, 10);
        puddle3 = new DragArea(1300, 490, 10, 10);
        dragAreas.add(puddle1);
        dragAreas.add(puddle2);
        dragAreas.add(puddle3);


        //draggables.add(new PartDraggable(headArea, PartFactory.getPart("dog_head")));
        //draggables.add(new PartDraggable(bodyArea,  PartFactory.getPart("dog_body")));
        //draggables.add(new PartDraggable(legRightArea, PartFactory.getPart("dog_leg")));
        //draggables.add(new PartDraggable(legLeftArea,  PartFactory.getPart("dog_leg")));
        //draggables.add(new PartDraggable(armRightArea,  PartFactory.getPart("dog_arm")));
        //draggables.add(new PartDraggable(armLeftArea,  PartFactory.getPart("dog_arm")));
        //draggables.add(new PartDraggable(tailArea,  PartFactory.getPart("dog_tail")));

        //draggables.add(new PartDraggable(puddle1,  PartFactory.getPart("dog_leg")));
        //draggables.add(new PartDraggable(puddle2, PartFactory.getPart("dog_body")));
        //draggables.add(new PartDraggable(puddle3, PartFactory.getPart("dog_leg")));

//        for(PartDraggable d : draggables) {
//            d.init(gc);
//            dndManager.attach(d);
//        }
        for(DragArea da : dragAreas)
            dndManager.attach(da);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        draggables = new ArrayList<>();

        SidekickData sidekick = main.getSidekick();
        draggables.add(new PartDraggable(headArea, sidekick.getHead()));
        draggables.add(new PartDraggable(bodyArea, sidekick.getBody()));
        draggables.add(new PartDraggable(legLeftArea, sidekick.getLegLeft()));
        draggables.add(new PartDraggable(legRightArea, sidekick.getLegRight()));
        draggables.add(new PartDraggable(armLeftArea, sidekick.getArmLeft()));
        draggables.add(new PartDraggable(armRightArea, sidekick.getArmRight()));
        draggables.add(new PartDraggable(tailArea, sidekick.getTail()));

        Pool<AbstractBodyPart> rewards = new Pool<>();
        rewards.addAll(main.getActiveRoom().getRewards());

        draggables.add(new PartDraggable(puddle1, rewards.pop()));
        draggables.add(new PartDraggable(puddle2, rewards.pop()));
        draggables.add(new PartDraggable(puddle3, rewards.pop()));


        for(PartDraggable d : draggables) {
            d.init(gc);
            dndManager.attach(d);
        }
    }

    public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        main.updateSidekick();
    }


    public AbstractBodyPart getHead() throws SlickException{
        return headArea.getPart().getPart();
    }

    public AbstractBodyPart getBody() throws SlickException{
        return bodyArea.getPart().getPart();
    }

    public AbstractBodyPart getLegLeft()throws SlickException{
        return legLeftArea.getPart().getPart();
    }

    public AbstractBodyPart getLegRight()throws SlickException{
        return legRightArea.getPart().getPart();
    }

    public AbstractBodyPart getArmLeft()throws SlickException{
        return armLeftArea.getPart().getPart();
    }

    public AbstractBodyPart getArmRight()throws SlickException{
        return armRightArea.getPart().getPart();
    }

    public AbstractBodyPart getTail()throws SlickException{
        return tailArea.getPart().getPart();
    }


    public ArrayList<PartDraggable> getDraggables() {
        return draggables;
    }

    public ArrayList<DragArea> getDragAreas() {
        return dragAreas;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        view.render(gc, sbg, g);
    }


    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.TRAVEL);
    }
}
