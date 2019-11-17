package navigation;

import combat.Mob;
import data.framework.BodyPart;
import main.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.Pool;

import java.util.List;
import java.util.Random;

public class RoomBlueprint {
    private List<Mob> possibleMobs;
    private Image image;

    public RoomBlueprint(List<Mob> mobs, Image image){
        this.possibleMobs = mobs;
        this.image = image;
    }

    public Room buildRoom() throws SlickException {
        Mob mob = possibleMobs.get(new Random().nextInt(possibleMobs.size()));
        Pool<BodyPart> parts = new Pool<>();
        parts.addAll(mob.getParts());

        return new Room(
                Main.FIGHT,
                mob,
                image,
                parts.popX(3)
        );
    }
}
