package main;

public class Attack {

    private String name;
    private int dmg;

    public Attack(String name, int dmg)
    {
        this.name = name;
        this.dmg = dmg;
    }

    public String getName(){
        return name;
    }

    public int getDmg() {
        return dmg;
    }
}
