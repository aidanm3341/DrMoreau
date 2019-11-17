package screens;

import main.Main;
import main.MainController;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import util.buttons.Button;
import util.ResourceLoader;

public class MainMenu extends Screen implements ComponentListener {

    private MainController main;
    private Button startButton;
    public int getID() {
        return Main.MAINMENU;
    }

    public MainMenu(MainController main)
    {
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);

        startButton = new Button("Start", ResourceLoader.getImage("menuButton"), Main.WIDTH/2, Main.HEIGHT/2);
        startButton.init(gc);
        startButton.addHoverOverImage(ResourceLoader.getImage("menuButtonHover"));
        startButton.addListener(this);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);

        g.setFont(gc.getDefaultFont());
        g.setColor(new Color(227, 255, 86));
        g.drawString("Dr. Moreau", Main.WIDTH/2 - 315, 150);

        startButton.render(gc, g);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException { }



    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.INTROTXT);
    }
}