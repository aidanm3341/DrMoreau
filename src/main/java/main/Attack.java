package main;

public class Attack {

    private String name;
    private float dmg;

    public Attack(String name, float dmg)
    {
        this.name = name;
        this.dmg = dmg;
    }

    public String getName(){
        return name;
    }

    public float getDmg() {
        return dmg;
    }
}
