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

public class NavigationController extends Screen implements ComponentListener {
    public int getID() {
        return Main.TRAVEL;
    }

    private MainController main;
    private NavigationView view;

    public NavigationController(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        view = new NavigationView(this);
        view.init(gc, sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        view.render(gc, g);
    }

    public void componentActivated(AbstractComponent c) {
        main.enterState(Main.CONFIRM);
    }
}
