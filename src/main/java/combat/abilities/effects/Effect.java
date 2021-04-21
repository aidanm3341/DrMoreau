package combat.abilities.effects;

import data.mob.Mob;

public interface Effect {
    void attach(Mob attacker, Mob defender);
    void onAttach();
    void resolveEndOfTurn();
    int getRemainingDuration();
    boolean isComplete();
}
