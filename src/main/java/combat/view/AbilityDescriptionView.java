package combat.view;

import combat.abilities.Ability;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import util.MyFont;

import java.util.Arrays;
import java.util.Comparator;

public class AbilityDescriptionView {

    private static final float PADDING = 20;

    private static final Color HOVER_BLACK = new Color(0, 0, 0, 0.9f);
    private String text;
    private MyFont font;
    private float width, height;

    public AbilityDescriptionView(Ability ability) throws SlickException {
        this.text = ability.toString();
        this.font = new MyFont(20);


        width = font.getUniFont().getWidth(
                Arrays.stream(text.split("\n"))
                        .max(Comparator.comparingInt(String::length))
                        .get()
        );
        width += PADDING*2;

        height = font.getUniFont().getHeight("Nothing") * Arrays.stream(text.split("\n")).count();
        height += PADDING*2;
    }

    public void render(Graphics g, float x, float y){
        g.setColor(HOVER_BLACK);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.setFont(font.getUniFont());
        g.drawString(text, x + PADDING, y + PADDING);
    }
}
