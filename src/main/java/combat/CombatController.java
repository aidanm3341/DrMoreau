package combat;

import main.Attack;
import main.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;

public class CombatController extends Screen {

    private CombatView view;
    private Mob mob;
    private Attack at1, at2, at3, at4, at5, at6;

    public CombatController()
    {

        view = new CombatView(this, at1.getName(), at2.getName(), at3.getName(), at4.getName(), at5.getName(), at6.getName());
    }

    public void startNewCombat()
    {

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
        g.drawImage(mob.getMobImage(), 800, 300);
    }

    @Override
    public int getID() {
        return Main.FIGHT;
    }
}
