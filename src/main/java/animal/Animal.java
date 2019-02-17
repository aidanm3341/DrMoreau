package animal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Comparator;

public class Animal {

    private Body body;
    private ArrayList<Part> parts;

    public Animal(Body body)
    {
        parts = new ArrayList<>();
        this.body = body;
        parts.add(body);
    }

    public void attach(Part p)
    {
        body.attach(p);
        parts.add(p);
        parts.sort(Comparator.comparingInt(p2 -> p2.type().getZIndex()));
    }

    public void render(GameContainer gc, Graphics g)
    {
        for(Part p : parts)
            p.render(gc, g);
    }


    public static Animal createDefaultAnimal() throws SlickException {
        Animal animal = new Animal(new Body(250, 350, new Image("dog_body.png")));

        animal.attach(PartFactory.getPart("dog_leg2"));
        animal.attach(PartFactory.getPart("dog_arm2"));
        animal.attach(PartFactory.getPart("ostrich_head"));
        animal.attach(PartFactory.getPart("dog_arm"));
        animal.attach(PartFactory.getPart("dog_leg"));
        animal.attach(PartFactory.getPart("dog_tail"));

        return animal;
    }
}
