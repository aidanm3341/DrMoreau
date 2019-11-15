package upgrade;

import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.draganddrop.DragArea;
import screens.draganddrop.PartDraggable;
import util.Button;
import util.ResourceLoader;

public class UpgradeView {

    private UpgradeController ctrl;

    private Image puddle;
    private Button nextButton;

    public UpgradeView(UpgradeController ctrl) {
        this.ctrl = ctrl;
    }

    public void init(GameContainer gc){
        nextButton = new Button("Next", ResourceLoader.getImage("basicButton"), Main.WIDTH - 150, Main.HEIGHT - 75);
        nextButton.init(gc);
        nextButton.addListener(ctrl);
        nextButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        nextButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));

        puddle = ResourceLoader.getImage("upgradePuddle");
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.drawImage(puddle, Main.WIDTH/2, 100);
        for(DragArea d : ctrl.getDragAreas())
            d.render(gc, g);
        for(PartDraggable d : ctrl.getDraggables())
            d.render(gc, g);

        nextButton.render(gc, g);
    }
}
