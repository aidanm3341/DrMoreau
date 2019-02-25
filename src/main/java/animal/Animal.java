package animal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

public class Animal {

    private Body body;
    private Part head, armLeft, armRight, legLeft, legRight, tail;

    public Animal(Body body)
    {
        this.body = body;
    }

    public void attachHead(Part p) {
        body.attachHead(p);
        head = p;
    }

    public void attachArmLeft(Part p) {
        body.attachArmLeft(p);
        armLeft = p;
    }

    public void attachArmRight(Part p) {
        body.attachArmRight(p);
        armRight = p;
    }

    public void attachLegLeft(Part p) {
        body.attachLegLeft(p);
        legLeft= p;
    }

    public void attachLegRight(Part p) {
        body.attachLegRight(p);
        legRight = p;
    }

    public void attachTail(Part p) {
        body.attachTail(p);
        tail = p;
    }

    public void render(GameContainer gc, Graphics g)
    {
        legLeft.render(gc, g);
        armLeft.render(gc, g);
        body.render(gc, g);
        armRight.render(gc, g);
        legRight.render(gc, g);
        tail.render(gc, g);
        head.render(gc, g);
    }


    public static Animal createDefaultAnimal() throws SlickException {
        Animal animal = new Animal(new Body(300, 400, ResourceLoader.getImage("dog_body")));//(Body) PartFactory.getPart("dog_body"));

        animal.attachLegLeft(PartFactory.getPart("dog_leg"));
        animal.attachArmLeft(PartFactory.getPart("dog_arm"));
        animal.attachHead(PartFactory.getPart("ostrich_head"));
        animal.attachArmRight(PartFactory.getPart("dog_arm"));
        animal.attachLegRight(PartFactory.getPart("dog_leg"));
        animal.attachTail(PartFactory.getPart("dog_tail"));

        return animal;
    }
}
