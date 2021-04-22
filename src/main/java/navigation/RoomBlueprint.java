package navigation;

import data.mob.MobCombatData;
import data.framework.IBodyPart;
import data.framework.PartType;
import main.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.Pool;

import java.util.List;
import java.util.Random;

public class RoomBlueprint {
    private List<MobCombatData> possibleMobCombatData;
    private Image image;

    public RoomBlueprint(List<MobCombatData> mobCombatData, Image image){
        this.possibleMobCombatData = mobCombatData;
        this.image = image;
    }

    public Room buildRoom() throws SlickException {
        MobCombatData mobCombatData = possibleMobCombatData.get(new Random().nextInt(possibleMobCombatData.size()));
        Pool<IBodyPart> parts = new Pool<>();
        for(PartType part : PartType.values())
            parts.add(mobCombatData.getPart(part));

        return new Room(
                Main.FIGHT,
                mobCombatData,
                image,
                parts.popX(3)
        );
    }
}
