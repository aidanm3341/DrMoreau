package navigation;

import main.Main;
import main.MainController;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import util.Button;
import util.ResourceLoader;

public class ConfirmationPanel extends Screen implements ComponentListener {

    private MainController main;
    private Button confirmButton, cancelButton;

    public int getID() {
        return Main.CONFIRM;
    }

    public ConfirmationPanel(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);

        confirmButton = new Button("Confirm", ResourceLoader.getImage("basicButton"), gc.getWidth()*0.3f, gc.getHeight()/2);
        confirmButton.init(gc);
        confirmButton.addListener(this);
        confirmButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        confirmButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));

        cancelButton = new Button("Cancel", ResourceLoader.getImage("basicButton"), gc.getWidth()*0.66f, gc.getHeight()/2);
        cancelButton.init(gc);
        cancelButton.addListener(this);
        cancelButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        cancelButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);

        g.setFont(gc.getDefaultFont());
        g.setColor(new Color(227, 255, 86));
        g.drawString("Are you SURE you", gc.getWidth()/2 - 570, 110);
        g.drawString("wish to proceed?", gc.getWidth()/2 - 470, 200);

        confirmButton.render(gc, g);
        cancelButton.render(gc, g);
    }

    public void componentActivated(AbstractComponent c) {
        if(confirmButton.equals(c))
            main.enterState(Main.FIGHT);
        else if(cancelButton.equals(c))
            main.enterState(Main.TRAVEL);
    }
}
