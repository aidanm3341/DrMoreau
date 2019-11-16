package data;

import navigation.RoomBlueprint;
import org.newdawn.slick.SlickException;

import java.util.List;

public interface RoomBlueprintLoader {
    List<RoomBlueprint> getRoomBlueprints() throws SlickException;
}
