package main;

import combat.CombatController;
import data.framework.PartType;
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

        intro = new Intro(this);
        intro.init(gc, sbg);

        combat = new CombatController(this);
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
        sbg.addState(new IntroTxt(this));

        level = 1;
    }

    public void attack(int dmg){
        sidekick.attack(dmg);
    }

    public SidekickData getSidekick(){
        //updateSidekick();
        return sidekick;
    }

    public void updateSidekick() throws SlickException
    {
        sidekick.putPart(PartType.BODY, upgrade.getBody());
        sidekick.putPart(PartType.RIGHT_ARM, upgrade.getArmRight());
        sidekick.putPart(PartType.LEFT_ARM, upgrade.getArmLeft());
        sidekick.putPart(PartType.LEFT_LEG, upgrade.getLegLeft());
        sidekick.putPart(PartType.RIGHT_LEG, upgrade.getLegRight());
        sidekick.putPart(PartType.HEAD, upgrade.getHead());
        sidekick.putPart(PartType.TAIL, upgrade.getTail());
    }

    public void reset() throws SlickException
    {
        level = 1;
        sidekick.loadDefaultSidekick();
    }

    public void enterState(int ID)
    {
        if(ID == Main.FIGHT)
            level++;
        sbg.enterState(ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    public int getLevel() {
        return level;
    }

    public Room getActiveRoom(){
        return navigation.getActiveRoom();
    }

}
