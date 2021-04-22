package combat.abilities.effects;

import data.mob.MobCombatData;

public interface Effect {
    void attach(MobCombatData attacker, MobCombatData defender);
    void onAttach();
    void resolveEndOfTurn();
    int getRemainingDuration();
    boolean isComplete();
}
