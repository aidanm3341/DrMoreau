package navigation;

import combat.Mob;
import combat.MobData;
import main.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.AbstractBodyPart;
import upgrade.bodyparts.BodyPart;
import util.Pool;
import util.ResourceLoader;

import java.util.ArrayList;

public class RoomBuilder {

    private static Pool<Mob> red, grey;
    private static Pool<BodyPart> treasure;

    public static Room buildRoom(String theme, int level) throws SlickException{
        red = new Pool<>();
        grey = new Pool<>();
        treasure = new Pool<>();
        red.add(MobData.getMob("dog", level));
        //red.add(MobData.getMob("elephant", level));
        //red.add(MobData.getMob("lion", level));

        grey.add(MobData.getMob("rat", level));
        //grey.add(MobData.getMob("dog", level));
        //grey.add(MobData.getMob("beaver", level));

        //treasure.add(PartFactory.getPart("bull_head", level));
        //treasure.add(PartFactory.getPart("burning_arm", level));
        //treasure.add(PartFactory.getPart("frozen_leg", level));
        //treasure.add(PartFactory.getPart("golden_monkey_arm", level));

        int type;
        Image navigationImage;
        Mob mob;
        Pool<AbstractBodyPart> parts = new Pool<>();
        ArrayList<AbstractBodyPart> rewards;

        switch (theme) {
            default:
            case "red":
                navigationImage = ResourceLoader.getImage("brickRoute");
                mob = red.get();
                break;
            case "grey":
                navigationImage = ResourceLoader.getImage("greyRoute");
                mob = grey.get();
        }

        //if(rand.nextInt(10) > 1) {
            type = Main.FIGHT;
            parts.addAll(mob.getParts());
            rewards = parts.popX(3);
        //}
        //else {
        //    type = Room.TREASURE;
        //    rewards = treasure.popX(3);
        //}

        return new Room(type, mob, navigationImage, rewards);
    }
}
