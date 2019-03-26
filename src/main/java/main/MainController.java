package main;

import combat.CombatController;
import org.newdawn.slick.state.StateBasedGame;
import screens.Fight;
import screens.Travel;
import screens.Upgrade;

public class MainController {

    private SidekickData sidekick;

    private CombatController combat;
    private StateBasedGame sbg;

    public MainController(StateBasedGame sbg)
    {
        this.sbg = sbg;
        sidekick = new SidekickData();
        combat = new CombatController();


        sbg.addState(new Fight());
        sbg.addState(combat);
        sbg.addState(new Upgrade());
        sbg.addState(new Travel());
    }

    public void attack(int dmg){
        sidekick.attack(dmg);
    }

}
