package navigation;

import combat.Mob;
import combat.MobData;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.BodyPart;
import upgrade.bodyparts.PartFactory;
import util.Pool;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.Random;

public class RoomBuilder {

    private static Pool<Mob> red, grey;
    private static Pool<BodyPart> treasure;

    public static Room buildRoom(String theme) throws SlickException{
        red = new Pool<>();
        grey = new Pool<>();
        treasure = new Pool<>();
        red.add(MobData.getMob("bunny"));
        red.add(MobData.getMob("elephant"));
        red.add(MobData.getMob("lion"));
        //grey.add(MobData.getMob("penguin"));
        grey.add(MobData.getMob("rat"));
        grey.add(MobData.getMob("dog"));
        grey.add(MobData.getMob("beaver"));

        treasure.add(PartFactory.getPart("bull_head"));
        treasure.add(PartFactory.getPart("burning_arm"));
        treasure.add(PartFactory.getPart("frozen_leg"));
        treasure.add(PartFactory.getPart("golden_monkey_arm"));

        int type;
        Random rand = new Random();
        Image navigationImage;
        Mob mob;
        Pool<BodyPart> parts = new Pool<>();
        ArrayList<BodyPart> rewards;

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

        if(rand.nextInt(10) > 2) {
            type = Room.BATTLE;
            parts.addAll(mob.getParts());
            rewards = parts.popX(3);
        }
        else {
            type = Room.TREASURE;
            rewards = treasure.popX(3);
        }

        return new Room(type, theme, mob, navigationImage, rewards);
    }
}
