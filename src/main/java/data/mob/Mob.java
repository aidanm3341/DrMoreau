package data.mob;

import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.stats.Stats;
import data.framework.IBodyPart;
import data.framework.PartType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mob implements MobObserver{

    private String name;
    private Stats stats;
    private Map<PartType, IBodyPart> parts;
    private List<Effect> effects;

    public Mob(String name, Map<PartType, IBodyPart> parts) {
        this.name = name;
        this.parts = parts;

        effects = new ArrayList<>();

        stats = new Stats();
        for(IBodyPart part : parts.values()) {
            Stats partStats = part.getStats();
            for(Stat stat : Stat.values())
                stats.addModifier(stat, partStats.get(stat));
        }
    }

    public String getName(){return name;}

    public void putPart(PartType type, IBodyPart part){
        parts.put(type, part);
        updateMaxHp();
    }

    private void updateMaxHp() {
        float newHp = 0;
        for(IBodyPart part : parts.values())
            newHp += part.getStats().get(Stat.MAX_HP);

        stats.put(Stat.MAX_HP, newHp);
        stats.put(Stat.CURRENT_HP, newHp);
    }

    public void updateEffects(){
        effects.forEach(Effect::resolveEndOfTurn);
        effects = effects.stream().filter(eff -> !eff.isComplete()).collect(Collectors.toList());
    }

    public void applyEffect(Effect effect){
        effects.add(effect);
    }

    public void clearEffects(){
        effects.clear();
    }

    public float getStat(Stat stat){
        return stats.get(stat);
    }

    public void setStat(Stat stat, float value){
        stats.put(stat, value);
    }

    public IBodyPart getPart(PartType part){
        return parts.get(part);
    }

    public boolean hasPart(PartType type){
        return parts.containsKey(type);
    }

    public void addObserver(MobObserver observer){
        stats.addListener(observer);
        stats.notifyListeners();
    }

    @Override
    public void update(Stats stats) {
        this.stats = stats;
    }
}
