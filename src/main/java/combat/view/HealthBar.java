package combat.view;

import combat.stats.Stat;
import combat.stats.Stats;
import data.mob.MobObserver;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HealthBar implements MobObserver {

    private final String name;
    private float healthBarHealth;
    private float x, y, width;
    private float maxHp, armor, currentHp;

    HealthBar(String name, float x, float y){
        this.name = name;
        this.x = x;
        this.y = y;
        width = 400;
        healthBarHealth = width;
    }

    public void render(Graphics g){
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

    @Override
    public void update(Stats stats) {
        maxHp = stats.get(Stat.MAX_HP);
        armor = stats.get(Stat.ARMOR);
        currentHp = stats.get(Stat.CURRENT_HP);
    }
}
