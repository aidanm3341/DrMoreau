package main;

import combat.controllers.CombatController;
import data.mob.MobCombatData;
import data.bodyparts.PartType;
import data.mob.MobCreator;
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

    private MobCombatData sidekick;

    private Intro intro;
    private CombatController combat;
    private NavigationController navigation;
    private UpgradeController upgrade;
    private GameOver gameOver;
    private Victory victory;
    private StateBasedGame sbg;

    public MainController(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
    }

    public void init(GameContainer gc) throws SlickException {
        loadDefaultSidekick();

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
    }

    public MobCombatData getSidekick(){
        return sidekick;
    }
    public void updateSidekick()
    {
        sidekick.putPart(PartType.BODY, upgrade.getBody());
        sidekick.putPart(PartType.RIGHT_ARM, upgrade.getArmRight());
        sidekick.putPart(PartType.LEFT_ARM, upgrade.getArmLeft());
        sidekick.putPart(PartType.LEFT_LEG, upgrade.getLegLeft());
        sidekick.putPart(PartType.RIGHT_LEG, upgrade.getLegRight());
        sidekick.putPart(PartType.HEAD, upgrade.getHead());
        sidekick.putPart(PartType.TAIL, upgrade.getTail());
    }

    public void reset() throws SlickException {
        loadDefaultSidekick();
        navigation.reset();
    }

    private void loadDefaultSidekick() throws SlickException {
        sidekick = MobCreator.getMob("sidekick", 1);
    }

    public void enterState(int ID) {
        sbg.enterState(ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    public Room getActiveRoom(){
        return navigation.getActiveRoom();
    }

}
