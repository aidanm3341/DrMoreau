package combat;

import combat.stats.Stat;
import combat.view.CombatView;
import combat.view.animation.AnimationManager;
import combat.view.animation.AnimationManagerImp;
import data.Mob;
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
    private Mob mob;

    private AnimationManager animationManager;
    private TurnManager turns;

    public CombatController(MainController main) {
        this.main = main;
        playerController = new PlayerMobController(main.getSidekick());
        playerController.enter(this);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        animationManager = new AnimationManagerImp();
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startNewCombat(main.getActiveRoom().getMob());
        view = new CombatView(this);
        view.init(gc);
        view.addListener((PlayerMobController) playerController);
    }

    public void startNewCombat(Mob mob) {
        this.mob = mob;
        MobController enemyController = new EnemyController(mob);

        turns = new TurnManager(this, animationManager, playerController, enemyController);
    }

    public void doAttack(Ability atk) {
        turns.attack(atk);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        turns.update();
        checkWins();
    }

    public void checkWins() {
        if(main.getSidekick().getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.GAMEOVER);
        else if(mob.getName().equals("Dr.Moreau") && mob.getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.VICTORY);
        else if(mob.getStat(Stat.CURRENT_HP) <= 0)
            main.enterState(Main.UPGRADE);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        view.render(gc, g);
    }

    public Mob getMob(){
        return mob;
    }

    public Mob getSidekick(){
        return main.getSidekick();
    }

    public CombatView getView(){
        return view;
    }
}
