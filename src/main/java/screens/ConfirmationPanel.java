package screens;

import main.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import util.Button;
import util.ResourceLoader;

public class ConfirmationPanel extends Screen implements ComponentListener {

    private Button confirmButton, cancelButton;

    public int getID() {
        return Main.CONFIRM;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);

        confirmButton = new Button("Confrim", ResourceLoader.getImage("basicButton"), gc.getWidth()*0.25f, gc.getHeight()/2);
        confirmButton.init(gc);
        confirmButton.addListener(this);
        confirmButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        confirmButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));

        cancelButton = new Button("Cancel", ResourceLoader.getImage("basicButton"), gc.getWidth()*0.50f, gc.getHeight()/2);
        cancelButton.init(gc);
        cancelButton.addListener(this);
        cancelButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        cancelButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);

        g.setFont(gc.getDefaultFont());
        g.setColor(new Color(227, 255, 86));
        g.drawString("Do you wish to proceed?", gc.getWidth()/2 - 600, 150);

        confirmButton.render(gc, g);
        cancelButton.render(gc, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void componentActivated(AbstractComponent abstractComponent) {
        enterState(Main.UPGRADE);
    }
}
