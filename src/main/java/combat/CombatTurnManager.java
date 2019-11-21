package combat;

import combat.stats.Stat;

public class CombatTurnManager {

    private CombatController controller;
    private Attack atk;

    public CombatTurnManager(CombatController controller, Attack atk){
        this.controller = controller;
        this.atk = atk;
    }

    public void attack1(){
        controller.getMob().attack(atk.getDmg());
    }

    public void attack2(){
        controller.getSidekick().attack(controller.getMob().getStat(Stat.ATTACK_DMG));
    }
}
