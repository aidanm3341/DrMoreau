package data.loaders;

import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;

import java.util.List;

public interface RoomBlueprintLoader {
    List<RoomBlueprint> getRoomBlueprints(int level) throws SlickException;
}
