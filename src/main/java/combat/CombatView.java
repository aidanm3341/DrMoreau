package combat;

import combat.mobview.MobView;
import combat.mobview.MobViewBuilder;
import combat.stats.Stat;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.*;
import util.MyFont;
import util.Point;
import util.ResourceLoader;
import util.buttons.AttackButton;

import java.util.Map;

public class CombatView {

    private AttackButton att1_button;
    private PlayerMobController player;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;

    public CombatView(CombatController ctrl, PlayerMobController mobController){
        Attack basicAttack = new Attack("Basic Attack", 1, ctrl.getSidekick().getStat(Stat.ATTACK_DMG));
        att1_button = new AttackButton(basicAttack, 150, 700);
        player = mobController;
        this.ctrl = ctrl;
        background = ResourceLoader.getImage("battleBackground");


        createEnemyView();
        createPlayerView();
    }

    private void createPlayerView(){
        BodyPart body = ctrl.getSidekick().getParts().get(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 200, 380);
        for(PartType type : ctrl.getSidekick().getParts().keySet()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getParts().get(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    private void createEnemyView(){
        BodyPart body = ctrl.getMob().getParts().get(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 1150, 400);
        for(PartType type : ctrl.getMob().getParts().keySet()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getMob().getParts().get(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public void init(GameContainer gc){
        att1_button.init(gc);
        att1_button.addListener(player);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        try {
            g.setFont(MyFont.createFont(12));
        } catch (Exception e) { e.printStackTrace(); }

        att1_button.render(gc, g);

        renderMobHealthBar(g);
        renderSidekickHealthBar(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
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
}
