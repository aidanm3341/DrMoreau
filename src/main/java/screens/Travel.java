package screens;

import main.Main;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import util.MyFont;
import util.ResourceLoader;

import java.awt.*;
import java.io.IOException;

public class Travel extends Screen implements ComponentListener {

    private MouseOverArea left, right;
    private Image border;
    private UnicodeFont font;

    public int getID() {
        return Main.TRAVEL;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);

        try {
            font = MyFont.createFont(50);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        left = new MouseOverArea(gc, ResourceLoader.getImage("brickRoute"), 110, 180);
        left.setMouseOverImage(ResourceLoader.getImage("brickRouteHover"));
        left.addListener(this);
        right = new MouseOverArea(gc, ResourceLoader.getImage("greyRoute"), gc.getWidth()/2 + 80, 180);
        right.setMouseOverImage(ResourceLoader.getImage("greyRouteHover"));
        right.addListener(this);
        border = ResourceLoader.getImage("travelBorder");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);
        left.render(gc, g);
        right.render(gc, g);
        g.drawImage(border, 0, 0);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Which Way?", gc.getWidth()/2 - 175, gc.getHeight() - 150);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        enterState(Main.FIGHT);
    }
}
