package main;

import combat.CombatController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.Fight;
import screens.Travel;
import screens.Upgrade;

public class MainController {

    private SidekickData sidekick;

    private CombatController combat;
    private StateBasedGame sbg;

    public MainController(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
    }

    public void init(GameContainer gc) throws SlickException
    {
        sidekick = new SidekickData();
        combat = new CombatController(sidekick.getAt1(), sidekick.getAt2(), sidekick.getAt3(), sidekick.getAt4(), sidekick.getAt5(), sidekick.getAt6());
        combat.init(gc, sbg);

        sbg.addState(new Fight());
        sbg.addState(combat);
        sbg.addState(new Upgrade());
        sbg.addState(new Travel());
    }

    public void attack(int dmg){
        sidekick.attack(dmg);
    }

}
