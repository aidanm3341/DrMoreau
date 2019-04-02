package util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ResourceLoader {

    private static HashMap<String, Image> images;

    public static void loadImages() throws SlickException
    {
        images = new HashMap<>();
        // Parts
        images.put("dog_leg", new Image("parts/dog_leg.png"));
        images.put("dog_arm", new Image("parts/dog_arm.png"));
        images.put("dog_head", new Image("parts/dog_head.png"));
        images.put("dog_body", new Image("parts/dog_body.png"));
        images.put("dog_tail", new Image("parts/dog_tail.png"));
        images.put("ostrich_head", new Image("parts/ostrich_head.png"));
        images.put("blue_leg", new Image("parts/blue_leg.png"));
        images.put("dog_body", new Image("parts/dog_body.png"));

        // Gui
        images.put("menuButton", new Image("gui/menuButton.png"));
        images.put("menuButtonHover", new Image("gui/menuButtonHover.png"));
        images.put("basicButton", new Image("gui/basicButton.png"));
        images.put("basicButtonHover", new Image("gui/basicButtonHover.png"));
        images.put("basicButtonPressed", new Image("gui/basicButtonPressed.png"));
        images.put("upgradePuddle", new Image("gui/upgradePuddle.png"));

        // Travel
        images.put("brickRoute", new Image("travel/brickRoute.png"));
        images.put("brickRouteHover", new Image("travel/brickRouteHover.png"));
        images.put("greyRoute", new Image("travel/greyRoute.png"));
        images.put("greyRouteHover", new Image("travel/greyRouteHover.png"));
        images.put("travelBorder", new Image("travel/travelBorder.png"));


        images.put("null", new Image("null.png"));
    }

    public static Image getImage(String name)
    {
        return images.get(name);
    }
}
