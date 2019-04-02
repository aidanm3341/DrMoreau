package navigation;

import combat.Mob;
import org.newdawn.slick.Image;
import upgrade.bodyparts.BodyPart;

import java.util.ArrayList;

public class Room {

    public static final int BATTLE = 0, TREASURE = 1;

    private int type;
    private Image navigationImage;
    private Mob mob;
    private ArrayList<BodyPart> rewards;

    public Room(int type, Mob mob)
    {
        this.type = type;
        switch(type)
        {
            case BATTLE:
        }
        this.mob = mob;
        //rewards = mob.getParts().clone();
    }

}
