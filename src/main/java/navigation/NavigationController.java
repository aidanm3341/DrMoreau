package navigation;

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

public class NavigationController extends Screen implements ComponentListener {
    public int getID() {
        return Main.TRAVEL;
    }

    private MainController main;
    private NavigationView view;
    private Pool<String> themes;
    private Room left, right, activeRoom;

    public NavigationController(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        view = new NavigationView(this);
        view.init(gc, sbg);
        themes = new Pool<>();
        themes.add("red");
        themes.add("grey");
        activeRoom = RoomBuilder.buildRoom("grey");
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException{
        left = RoomBuilder.buildRoom(themes.get());
        right = RoomBuilder.buildRoom(themes.get());
        view.setLeftImage(left.getNavigationImage(), left.getNavigationImageHover());
        view.setRightImage(right.getNavigationImage(), right.getNavigationImageHover());
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        view.render(gc, g);
    }

    public Room getActiveRoom(){
        return activeRoom;
    }

    public void componentActivated(AbstractComponent c) {
        if(view.getLeft().equals(c))
            activeRoom = left;
        else if(view.getRight().equals(c))
            activeRoom = right;

        main.enterState(Main.CONFIRM);
    }
}
