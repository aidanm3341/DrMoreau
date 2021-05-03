package data.loaders;

import data.loaders.RoomBlueprintLoader;
import data.mob.MobCombatData;
import data.mob.MobCreator;
import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

import java.util.List;

public class BasicRoomBlueprintLoader implements RoomBlueprintLoader {
    public List<RoomBlueprint> getRoomBlueprints() throws SlickException {
        return List.of(
                redRoom(),
                greyRoom()
        );
    }

    private RoomBlueprint redRoom() throws SlickException {
        List<MobCombatData> mobCombatData = List.of(
                MobCreator.getMob("crocodile", 1)
//                MobCreator.getMob("bunny", 1),
//                MobCreator.getMob("elephant", 1)
        );
        return new RoomBlueprint(mobCombatData, ResourceLoader.getImage("brickRoute"));
    }

    private RoomBlueprint greyRoom() throws SlickException {
        List<MobCombatData> mobCombatData = List.of(
                MobCreator.getMob("rat", 1)
//                MobCreator.getMob("boar", 1),
//                MobCreator.getMob("penguin", 1)
        );
        return new RoomBlueprint(mobCombatData, ResourceLoader.getImage("greyRoute"));
    }
}
