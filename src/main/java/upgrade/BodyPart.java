package upgrade;

public class BodyPart {

    private String name, type;
    private int dmg, hp;

    public BodyPart(String name, String type, int dmg, int hp){
        this.name = name;
        this.type = type;
        this.dmg = dmg;
        this.hp = hp;
    }

    public String getName(){return name;}

    public String getType(){return type;}

    public int getDmg(){return dmg;}

    public int getHp(){return hp;}

}
