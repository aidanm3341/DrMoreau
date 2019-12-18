package combat.view;

import combat.stats.Stat;
import combat.stats.Stats;
import data.mob.MobObserver;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HealthBar implements MobObserver {

    private String name;
    private float x, y, width;
    private float maxHp, armor, currentHp;

    HealthBar(String name, float x, float y){
        this.name = name;
        this.x = x;
        this.y = y;
        width = 400;
    }

    public void render(Graphics g){
        // name display
        g.setColor(Color.white);
        g.drawString(name, x, y);
        // max health
        g.setColor(Color.red);
        g.fillRect(x, y+45, width, 30);
        // current health
        g.setColor(Color.green);
        g.fillRect(x, y+45, (int) (((currentHp + armor)/(maxHp + armor))*width), 30);
        // armor
        float armorWidth = (armor/(maxHp + armor))*width;
        g.setColor(new Color(51, 204, 255));
        g.fillRect(x + (int) (((currentHp + armor)/(maxHp + armor))*width), y+45, armorWidth, 30);
        // hp text
        g.setColor(Color.white);
        g.drawString(" "+ (currentHp + armor) + " : " + maxHp, x+50, y+90);
    }

    @Override
    public void update(Stats stats) {
        maxHp = stats.get(Stat.MAX_HP);
        armor = stats.get(Stat.ARMOR);
        currentHp = stats.get(Stat.CURRENT_HP);
    }
}
