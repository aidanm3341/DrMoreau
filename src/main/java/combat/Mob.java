package combat;

import data.framework.BodyPart;
import data.framework.PartType;

import java.util.Map;

public class Mob {

    private String name;
    private float currentHp, maxHp, attStat, defStat;
    private Map<PartType, BodyPart> parts;

    public Mob(String name, int hp, int attStat, int defStat, Map<PartType, BodyPart> parts) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = maxHp;
        this.attStat = attStat;
        this.defStat = defStat;
        this.parts = parts;
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

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }
}
