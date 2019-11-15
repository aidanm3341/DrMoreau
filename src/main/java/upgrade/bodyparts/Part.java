package upgrade.bodyparts;

import combat.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

import java.util.ArrayList;

public class Part {

    private String name;
    private PartType type;
    private int hp;
    private Image image;
    private Attack attack;

    private ArrayList<Connection> connections;
    private int level;

    public Part(String name, PartType type, Attack attack, int hp, ArrayList<Connection> connections, int level)
    {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.image = ResourceLoader.getImage(name);
        this.connections = connections;
        this.level = level;
    }

    public String getName(){return name;}

    public PartType getType(){return type;}

    public int getHp(){return hp;}

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public Image getImage() {
        return image;
    }

    public float getWidth(){
        return image.getWidth();
    }

    public float getHeight(){
        return image.getHeight();
    }

    public Attack getAttack() {
        return attack;
    }

    public int getLevel(){
        return level;
    }
}
