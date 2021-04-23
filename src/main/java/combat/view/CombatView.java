package combat.view;

import combat.abilities.Ability;
import combat.CombatController;
import combat.abilities.effects.ArmorEffect;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.view.animation.AttackAnimation;
import combat.view.animation.StillAnimation;
import combat.view.mobview.MobView;
import data.framework.IBodyPart;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.AbilityListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombatView {

    private CombatController ctrl;
    private Image background;
    private HealthBar mobHealth, playerHealth;
    private List<AbilityButton> abilityButtons;

    public CombatView(CombatController ctrl) throws SlickException {
        this.ctrl = ctrl;
    }

    public void init(GameContainer gc) throws SlickException {
        abilityButtons = new ArrayList<>();

        background = ResourceLoader.getImage("battleBackground");
    }

    public void addListener(AbilityListener listener){
        abilityButtons.forEach(button -> button.addListener(listener));
    }


    public void createRoomView(GameContainer gc) throws SlickException {
        mobHealth = new HealthBar(ctrl.getMobController().getMobData().getName(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getPlayerController().getMobData().getName(), 400, 55);

        ctrl.getMobController().getMobData().addObserver(mobHealth);
        ctrl.getPlayerController().getMobData().addObserver(playerHealth);

        int y = 70;
        for (Ability ability
                : ctrl.getMobController().getMobData().getParts().values().stream()
                .map(IBodyPart::getAbility).collect(Collectors.toList())){

            AbilityButton button = new AbilityButton(ability, 0, y);
            button.init(gc);
            abilityButtons.add(button);
            y += 90;
        }
        Collections.reverse(abilityButtons);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.setFont(MyFont.createFont(12));

        abilityButtons.forEach(button -> button.render(gc, g));

        mobHealth.render(g);
        playerHealth.render(g);
        ctrl.getMobController().getMobView().render(gc, g);
        ctrl.getPlayerController().getMobView().render(gc, g);
    }
}
