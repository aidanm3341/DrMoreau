package upgrade;

import org.newdawn.slick.Image;

public class BodyPart {

    private String name, type;
    private int dmg, hp;
    private Image image;

    public BodyPart(String name, Image image, String type, int dmg, int hp){
        this.name = name;
        this.type = type;
        this.image = image;
        this.dmg = dmg;
        this.hp = hp;
    }

    public String getName(){return name;}

    public String getType(){return type;}

    public int getDmg(){return dmg;}

    public int getHp(){return hp;}


    public Image getImage() {
        return image;
    }
}
