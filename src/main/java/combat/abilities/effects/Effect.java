package combat.abilities.effects;

import data.Mob;

public interface Effect {
    void execute(Mob attacker, Mob defender);
}
