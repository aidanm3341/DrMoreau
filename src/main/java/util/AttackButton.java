package util;

import org.newdawn.slick.GameContainer;

public class AttackButton extends Button{

    public AttackButton(String text, float x, float y) {
        super(text, ResourceLoader.getImage("basicButton"), x, y);
    }

    public void init(GameContainer gc)
    {
        super.init(gc);
        this.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        this.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }
}
