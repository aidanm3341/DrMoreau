package navigation;

import data.loaders.BasicRoomBlueprintLoader;
import data.mob.MobCreator;
import data.loaders.RoomBlueprintLoader;
import main.Main;
import main.MainController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import util.Pool;
import util.ResourceLoader;

import java.util.List;
import java.util.Random;

public class NavigationController extends Screen implements ComponentListener {
    public int getID() {
        return Main.TRAVEL;
    }

    private MainController main;
    private NavigationView view;
    private RoomBlueprintLoader roomBlueprintLoader;
    private Room left, right, activeRoom;

    private int level;

    public NavigationController(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        roomBlueprintLoader = new BasicRoomBlueprintLoader();
        view = new NavigationView(this);
        view.init(gc, sbg);

        level = 1;
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException{
        Pool<RoomBlueprint> roomBlueprintPool = new Pool<>(roomBlueprintLoader.getRoomBlueprints(level));
        left = roomBlueprintPool.get().buildRoom();
        right = roomBlueprintPool.get().buildRoom();
        view.setLeftImage(left.getNavigationImage(), left.getNavigationImageHover());
        view.setRightImage(right.getNavigationImage(), right.getNavigationImageHover());

        level++;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        view.render(gc, g);
    }

    public Room getActiveRoom(){
        return activeRoom;
    }

    public void reset(){
        level = 1;
    }

    public void componentActivated(AbstractComponent c){
        if(view.getBossButton().equals(c)) {
            try {
                activeRoom = new Room(Main.FIGHT, MobCreator.getMob("Dr.Moreau", 100),
                        ResourceLoader.getImage("null"), null);
            } catch (SlickException e) {e.printStackTrace();}
        }
        if(view.getLeft().equals(c))
            activeRoom = left;
        else if(view.getRight().equals(c))
            activeRoom = right;

        main.enterState(Main.FIGHT);
    }
}
