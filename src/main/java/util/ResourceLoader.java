package util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ResourceLoader {

    private static HashMap<String, Image> images;

    public static void loadImages() throws SlickException
    {
        images = new HashMap<>();

        loadParts();
        loadGUI();
        loadNavigation();

        images.put("null", new Image("null.png"));
    }

    private static void loadGUI() throws SlickException {
        images.put("menuButton", new Image("gui/menuButton.png"));
        images.put("menuButtonHover", new Image("gui/menuButtonHover.png"));
        images.put("basicButton", new Image("gui/basicButton.png"));
        images.put("basicButtonHover", new Image("gui/basicButtonHover.png"));
        images.put("basicButtonPressed", new Image("gui/basicButtonPressed.png"));
        images.put("upgradePuddle", new Image("gui/upgradePuddle.png"));
        images.put("battleBackground", new Image("gui/background.png"));
    }

    private static void loadNavigation() throws SlickException {
        images.put("brickRoute", new Image("travel/brickRoute.png"));
        images.put("brickRouteHover", new Image("travel/brickRouteHover.png"));
        images.put("greyRoute", new Image("travel/greyRoute.png"));
        images.put("greyRouteHover", new Image("travel/greyRouteHover.png"));
        images.put("travelBorder", new Image("travel/travelBorder.png"));
        images.put("travelHover", new Image("travel/travelHover.png"));
    }

    private static void loadParts() throws SlickException {
        loadDog();
        loadRat();
        loadBunny();
        loadBoar();
        loadDuck();
        loadElephant();
        loadGoat();
        loadLion();
        loadSquid();
        loadMisc();

        images.put("ostrich_head", new Image("parts/ostrich_head.png"));
    }

    private static void loadDog() throws SlickException {
        images.put("dog_leg", new Image("parts/dog/dog_leg.png"));
        images.put("dog_arm", new Image("parts/dog/dog_arm.png"));
        images.put("dog_head", new Image("parts/dog/dog_head.png"));
        images.put("dog_body", new Image("parts/dog/dog_body.png"));
        images.put("dog_tail", new Image("parts/dog/dog_tail.png"));
    }
    private static void loadRat() throws SlickException {
        images.put("rat_leg", new Image("parts/rat/rat_leg.png"));
        images.put("rat_arm", new Image("parts/rat/rat_arm.png"));
        images.put("rat_head", new Image("parts/rat/rat_head.png"));
        images.put("rat_body", new Image("parts/rat/rat_body.png"));
        images.put("rat_tail", new Image("parts/rat/rat_tail.png"));
    }
    private static void loadBunny() throws SlickException {
        images.put("bunny_body", new Image("parts/bunny/bunny_body.png"));
        images.put("bunny_leg", new Image("parts/bunny/bunny_leg.png"));
        images.put("bunny_arm", new Image("parts/bunny/bunny_arm.png"));
        images.put("bunny_tail", new Image("parts/bunny/bunny_tail.png"));
        images.put("bunny_head", new Image("parts/bunny/bunny_head.png"));
    }

    private static void loadBoar() throws SlickException {
        images.put("boar_body", new Image("parts/boar/boar_body.png"));
        images.put("boar_forelimb", new Image("parts/boar/boar_arm.png"));
        images.put("boar_leg", new Image("parts/boar/boar_leg.png"));
        images.put("boar_tail", new Image("parts/boar/boar_tail.png"));
        images.put("boar_head", new Image("parts/boar/boar_head.png"));
    }

    private static void loadDuck() throws SlickException {
        images.put("duck_body", new Image("parts/duck/duck_body.png"));
        images.put("duck_leg", new Image("parts/duck/duck_leg.png"));
        images.put("duck_head", new Image("parts/duck/DuckHead.png"));
    }

    private static void loadElephant() throws SlickException {
        images.put("elephant_body", new Image("parts/elephant/Elephant_body.png"));
        images.put("elephant_leg", new Image("parts/elephant/Elephant_leg.png"));
        images.put("elephant_head", new Image("parts/elephant/Elephant.png"));
    }

    private static void loadGoat() throws SlickException {
        images.put("goat_body", new Image("parts/goat/Goat_body.png"));
        images.put("goat_leg", new Image("parts/goat/goat_leg.png"));
        images.put("goat_head", new Image("parts/goat/Goat.png"));
    }

    private static void loadLion() throws SlickException {
        images.put("lion_body", new Image("parts/lion/Lion_body.png"));
        images.put("lion_leg", new Image("parts/lion/Lion_leg.png"));
        images.put("lion_head", new Image("parts/lion/Lion.png"));
    }

    private static void loadSquid() throws SlickException {
        images.put("squid_body", new Image("parts/squid/squid_body.png"));
        images.put("squid_left_leg", new Image("parts/squid/squid_left_legs.png"));
        images.put("squid_right_leg", new Image("parts/squid/squid_right_legs.png"));
    }



    private static void loadMisc() throws SlickException{}

    public static Image getImage(String name)
    {
        return images.get(name);
    }
}
