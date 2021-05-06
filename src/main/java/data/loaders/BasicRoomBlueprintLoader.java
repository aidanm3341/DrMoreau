package data.loaders;

import data.loaders.RoomBlueprintLoader;
import data.mob.MobCombatData;
import data.mob.MobCreator;
import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

import java.util.List;

public class BasicRoomBlueprintLoader implements RoomBlueprintLoader {
    public List<RoomBlueprint> getRoomBlueprints(int level) throws SlickException {
        return List.of(
                redRoom(level),
                greyRoom(level)
        );
    }

    private RoomBlueprint redRoom(int level) throws SlickException {
        List<MobCombatData> mobCombatData = List.of(
                MobCreator.getMob("crocodile", level)
//                MobCreator.getMob("bunny", 1),
//                MobCreator.getMob("elephant", 1)
        );
        return new RoomBlueprint(mobCombatData, ResourceLoader.getImage("brickRoute"));
    }

    private RoomBlueprint greyRoom(int level) throws SlickException {
        List<MobCombatData> mobCombatData = List.of(
                MobCreator.getMob("rat", level)
//                MobCreator.getMob("boar", 1),
//                MobCreator.getMob("penguin", 1)
        );
        return new RoomBlueprint(mobCombatData, ResourceLoader.getImage("greyRoute"));
    }
}
