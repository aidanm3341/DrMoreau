package combat.view;

import combat.stats.Stat;
import data.Mob;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HealthBar {

    private Mob subject;
    private float x, y;

    HealthBar(Mob subject, float x, float y){
        this.subject = subject;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g){
        // name display
        g.setColor(Color.white);
        g.drawString(subject.getName(), x, y);
        // max health
        g.setColor(Color.red);
        g.fillRect(x, y+45, 400, 30);
        // current health
        float currentHealthWidth = ((subject.getStat(Stat.CURRENT_HP) + subject.getStat(Stat.ARMOR))/(subject.getStat(Stat.MAX_HP) + subject.getStat(Stat.ARMOR)))*400;
        g.setColor(Color.green);
        g.fillRect(x, y+45,
               currentHealthWidth, 30);
        // armor
        float armorWidth = (subject.getStat(Stat.ARMOR)/(subject.getStat(Stat.MAX_HP) + subject.getStat(Stat.ARMOR)))*400;
        g.setColor(new Color(51, 204, 255));
        g.fillRect(x + currentHealthWidth, y+45, armorWidth, 30);
        // hp text
        g.setColor(Color.white);
        g.drawString(" "+ (subject.getStat(Stat.CURRENT_HP) + subject.getStat(Stat.ARMOR)) + " : " + subject.getStat(Stat.MAX_HP), x+50, y+90);
    }
}
