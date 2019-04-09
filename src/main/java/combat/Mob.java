package combat;

import upgrade.bodyparts.BodyPart;
import util.SuperImage;

import java.util.ArrayList;

public class Mob {

    private String name;
    private float currentHp, maxHp, attStat, defStat;
    private ArrayList<BodyPart> parts;
    private SuperImage mobImage;

    public Mob(String name, int hp, int attStat, int defStat, ArrayList<BodyPart> parts, SuperImage image)
    {
        this.name = name;
        this.maxHp = hp;
        currentHp = maxHp;
        this.attStat = attStat;
        this.defStat = defStat;
        this.parts = parts;
        this.mobImage = image;
    }

    public String getName(){return name;}

    public void setHp(float dmgDealt){
        if(currentHp - dmgDealt < 0)
            currentHp = 0;
        else if(currentHp - dmgDealt > maxHp)
            currentHp = maxHp;
        else
            currentHp -= dmgDealt;
    }

    public float getCurrentHp(){
        return currentHp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public float getAttStat(){
        return attStat;
    }

    public float getDefStat(){
        return defStat;
    }

    public ArrayList<BodyPart> getParts() {
        return parts;
    }

    public SuperImage getMobImage() {
        return mobImage;
    }
}
