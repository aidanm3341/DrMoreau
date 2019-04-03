package navigation;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import util.MyFont;
import util.ResourceLoader;

import java.awt.*;
import java.io.IOException;

public class NavigationView {

    private NavigationController ctrl;
    private MouseOverArea left, right;
    private Image border;
    private UnicodeFont font;

    public NavigationView(NavigationController ctrl){
        this.ctrl = ctrl;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        try {
            font = MyFont.createFont(50);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        left = new MouseOverArea(gc, ResourceLoader.getImage("brickRoute"), 110, 180);
        left.addListener(ctrl);
        right = new MouseOverArea(gc, ResourceLoader.getImage("greyRoute"), gc.getWidth()/2 + 80, 180);
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
        g.drawString("Which Way?", gc.getWidth()/2 - 175, gc.getHeight() - 150);
    }
}
