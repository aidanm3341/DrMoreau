package combat;

import org.newdawn.slick.Image;
import upgrade.BodyPart;

import java.util.ArrayList;

public class Mob {

    private String name;
    private int hp, attStat, defStat;
    private ArrayList<BodyPart> parts;
    private Image mobImage;

    public Mob(String name, int hp, int attStat, int defStat, ArrayList<BodyPart> parts, Image image)
    {
        this.name = name;
        this.hp = hp;
        this.attStat = attStat;
        this.defStat = defStat;
        this.parts = parts;
        this.mobImage = image;
    }

    public String getName(){return name;}

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
