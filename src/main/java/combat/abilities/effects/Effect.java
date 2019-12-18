package combat.abilities.effects;

import data.mob.Mob;

public interface Effect {
    void attach(Mob attacker, Mob defender);
    void detach();
    void execute();
    int getRemainingDuration();
}
