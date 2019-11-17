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

public class GameOver extends Screen implements ComponentListener {

    private MainController main;
    private Button respawnButton, quitButton;

    public int getID() {
        return Main.GAMEOVER;
    }

    public GameOver(MainController main){
        this.main = main;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);

        respawnButton = new Button("Respawn", ResourceLoader.getImage("basicButton"), Main.WIDTH*0.3f, Main.HEIGHT/2);
        respawnButton.init(gc);
        respawnButton.addListener(this);
        respawnButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        respawnButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));

        quitButton = new Button("Quit", ResourceLoader.getImage("basicButton"), Main.WIDTH*0.66f, Main.HEIGHT/2);
        quitButton.init(gc);
        quitButton.addListener(this);
        quitButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        quitButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);

        g.setFont(gc.getDefaultFont());
        g.setColor(new Color(255, 0, 0));
        g.drawString("GAME OVER", Main.WIDTH/2 - 420, 110);

        respawnButton.render(gc, g);
        quitButton.render(gc, g);
    }

    public void componentActivated(AbstractComponent c) {
        if(respawnButton.equals(c)) {
            try { main.reset(); } catch (SlickException e) { }
            main.enterState(Main.MAINMENU);
        }
        else if(quitButton.equals(c))
            System.exit(0);
    }
}
