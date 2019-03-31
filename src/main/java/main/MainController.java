package main;

import combat.CombatController;
import navigation.NavigationController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.Upgrade;

public class MainController {

    private SidekickData sidekick;

    private CombatController combat;
    private NavigationController navigation;
    private StateBasedGame sbg;

    public MainController(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
    }

    public void init(GameContainer gc) throws SlickException
    {
        sidekick = new SidekickData();
        combat = new CombatController(this, sidekick.getAt1(), sidekick.getAt2(), sidekick.getAt3(), sidekick.getAt4(), sidekick.getAt5(), sidekick.getAt6());
        combat.init(gc, sbg);

        navigation = new NavigationController();
        navigation.init(gc, sbg);

        sbg.addState(combat);
        sbg.addState(navigation);
        sbg.addState(new Upgrade());
    }

    public void attack(int dmg){
        sidekick.attack(dmg);
    }

    public SidekickData getSidekick(){
        return sidekick;
    }

}
