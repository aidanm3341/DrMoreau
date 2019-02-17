package screens;

import animal.Animal;
import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;
import util.Button;
import util.ResourceLoader;

import org.newdawn.slick.gui.ComponentListener;


public class Fight extends Screen implements ComponentListener {

    private Animal animal;
    private Button basicButton;
    public int getID() {
        return Main.FIGHT;
    }


    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        animal = Animal.createDefaultAnimal();

        basicButton = new Button("Win", ResourceLoader.getImage("basicButton"), gc.getWidth()*0.75f, gc.getHeight()/2);
        basicButton.init(gc);
        basicButton.addListener(this);
        basicButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        basicButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);
        animal.render(gc, g);

        basicButton.render(gc, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void componentActivated(AbstractComponent abstractComponent) {
        enterState(Main.TRAVEL);
    }
}
