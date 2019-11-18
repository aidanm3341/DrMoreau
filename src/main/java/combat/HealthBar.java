package combat;

import combat.stats.Stat;
import data.Mob;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HealthBar {

    private Mob subject;
    private float x, y;

    public HealthBar(Mob subject, float x, float y){
        this.subject = subject;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g){
        // name display
        g.setColor(Color.white);
        g.drawString(subject.getName(), x, y);
        // health bar
        g.setColor(Color.red);
        g.fillRect(x, y+45, 400, 30);
        g.setColor(Color.green);
        g.fillRect(x, y+45,
                (subject.getStat(Stat.CURRENT_HP)/subject.getStat(Stat.MAX_HP))*400, 30);
        g.setColor(Color.white);
        // hp text
        g.drawString(" "+subject.getStat(Stat.CURRENT_HP) + " : " + subject.getStat(Stat.MAX_HP), x+50, y+90);
    }
}
