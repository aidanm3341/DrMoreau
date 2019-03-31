package upgrade;

import org.newdawn.slick.Image;

public class BodyPart {

    private String type;
    private int dmg, hp;
    private Image image;

    public BodyPart(String type, Image image, int dmg, int hp){
        this.type = type;
        this.image = image;
        this.dmg = dmg;
        this.hp = hp;
    }

    public Image getImage() {
        return image;
    }
}
