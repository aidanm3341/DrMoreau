package combat;

import combat.abilities.Ability;

public interface AbilityStrategy {
    Ability getNextAbility();
}
