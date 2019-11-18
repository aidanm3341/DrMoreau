package data;

import data.framework.RoomBlueprintLoader;
import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class BasicRoomBlueprintLoader implements RoomBlueprintLoader {
    public List<RoomBlueprint> getRoomBlueprints() throws SlickException {
        List<RoomBlueprint> rooms = new ArrayList<>();
        rooms.add(redRoom());
        rooms.add(greyRoom());
        return rooms;
    }

    private RoomBlueprint redRoom() throws SlickException {
        List<Mob> mobs = new ArrayList<>();
        mobs.add(MobData.getMob("dog", 1));
        return new RoomBlueprint(mobs, ResourceLoader.getImage("brickRoute"));
    }

    private RoomBlueprint greyRoom() throws SlickException {
        List<Mob> mobs = new ArrayList<>();
        mobs.add(MobData.getMob("rat", 1));
        return new RoomBlueprint(mobs, ResourceLoader.getImage("greyRoute"));
    }
}
