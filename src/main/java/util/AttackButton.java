package util;

import org.newdawn.slick.Image;

public class AttackButton extends Button{

    public AttackButton(String text, float x, float y) {
        super(text, ResourceLoader.getImage("basicButton"), x, y);
        this.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        this.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));
    }
}
