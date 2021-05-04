package data.mob;

import combat.abilities.effects.EffectContainer;
import combat.abilities.effects.IEffect;
import combat.stats.Stat;
import combat.stats.Stats;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MobCombatData{

    private final String name;
    private final Stats stats;
    private final Map<PartType, IBodyPart> parts;
    private final EffectContainer effectContainer;

    public MobCombatData(String name, Map<PartType, IBodyPart> parts) {
        this.name = name;
        this.parts = parts;

        effectContainer = new EffectContainer();

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
        effectContainer.update();
    }

    public void applyEffect(IEffect effect){
        effectContainer.add(effect);
    }

    public void clearEffects(){
        effectContainer.clear();
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

    public Map<PartType, IBodyPart> getParts() {
        return parts;
    }

    public boolean hasPart(PartType type){
        return parts.containsKey(type);
    }
}
