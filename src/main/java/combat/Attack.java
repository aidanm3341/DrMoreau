package combat;


import combat.animation.Animation;

public class Attack {

    private String name;
    private float multiplier, additive, base;
    private Animation animation;

    public Attack(String name, float base, float multiplier, float additive, Animation animation)
    {
        this.name = name;
        this.base = base;
        this.multiplier = multiplier;
        this.additive = additive;
        this.animation = animation;
    }

    public String getName(){
        return name;
    }

    public float getDmg() {
        return (base * multiplier) + additive;
    }

    public Animation getAnimation(){
        return animation.clone();
    }
}
