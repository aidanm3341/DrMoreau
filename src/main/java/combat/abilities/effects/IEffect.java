package combat.abilities.effects;

import data.mob.MobCombatData;

public interface IEffect {
    void attach(MobCombatData attacker, MobCombatData defender);

    void firstAction();
    void endOfTurnAction();

    int getRemainingDuration();
    boolean isComplete();
}
