package combat;


public class Attack {

    private String name;
    private float multipler;
    private int additive;
    private int level;

    public Attack(String name, int level, float multiplier, int additive)
    {
        this.name = name;
        this.level = level;
        this.multipler = multiplier;
        this.additive = additive;
    }

    public String getName(){
        return name;
    }

    public float getDmg() {
        return (level * multipler) + additive;
    }

    public Attack clone(int level)
    {
        return new Attack(name, level, multipler, additive);
    }
}
