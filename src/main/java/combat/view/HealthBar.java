package combat.view;

import combat.stats.Stat;
import data.mob.MobCombatData;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HealthBar{

    private final String name;
    private float healthBarHealth;
    private float x, y, width;
    private float maxHp, armor, currentHp;
    private MobCombatData data;

    HealthBar(MobCombatData data, float x, float y){
        this.name = data.getName();
        this.data = data;
        this.x = x;
        this.y = y;
        width = 400;
        healthBarHealth = width;

        maxHp = data.getStat(Stat.MAX_HP);
        currentHp = data.getStat(Stat.CURRENT_HP);
        armor = data.getStat(Stat.ARMOR);
    }

    public void render(Graphics g){
        maxHp = data.getStat(Stat.MAX_HP);
        currentHp = data.getStat(Stat.CURRENT_HP);
        armor = data.getStat(Stat.ARMOR);

        // name display
        g.setColor(Color.white);
        g.drawString(name, x, y);

        float totalMaxHealth = maxHp + armor;
        // max health
        g.setColor(Color.red);
        g.fillRect(x, y+45, width, 30);
        // current health
        float armorWidth = (armor/totalMaxHealth)*width;
        g.setColor(Color.green);
        setHealthBarHealth(((currentHp + armor)/totalMaxHealth)*width - armorWidth);
        g.fillRect(x, y+45, healthBarHealth, 30);
        // armor
        g.setColor(new Color(51, 204, 255));
        g.fillRect(x + (int) (((currentHp + armor)/totalMaxHealth)*width)-armorWidth, y+45, armorWidth, 30);
        // hp text
        g.setColor(Color.white);
        g.drawString(" "+ (currentHp + armor) + " : " + maxHp, x+50, y+90);
    }

    private void setHealthBarHealth(float health){
        healthBarHealth = health;
        if(health < 0)
            healthBarHealth = 0;
    }
}
