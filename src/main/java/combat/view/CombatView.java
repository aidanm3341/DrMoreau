package combat.view;

import combat.abilities.Ability;
import combat.CombatController;
import combat.abilities.effects.ArmorEffect;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.view.animation.AttackAnimationToRight;
import combat.view.animation.StillAnimation;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import combat.view.mobview.PhysicalAttributes;
import data.framework.IBodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.AbilityListener;

import java.util.ArrayList;
import java.util.List;

public class CombatView {

    private AbilityButton basicAttackButton, basicDefendButton;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;
    private HealthBar mobHealth, playerHealth;

    public CombatView(CombatController ctrl) throws SlickException {

        this.ctrl = ctrl;

        createEnemyView();
        createPlayerView();


        List<Effect> effects = new ArrayList<>();
        effects.add(new DamageEffect(ctrl.getSidekick().getStat(Stat.ATTACK_DMG)));
        Ability basicAttack = new Ability("Basic Attack", effects, new AttackAnimationToRight(playerView.getAttributes()));
        basicAttackButton = new AbilityButton(basicAttack, 0, 70);


        effects = new ArrayList<>();
        effects.add(new ArmorEffect(5, 0));
        Ability basicDefend = new Ability("Basic Defend", effects, new StillAnimation());
        basicDefendButton = new AbilityButton(basicDefend, 0, 160);



        background = ResourceLoader.getImage("battleBackground");

        mobHealth = new HealthBar(ctrl.getMob().getName(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getSidekick().getName(), 400, 55);

        ctrl.getMob().addObserver(mobHealth);
        ctrl.getSidekick().addObserver(playerHealth);
    }

    public void addListener(AbilityListener listener){
        basicAttackButton.addListener(listener);
        basicDefendButton.addListener(listener);
    }


    private void createPlayerView(){
        IBodyPart body = ctrl.getSidekick().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(400, 380));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getPart(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    public MobView getMobView(){
        return mobView;
    }

    private void createEnemyView(){
        IBodyPart body = ctrl.getMob().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(1150, 400));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && ctrl.getMob().hasPart(type))
                mobViewBuilder.addPart(type, ctrl.getMob().getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public void init(GameContainer gc) throws SlickException {
        basicAttackButton.init(gc);
        basicDefendButton.init(gc);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.setFont(MyFont.createFont(12));

        basicDefendButton.render(gc, g);
        basicAttackButton.render(gc, g);

        mobHealth.render(g);
        playerHealth.render(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
    }
}
