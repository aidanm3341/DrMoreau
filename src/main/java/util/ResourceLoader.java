package util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ResourceLoader {

    private static HashMap<String, Image> images;

    public static void loadImages() throws SlickException
    {
        images = new HashMap<>();
        images.put("dog_leg", new Image("dog_leg.png"));
        images.put("dog_arm", new Image("dog_arm.png"));
        images.put("dog_head", new Image("dog_head.png"));
        images.put("dog_body", new Image("dog_body.png"));
        images.put("dog_tail", new Image("dog_tail.png"));
        images.put("ostrich_head", new Image("ostrich_head.png"));
        images.put("blue_leg", new Image("blue_leg.png"));
        images.put("button1", new Image("button.png"));
        images.put("button2", new Image("button2.png"));
        images.put("basicButton", new Image("basicButton.png"));
        images.put("basicButtonHover", new Image("basicButtonHover.png"));
        images.put("basicButtonPressed", new Image("basicButtonPressed.png"));

        images.put("brickRoute", new Image("brickRoute.png"));
        images.put("brickRouteHover", new Image("brickRouteHover.png"));
        images.put("greyRoute", new Image("greyRoute.png"));
        images.put("greyRouteHover", new Image("greyRouteHover.png"));
        images.put("travelBorder", new Image("travelBorder.png"));
    }

    public static Image getImage(String name)
    {
        return images.get(name);
    }
}
