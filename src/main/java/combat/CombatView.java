package combat;

import data.framework.MobController;
import data.framework.PartType;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import upgrade.bodyparts.BodyConcreteBodyPart;
import util.buttons.AttackButton;
import util.MyFont;
import util.ResourceLoader;

public class CombatView {

    private AttackButton att1_button, att2_button, att3_button, att4_button, att5_button, att6_button;
    private PlayerMobController player;

    private CombatController ctrl;
    private Image background;
    private MobView mobView;

    public CombatView(CombatController ctrl, PlayerMobController mobController,
                      Attack at1, Attack at2, Attack at3, Attack at4, Attack at5, Attack at6)
    {
        att1_button = new AttackButton(at1, 150, 700);
        att2_button = new AttackButton(at2, 400, 700);
        att3_button = new AttackButton(at3, 650, 700);
        att4_button = new AttackButton(at4, 150, 800);
        att5_button = new AttackButton(at5, 400, 800);
        att6_button = new AttackButton(at6, 650, 800);
        player = mobController;
        this.ctrl = ctrl;
        background = ResourceLoader.getImage("battleBackground");

        mobView = new MobView((BodyConcreteBodyPart) ctrl.getMob().getParts().get(PartType.BODY), 1300, 510);
        ctrl.getMob().getParts().remove(PartType.BODY);

        for(PartType type : ctrl.getMob().getParts().keySet()){
            mobView.addPart(type, ctrl.getMob().getParts().get(type));
        }
    }

    public void init(GameContainer gc){
        att1_button.init(gc);
        att1_button.addListener(player);

        att2_button.init(gc);
        att2_button.addListener(player);

        att3_button.init(gc);
        att3_button.addListener(player);

        att4_button.init(gc);
        att4_button.addListener(player);

        att5_button.init(gc);
        att5_button.addListener(player);

        att6_button.init(gc);
        att6_button.addListener(player);
    }

    public void render(GameContainer gc, Graphics g)
    {
        g.drawImage(background, 0, 0);
        try {
            g.setFont(MyFont.createFont(12));
        } catch (Exception e) { e.printStackTrace(); }
        ctrl.getSidekick().getImage().render(300, 420, g);
        //ctrl.getMob().getMobImage().render(1300, 510, g);

        att1_button.render(gc, g);
        att2_button.render(gc, g);
        att3_button.render(gc, g);
        att4_button.render(gc, g);
        att5_button.render(gc, g);
        att6_button.render(gc, g);

        renderMobHealthBar(g);
        renderSidekickHealthBar(g);
        mobView.render(gc, g);
    }

    private void renderMobHealthBar(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString(ctrl.getMob().getName(), 1100, 55);
        // health bar
        g.setColor(Color.red);
        g.fillRect(1100, 100, 400, 30);
        g.setColor(Color.green);
        g.fillRect(1100, 100,
                (ctrl.getMob().getCurrentHp()/ctrl.getMob().getMaxHp())*400, 30);
        g.setColor(Color.white);
        g.drawString(" "+ctrl.getMob().getCurrentHp() + " : " + ctrl.getMob().getMaxHp(), 1150, 145);
    }

    private void renderSidekickHealthBar(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString("Sidekick", 200, 55);
        // health bar
        g.setColor(Color.red);
        g.fillRect(200, 100, 400, 30);
        g.setColor(Color.green);
        g.fillRect(200, 100,
                (ctrl.getSidekick().getCurrentHp()/ctrl.getSidekick().getMaxHp())*400, 30);
        g.setColor(Color.white);
        g.drawString(" "+ctrl.getSidekick().getCurrentHp() + " : " + ctrl.getSidekick().getMaxHp(), 250, 145);
    }

//    public void componentActivated(AbstractComponent c) {
//        if (att1_button.equals(c))
//            ctrl.doAttack1();
//        else if (att2_button.equals(c))
//            ctrl.doAttack2();
//        else if (att3_button.equals(c))
//            ctrl.doAttack3();
//        else if (att4_button.equals(c))
//            ctrl.doAttack4();
//        else if (att5_button.equals(c))
//            ctrl.doAttack5();
//        else if (att6_button.equals(c))
//            ctrl.doAttack6();
//    }
}
