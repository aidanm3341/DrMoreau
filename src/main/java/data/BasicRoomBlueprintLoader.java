package data;

import data.framework.RoomBlueprintLoader;
import data.mob.Mob;
import data.mob.MobCreator;
import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class BasicRoomBlueprintLoader implements RoomBlueprintLoader {
    public List<RoomBlueprint> getRoomBlueprints() throws SlickException {
        return List.of(
                redRoom(),
                greyRoom()
        );
    }

    private RoomBlueprint redRoom() throws SlickException {
        List<Mob> mobs = List.of(
                MobCreator.getMob("dog", 1)
//                MobCreator.getMob("bunny", 1),
//                MobCreator.getMob("elephant", 1)
        );
        return new RoomBlueprint(mobs, ResourceLoader.getImage("brickRoute"));
    }

    private RoomBlueprint greyRoom() throws SlickException {
        List<Mob> mobs = List.of(
                MobCreator.getMob("rat", 1)
//                MobCreator.getMob("boar", 1),
//                MobCreator.getMob("penguin", 1)
        );
        return new RoomBlueprint(mobs, ResourceLoader.getImage("greyRoute"));
    }
}
