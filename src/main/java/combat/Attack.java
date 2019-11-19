package combat;


public class Attack {

    private String name;
    private float multipler, additive, base;

    public Attack(String name, float base, float multiplier, float additive)
    {
        this.name = name;
        this.base = base;
        this.multipler = multiplier;
        this.additive = additive;
    }

    public String getName(){
        return name;
    }

    public float getDmg() {
        return (base * multipler) + additive;
    }
}
