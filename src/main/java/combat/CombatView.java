package combat;

import main.Attack;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import util.AttackButton;
import util.MyFont;


public class CombatView implements ComponentListener {

    private AttackButton att1_button, att2_button, att3_button, att4_button, att5_button, att6_button;
    private CombatController ctrl;

    public CombatView(CombatController ctrl, String at1, String at2, String at3, String at4, String at5, String at6)
    {
        att1_button = new AttackButton(at1, 200, 600);
        this.ctrl = ctrl;
    }

    public void init(GameContainer gc){
        att1_button.init(gc);
        att1_button.addListener(this);
    }

    public void render(GameContainer gc, Graphics g)
    {
        try {
            g.setFont(MyFont.createFont(12));
        } catch (Exception e) { e.printStackTrace(); }
        att1_button.render(gc, g);
        g.drawImage(ctrl.getMob().getMobImage(), 1100, 300);

        g.setColor(Color.white);
        g.drawString(""+ctrl.getMob().getHp(), 1150, 600);
    }

    public void componentActivated(AbstractComponent c) {
        if (att1_button.equals(c))
            ctrl.doAttack1();
        else if (att2_button.equals(c))
            ctrl.doAttack2();
        else if (att3_button.equals(c))
            ctrl.doAttack3();
        else if (att4_button.equals(c))
            ctrl.doAttack4();
        else if (att5_button.equals(c))
            ctrl.doAttack5();
        else if (att6_button.equals(c))
            ctrl.doAttack6();
    }
}
