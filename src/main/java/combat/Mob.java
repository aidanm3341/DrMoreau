package combat;

import org.newdawn.slick.Image;
import upgrade.BodyPart;

import java.util.ArrayList;

public class Mob {

    private String name;
    private int hp, attStat, defStat;
    private ArrayList<BodyPart> parts;
    private Image mobImage;

    public Mob(String name, Image image, int hp, ArrayList<BodyPart> parts)
    {
        this.name = name;
        this.mobImage = image;
        this.hp = hp;
        this.parts = parts;
    }

    public void setHp(int dmgDealt){
        hp -= dmgDealt;
    }

    public int getHp(){
        return hp;
    }

    public int getAttStat(){
        return attStat;
    }

    public int getDefStat(){
        return defStat;
    }

    public ArrayList<BodyPart> getParts() {
        return parts;
    }

    public Image getMobImage() {
        return mobImage;
    }
}
