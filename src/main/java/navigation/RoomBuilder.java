package navigation;

import combat.Mob;
import org.newdawn.slick.Image;
import util.Pool;
import util.ResourceLoader;

import java.util.Random;

public class RoomBuilder {

    private Pool<Mob> red, grey;

    public RoomBuilder()
    {
        red = new Pool<Mob>();
        //red.add();
    }

    public Room buildRoom(String theme) {
        int type;
        Random rand = new Random();
        Image navigationImage;
        Mob mob;


        if(rand.nextInt(10) < 5)
            type = Room.BATTLE;
        else
            type = Room.TREASURE;

        switch (theme) {
            case "red":
                navigationImage = ResourceLoader.getImage("brick_route");
                //mob = red.getX(1);
                break;
            case "grey":
                navigationImage = ResourceLoader.getImage("grey_route");
        }

        return null;//new Room(type, theme, );
    }
}
