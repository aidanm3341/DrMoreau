package combat;


public class Attack {

    private String name;
    private float multipler;
    private int additive;

    public Attack(String name, float multiplier, int additive)
    {
        this.name = name;
        this.multipler = multiplier;
        this.additive = additive;
    }

    public String getName(){
        return name;
    }

    public float getDmg(int level) {
        return (level * multipler) + additive;
    }
}
