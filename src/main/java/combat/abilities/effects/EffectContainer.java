package combat.abilities.effects;

import java.util.ArrayList;
import java.util.List;

public class EffectContainer {

    private final List<IEffect> effects;

    public EffectContainer(){
        effects = new ArrayList<>();
    }

    public void add(IEffect e){
        effects.add(e);
    }

    public void update(){
        effects.forEach(IEffect::endOfTurnAction);
        effects.removeIf(IEffect::isComplete);
    }

    public void clear(){
        effects.clear();
    }
}
