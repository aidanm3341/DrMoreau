package main;

import combat.CombatController;
import data.mob.Mob;
import data.bodyparts.PartFactory;
import data.framework.IBodyPart;
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

import java.util.HashMap;
import java.util.Map;

public class MainController {

    private Mob sidekick;

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

    public void init(GameContainer gc) throws SlickException
    {
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

    public Mob getSidekick(){
        //updateSidekick();
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

    public void reset() throws SlickException
    {
        loadDefaultSidekick();
    }

    private void loadDefaultSidekick() throws SlickException {
        Map<PartType, IBodyPart> parts = new HashMap<>();
        parts.put(PartType.BODY, PartFactory.getPart("dog_body", 2));
        parts.put(PartType.LEFT_ARM, PartFactory.getPart("dog_arm", 2));
        parts.put(PartType.RIGHT_ARM, PartFactory.getPart("dog_arm", 2));
        parts.put(PartType.LEFT_LEG, PartFactory.getPart("dog_leg", 2));
        parts.put(PartType.RIGHT_LEG, PartFactory.getPart("dog_leg", 2));
        parts.put(PartType.TAIL, PartFactory.getPart("dog_tail", 2));
        parts.put(PartType.HEAD, PartFactory.getPart("dog_head", 2));
        sidekick = new Mob("Sidekick", parts);
    }

    public void enterState(int ID) {
        sbg.enterState(ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    public Room getActiveRoom(){
        return navigation.getActiveRoom();
    }

}
