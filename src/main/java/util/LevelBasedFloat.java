package util;

public class LevelBasedFloat {

    private float level, multiplier;
    private int additive;

    public LevelBasedFloat(float level){
        this.level = level;
        multiplier = 1;
        additive = 0;
    }

    public LevelBasedFloat(float level, float multiplier){
        this.level = level;
        this.multiplier = multiplier;
        additive = 0;
    }

    public LevelBasedFloat(float level, int additive){
        this.level = level;
        multiplier = 1;
        this.additive = additive;
    }

    public LevelBasedFloat(float level, float multiplier, int additive) {
        this.level = level;
        this.multiplier = multiplier;
        this.additive = additive;
    }

    public float getVal() {
        return (level * multiplier) + additive;
    }
}
