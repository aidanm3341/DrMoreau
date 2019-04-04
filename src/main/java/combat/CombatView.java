package combat;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import util.AttackButton;
import util.MyFont;
import util.ResourceLoader;

public class CombatView implements ComponentListener {

    private AttackButton att1_button, att2_button, att3_button, att4_button, att5_button, att6_button;
    private CombatController ctrl;
    private Image background;

    public CombatView(CombatController ctrl, String at1, String at2, String at3, String at4, String at5, String at6)
    {
        att1_button = new AttackButton(at1, 150, 700);
        att2_button = new AttackButton(at2, 400, 700);
        att3_button = new AttackButton(at3, 650, 700);
        att4_button = new AttackButton(at4, 150, 800);
        att5_button = new AttackButton(at5, 400, 800);
        att6_button = new AttackButton(at6, 650, 800);
        this.ctrl = ctrl;
        background = ResourceLoader.getImage("battleBackground");
    }

    public void init(GameContainer gc){
        att1_button.init(gc);
        att1_button.addListener(this);

        att2_button.init(gc);
        att2_button.addListener(this);

        att3_button.init(gc);
        att3_button.addListener(this);

        att4_button.init(gc);
        att4_button.addListener(this);

        att5_button.init(gc);
        att5_button.addListener(this);

        att6_button.init(gc);
        att6_button.addListener(this);
    }

    public void render(GameContainer gc, Graphics g)
    {
        g.drawImage(background, 0, 0);
        try {
            g.setFont(MyFont.createFont(12));
        } catch (Exception e) { e.printStackTrace(); }
        ctrl.getSidekick().getImage().render(300, 420, g);
        ctrl.getMob().getMobImage().render(1300, 510, g);

        att1_button.render(gc, g);
        att2_button.render(gc, g);
        att3_button.render(gc, g);
        att4_button.render(gc, g);
        att5_button.render(gc, g);
        att6_button.render(gc, g);

        g.setColor(Color.red);
        g.fillRect(1100, 100, 400, 30);
        g.setColor(Color.green);
        g.fillRect(1100, 100,
                ((float) ctrl.getMob().getCurrentHp()/(float) ctrl.getMob().getMaxHp())*400, 30);
        g.setColor(Color.white);
        g.drawString(" "+ctrl.getMob().getCurrentHp() + " / " + ctrl.getMob().getMaxHp(), 1150, 145);
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
