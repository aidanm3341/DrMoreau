package screens;

import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Upgrade extends Screen {

    private PartDragArea dragArea;
    private PartDraggable draggable;
    public int getID() {
        return Main.UPGRADE;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        dragArea = new PartDragArea(100, 100, 100, 100);
        draggable = new PartDraggable(gc,300, 100, 50, 50);
        draggable.init(gc);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i){
        draggable.update(gc, i);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        super.render(gc, sbg, g);
        dragArea.render(gc, g);
        draggable.render(gc, g);
    }


}
