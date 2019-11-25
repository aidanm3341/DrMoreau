package combat.view;

import combat.Attack;
import combat.CombatController;
import combat.stats.Stat;
import combat.view.animation.AttackAnimationToRight;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import combat.view.mobview.PhysicalAttributes;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.AbilityListener;

public class CombatView {

    private AbilityButton abilityButton;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;
    private HealthBar mobHealth, playerHealth;

    public CombatView(CombatController ctrl) throws SlickException {

        this.ctrl = ctrl;

        createEnemyView();
        createPlayerView();

        Attack basicAttack = new Attack("Basic Attack", 0,0,
                ctrl.getSidekick().getStat(Stat.ATTACK_DMG),
                new AttackAnimationToRight(playerView.getAttributes()));
        abilityButton = new AbilityButton(basicAttack, 0, 70);

        background = ResourceLoader.getImage("battleBackground");



        mobHealth = new HealthBar(ctrl.getMob(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getSidekick(), 400, 55);
    }

    public void addListener(AbilityListener listener){
        abilityButton.addListener(listener);
    }


    private void createPlayerView(){
        BodyPart body = ctrl.getSidekick().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(400, 380));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getPart(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    public MobView getPlayerView(){
        return playerView;
    }

    public MobView getMobView(){
        return mobView;
    }

    private void createEnemyView(){
        BodyPart body = ctrl.getMob().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(1150, 400));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && ctrl.getMob().hasPart(type))
                mobViewBuilder.addPart(type, ctrl.getMob().getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public void init(GameContainer gc) throws SlickException {
        abilityButton.init(gc);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.setFont(MyFont.createFont(12));

        abilityButton.render(gc, g);

        mobHealth.render(g);
        playerHealth.render(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
    }
}
