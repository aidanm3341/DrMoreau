package main;

import combat.CombatController;
import navigation.ConfirmationPanel;
import navigation.NavigationController;
import navigation.Room;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import screens.GameOver;
import screens.Victory;
import upgrade.UpgradeController;

public class MainController {

    private SidekickData sidekick;

    private Intro intro;
    private CombatController combat;
    private NavigationController navigation;
    private UpgradeController upgrade;
    private GameOver gameOver;
    private Victory victory;
    private StateBasedGame sbg;

    private int level;

    public MainController(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
    }

    public void init(GameContainer gc) throws SlickException
    {
        sidekick = new SidekickData();
        sidekick.init(gc);

        intro = new Intro(this);
        intro.init(gc, sbg);

        combat = new CombatController(this, sidekick.getAt1(), sidekick.getAt2(), sidekick.getAt3(), sidekick.getAt4(), sidekick.getAt5(), sidekick.getAt6());
        combat.init(gc, sbg);

        navigation = new NavigationController(this);
        navigation.init(gc, sbg);

        upgrade = new UpgradeController(this);
        upgrade.init(gc, sbg);

        gameOver = new GameOver(this);
        gameOver.init(gc, sbg);

        victory = new Victory(this);
        victory.init(gc, sbg);

        sbg.addState(intro);
        sbg.addState(combat);
        sbg.addState(navigation);
        sbg.addState(upgrade);
        sbg.addState(gameOver);
        sbg.addState(victory);
        sbg.addState(new ConfirmationPanel(this));

        level = 0;
    }

    public void attack(int dmg){
        sidekick.attack(dmg);
    }

    public SidekickData getSidekick(){
        //updateSidekick();
        return sidekick;
    }

    public void updateSidekick()
    {
        sidekick.addBody(upgrade.getBody());
        sidekick.addArmRight(upgrade.getArmRight());
        sidekick.addArmLeft(upgrade.getArmLeft());
        sidekick.addLegLeft(upgrade.getLegLeft());
        sidekick.addLegRight(upgrade.getLegRight());
        sidekick.addHead(upgrade.getHead());
        sidekick.addTail(upgrade.getTail());
    }

    public void reset() throws SlickException
    {
        level = 0;
        sidekick.loadDefaultSidekick();
    }

    public void enterState(int ID)
    {
        if(ID == Main.FIGHT)
            level++;
        sbg.enterState(ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    public Room getActiveRoom(){
        return navigation.getActiveRoom();
    }

}
