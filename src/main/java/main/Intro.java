package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import util.ResourceLoader;

public class Intro extends Screen implements ComponentListener {
    public int getID() { return Main.INTRO; }

    private MainController main;
    private MouseOverArea intro;

    public Intro(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) {
        intro = new MouseOverArea(gc, ResourceLoader.getImage("intro"), 0, 0);
        intro.addListener(this);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        intro.render(gc, g);
    }

    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.TRAVEL);
    }
}
