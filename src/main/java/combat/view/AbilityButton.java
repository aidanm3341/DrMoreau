package combat.view;

import combat.abilities.Ability;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import util.MyFont;
import util.buttons.AbilityListener;
import util.buttons.AbilitySubject;

import java.util.ArrayList;
import java.util.List;

public class AbilityButton implements AbilitySubject, ComponentListener {

    private static final int WIDTH = 350, HEIGHT = 65;
    private static final Color DEFAULT_BLACK = new Color(0, 0, 0, 0.7f);
    private static final Color HOVER_BLACK = new Color(0, 0, 0, 0.9f);

    private MouseOverArea area;
    private float x, y;
    private Ability ability;

    private List<AbilityListener> listeners;

    private Font abilityNameFont, abilityDescriptionFont;

    public AbilityButton(Ability ability, float x, float y) throws SlickException {
        this.x = x;
        this.y = y;
        this.ability = ability;

        listeners = new ArrayList<>();
        abilityNameFont = new MyFont(30).getUniFont();
        abilityDescriptionFont = new MyFont(20).getUniFont();
    }

    public void init(GameContainer gc) throws SlickException {
        Image image = new Image(WIDTH, HEIGHT);
        image.getGraphics().setColor(DEFAULT_BLACK);
        image.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        image.getGraphics().flush();

        Image hoverImage = new Image(WIDTH, HEIGHT);
        hoverImage.getGraphics().setColor(HOVER_BLACK);
        hoverImage.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        hoverImage.getGraphics().flush();

        area = new MouseOverArea(gc, image, (int) x, (int) y);
        area.setMouseOverImage(hoverImage);
        area.addListener(this);
    }

    public void render(GameContainer gc, Graphics g) {
        area.render(gc, g);
        if(area.isMouseOver()){
            g.setColor(HOVER_BLACK);
            g.fillRect(x, y + HEIGHT, WIDTH + 50, 200);
            g.setColor(Color.white);
            g.setFont(abilityDescriptionFont);
            g.drawString(ability.toString(), x + 20, y + HEIGHT + 20);
        }
        g.setColor(Color.white);
        g.setFont(abilityNameFont);
        g.drawString(ability.getName(), x + 20, y + 20);
    }

    @Override
    public void addListener(AbilityListener listener) {
        listeners.add(listener);
    }

    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        for(AbilityListener listener : listeners)
            listener.movePerformed(ability);
    }
}
