package combat;

import combat.stats.Stat;
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
    private PlayerMobController playerController;
    private CombatView view;
    private Mob mob;

    public CombatController(MainController main) {
        this.main = main;
        playerController = new PlayerMobController();
        playerController.enter(this);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startNewCombat(main.getActiveRoom().getMob());
        view = new CombatView(this, playerController);
        view.init(gc);
    }

    public void startNewCombat(Mob mob)
    {
        this.mob = mob;
    }

    public void doAttack(Attack atk) {
        mob.attack(atk.getDmg());
        if(checkWins()) return;
        main.getSidekick().attack(mob.getStat(Stat.ATTACK_DMG));
    }



    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        checkWins();
    }

    private boolean checkWins() {
        if(main.getSidekick().getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.GAMEOVER);
            return true;
        }
        else if(mob.getName().equals("Dr.Moreau") && mob.getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.VICTORY);
            return true;
        }
        else if(mob.getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.UPGRADE);
            return true;
        }
        return false;
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
}
