package upgrade;

import data.mob.Mob;
import data.framework.IBodyPart;
import data.framework.PartType;
import main.Main;
import main.MainController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import upgrade.draganddrop.DragAndDropManager;
import upgrade.draganddrop.DragArea;
import upgrade.draganddrop.PartDraggable;
import util.Pool;

import java.util.ArrayList;
import java.util.List;

public class UpgradeController extends Screen implements ComponentListener {
    public int getID() {
        return Main.UPGRADE;
    }

    private MainController main;

    private UpgradeView view;
    private DragAndDropManager dndManager;
    private List<PartDraggable> draggables;
    private List<DragArea> dragAreas;
    private DragArea headArea, bodyArea, armLeftArea, armRightArea, legLeftArea, legRightArea, tailArea, puddle1, puddle2, puddle3;

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

        for(DragArea da : dragAreas)
            dndManager.attach(da);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        draggables = new ArrayList<>();

        Mob sidekick = main.getSidekick();
        draggables.add(new PartDraggable(headArea, sidekick.getPart(PartType.HEAD)));
        draggables.add(new PartDraggable(bodyArea,  sidekick.getPart(PartType.BODY)));
        draggables.add(new PartDraggable(legLeftArea,  sidekick.getPart(PartType.LEFT_LEG)));
        draggables.add(new PartDraggable(legRightArea,  sidekick.getPart(PartType.RIGHT_LEG)));
        draggables.add(new PartDraggable(armLeftArea,  sidekick.getPart(PartType.LEFT_ARM)));
        draggables.add(new PartDraggable(armRightArea,  sidekick.getPart(PartType.RIGHT_ARM)));
        draggables.add(new PartDraggable(tailArea,  sidekick.getPart(PartType.TAIL)));

        Pool<IBodyPart> rewards = new Pool<>();
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


    public IBodyPart getHead(){
        return headArea.getPart().getPart();
    }

    public IBodyPart getBody(){
        return bodyArea.getPart().getPart();
    }

    public IBodyPart getLegLeft(){
        return legLeftArea.getPart().getPart();
    }

    public IBodyPart getLegRight(){
        return legRightArea.getPart().getPart();
    }

    public IBodyPart getArmLeft(){
        return armLeftArea.getPart().getPart();
    }

    public IBodyPart getArmRight(){
        return armRightArea.getPart().getPart();
    }

    public IBodyPart getTail(){
        return tailArea.getPart().getPart();
    }


    public List<PartDraggable> getDraggables() {
        return draggables;
    }

    public List<DragArea> getDragAreas() {
        return dragAreas;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        view.render(gc, sbg, g);
    }

    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.TRAVEL);
    }
}
