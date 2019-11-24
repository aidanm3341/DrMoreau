package navigation;

import main.Main;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.Button;

public class NavigationView {

    private NavigationController ctrl;
    private MouseOverArea left, right;
    private Button bossButton;
    private Image border;
    private UnicodeFont font;

    public NavigationView(NavigationController ctrl){
        this.ctrl = ctrl;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        font = MyFont.createFont(50);

        bossButton = new Button("BOSS", ResourceLoader.getImage("basicButton"), Main.WIDTH/2, 40);
        bossButton.init(gc);
        bossButton.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        bossButton.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
        bossButton.addListener(ctrl);

        left = new MouseOverArea(gc, ResourceLoader.getImage("brickRoute"), 110, 180);
        left.addListener(ctrl);
        right = new MouseOverArea(gc, ResourceLoader.getImage("greyRoute"), Main.WIDTH/2 + 80, 180);
        right.addListener(ctrl);
        border = ResourceLoader.getImage("travelBorder");
    }

    public void setLeftImage(Image leftNormal, Image leftHover){
        left.setNormalImage(leftNormal);
        left.setMouseOverImage(leftHover);
        left.setMouseDownImage(leftHover);
    }

    public void setRightImage(Image rightNormal, Image rightHover){
        right.setNormalImage(rightNormal.getFlippedCopy(true, false));
        right.setMouseOverImage(rightHover.getFlippedCopy(true, false));
        right.setMouseDownImage(rightHover.getFlippedCopy(true, false));
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        left.render(gc, g);
        right.render(gc, g);
        g.drawImage(border, 0, 0);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Which Way?", Main.WIDTH/2 - 175, Main.HEIGHT - 150);
        bossButton.render(gc, g);
    }

    public MouseOverArea getLeft() {
        return left;
    }

    public MouseOverArea getRight() {
        return right;
    }

    public Button getBossButton() {
        return bossButton;
    }
}
