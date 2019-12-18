package data.mob;

import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.stats.Stats;
import data.framework.BodyPart;
import data.framework.PartType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mob{

    private String name;
    private Stats stats;
    private Map<PartType, BodyPart> parts;
    private List<Effect> effects;

    public Mob(String name, Map<PartType, BodyPart> parts) {
        this.name = name;
        this.parts = parts;

        effects = new ArrayList<>();

        stats = new Stats();
        for(BodyPart part : parts.values()) {
            Stats partStats = part.getStats();
            for(Stat stat : Stat.values())
                stats.addModifier(stat, partStats.get(stat));
        }
    }

    public String getName(){return name;}

    public void putPart(PartType type, BodyPart part){
        parts.put(type, part);
        updateMaxHp();
    }

    private void updateMaxHp() {
        float newHp = 0;
        for(BodyPart part : parts.values())
            newHp += part.getStats().get(Stat.MAX_HP);

        stats.put(Stat.MAX_HP, newHp);
        stats.put(Stat.CURRENT_HP, newHp);
    }

    public void updateEffects(){
        List<Effect> effectsToBeRemoved = new ArrayList<>();

        for(Effect effect : effects) {
            if(effect.getRemainingDuration() <= 0)
                effectsToBeRemoved.add(effect);
            else
                effect.execute();
        }

        for(Effect effect : effectsToBeRemoved)
            effect.detach();
    }

    public void applyEffect(Effect effect){
        effects.add(effect);
    }

    public void removeEffect(Effect effect){
        effects.remove(effect);
    }

    public void clearEffects(){
        List<Effect> effectsToBeRemoved = new ArrayList<>(effects);
        for(Effect effect : effectsToBeRemoved)
            effect.detach();
    }

    public float getStat(Stat stat){
        return stats.get(stat);
    }

    public void setStat(Stat stat, float value){
        stats.put(stat, value);
    }

    public BodyPart getPart(PartType part){
        return parts.get(part);
    }

    public boolean hasPart(PartType type){
        return parts.containsKey(type);
    }

    public void addObserver(MobObserver observer){
        stats.addListener(observer);
        stats.notifyListeners();
    }
}
