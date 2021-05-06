package combat.controllers;

import combat.TurnManager;
import combat.abilities.Ability;
import combat.stats.Stat;
import combat.view.CombatView;
import combat.view.animation.AnimationManager;
import combat.view.animation.AnimationManagerImp;
import combat.view.animation.StillAnimation;
import data.mob.MobCombatData;
import main.Main;
import main.MainController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;

public class CombatController extends Screen {
    public int getID() {
        return Main.FIGHT;
    }

    private MainController main;
    private MobController playerController;
    private CombatView view;
    private MobController enemyController;

    private AnimationManager animationManager;
    private TurnManager turns;

    public CombatController(MainController main) throws SlickException {
        this.main = main;

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        animationManager = new AnimationManagerImp();

        playerController = new PlayerMobController(main.getSidekick());
        playerController.attachController(this);

        view = new CombatView(this);
        view.init(gc);
        view.addListener((PlayerMobController) playerController);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startNewCombat(main.getActiveRoom().getMob());
        view = new CombatView(this);
        view.init(gc);
        view.createRoomView(gc);
        view.addListener((PlayerMobController) playerController);
    }

    public void startNewCombat(MobCombatData mobCombatData) {
        this.enemyController = new EnemyController(mobCombatData);
        playerController = new PlayerMobController(main.getSidekick());
        playerController.attachController(this);

        turns = new TurnManager(this, animationManager, playerController, enemyController);
        playerController.getMobData().clearEffects();
    }

    public void executeAbility(Ability atk) {
        turns.executeAbility(atk);
        animationManager.doAnimation(new StillAnimation(40));
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        turns.update();
        checkWins();
    }

    public void checkWins() {
        if(main.getSidekick().getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.GAMEOVER);
        else if(enemyController.getMobData().getName().equals("Dr.Moreau") && enemyController.getMobData().getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.VICTORY);
        else if(enemyController.getMobData().getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.UPGRADE);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        view.render(gc, g);
    }

    public MobController getMobController(){
        return enemyController;
    }

    public MobController getPlayerController(){
        return playerController;
    }

    public CombatView getView(){
        return view;
    }
}
