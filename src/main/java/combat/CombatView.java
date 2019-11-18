package combat;

import combat.mobview.MobView;
import combat.mobview.MobViewBuilder;
import combat.stats.Stat;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.*;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.AttackButton;

public class CombatView {

    private AttackButton att1_button;
    private PlayerMobController player;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;
    private HealthBar mobHealth, playerHealth;

    public CombatView(CombatController ctrl, PlayerMobController mobController){
        Attack basicAttack = new Attack("Basic Attack", 1, ctrl.getSidekick().getStat(Stat.ATTACK_DMG));
        att1_button = new AttackButton(basicAttack, 150, 700);
        player = mobController;
        this.ctrl = ctrl;
        background = ResourceLoader.getImage("battleBackground");

        createEnemyView();
        createPlayerView();

        mobHealth = new HealthBar(ctrl.getMob(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getSidekick(), 200, 55);
    }

    private void createPlayerView(){
        BodyPart body = ctrl.getSidekick().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 200, 380);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getPart(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    private void createEnemyView(){
        BodyPart body = ctrl.getMob().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 1150, 400);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getMob().getPart(type));
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

        mobHealth.render(g);
        playerHealth.render(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
    }
}
