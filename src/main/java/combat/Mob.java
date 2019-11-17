package combat;

import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import upgrade.bodyparts.BodyConcreteBodyPart;
import upgrade.bodyparts.BodyConnectors;
import upgrade.bodyparts.NullBodyPart;
import util.Point;
import util.SuperImage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Mob {

    private String name;
    private float currentHp, maxHp, attStat, defStat;
    private Map<PartType, BodyPart> parts;
    private SuperImage mobImage;
    private MobView view;

    public Mob(String name, int hp, int attStat, int defStat, Map<PartType, BodyPart> parts, SuperImage image) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = maxHp;
        this.attStat = attStat;
        this.defStat = defStat;
        this.parts = parts;
        this.mobImage = image;

        constructView();
    }

    private void constructView(){
        this.view = new MobView((BodyConcreteBodyPart) parts.get(PartType.BODY), 1300, 510);
        parts.remove(PartType.BODY);

        for(PartType type : parts.keySet()){
            view.addPart(type, parts.get(type));
        }
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

    public Collection<BodyPart> getParts() {
        return parts.values();
    }

    public void render(GameContainer gc, Graphics g){
        view.render(gc, g);
    }
}
