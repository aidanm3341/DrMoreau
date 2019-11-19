package combat;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;

public class AbilityButton {

    private static final int WIDTH = 350, HEIGHT = 65;

    private MouseOverArea area;
    private float x, y;

    public AbilityButton(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void init(GameContainer gc) throws SlickException{
        Image baseImage = new Image(WIDTH, HEIGHT);
        baseImage.getGraphics().setColor(new Color(0, 0, 0, 0.8f));
        baseImage.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);

        Image hoverImage = new Image(WIDTH, HEIGHT);
        hoverImage.getGraphics().setColor(new Color(0, 0, 0, 1f));
        hoverImage.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);

        area = new MouseOverArea(gc, baseImage, (int) x, (int) y);
        area.setMouseOverImage(hoverImage);
    }

    public void render(GameContainer gc, Graphics g){
        area.render(gc, g);
    }
}
