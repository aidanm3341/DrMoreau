package combat;

import main.Attack;
import main.Main;
import main.MainController;
import main.SidekickData;
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
    private CombatView view;
    private Mob mob;
    private Attack at1, at2, at3, at4, at5, at6;

    public CombatController(MainController main, Attack at1, Attack at2, Attack at3, Attack at4, Attack at5, Attack at6)
    {
        this.main = main;
        this.at1 = at1;
        this.at2 = at2;
        this.at3 = at3;
        this.at4 = at4;
        this.at5 = at5;
        this.at6 = at6;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
        view = new CombatView(this, at1.getName(), at2.getName(), at3.getName(), at4.getName(), at5.getName(), at6.getName());
        view.init(gc);
        startNewCombat(MobData.getMob("test"));
    }

    public void startNewCombat(Mob mob)
    {
        this.mob = mob;
    }

    public void doAttack1(){mob.setHp(at1.getDmg());}
    public void doAttack2(){mob.setHp(at2.getDmg());}
    public void doAttack3(){mob.setHp(at3.getDmg());}
    public void doAttack4(){mob.setHp(at4.getDmg());}
    public void doAttack5(){mob.setHp(at5.getDmg());}
    public void doAttack6(){mob.setHp(at6.getDmg());}



    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
    {
        view.render(gc, g);
        //g.drawImage(mob.getMobImage(), 1100, 300);
    }

    public Mob getMob(){
        return mob;
    }

    public SidekickData getSidekick(){
        return main.getSidekick();
    }
}
