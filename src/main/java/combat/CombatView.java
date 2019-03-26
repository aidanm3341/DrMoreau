package combat;

import main.Attack;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import util.AttackButton;

public class CombatView implements ComponentListener {

    private AttackButton att1_button, att2_button, att3_button, att4_button, att5_button, att6_button;
    private CombatController ctrl;

    public CombatView(CombatController ctrl, String at1, String at2, String at3, String at4, String at5, String at6)
    {
        this.ctrl = ctrl;
        att1_button = new AttackButton(at1, 200, 600);
        att1_button.addListener(this);
    }

    public void render(GameContainer gc, Graphics g)
    {
        att1_button.render(gc, g);
    }

    public void componentActivated(AbstractComponent c) {
        if (c.equals(att1_button))
            ctrl.doAttack1();
        else if (c.equals(att2_button))
            ctrl.doAttack2();
        else if (c.equals(att3_button))
            ctrl.doAttack3();
        else if (c.equals(att4_button))
            ctrl.doAttack4();
        else if (c.equals(att5_button))
            ctrl.doAttack5();
        else if (c.equals(att6_button))
            ctrl.doAttack6();
    }
}
