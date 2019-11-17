package util.buttons;

import combat.Attack;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class AttackButton extends Button implements ComponentListener {

    private Attack at;
    private List<MoveListener> listeners;

    public AttackButton(Attack at, float x, float y) {
        super(at.getName(), ResourceLoader.getImage("basicButton"), x, y);
        this.at = at;
        listeners = new ArrayList<>();
    }

    public void init(GameContainer gc)
    {
        super.init(gc);
        this.addHoverOverImage(ResourceLoader.getImage("basicButtonHover"));
        this.addPressedImage(ResourceLoader.getImage("basicButtonPressed"));

        super.addListener(this);
    }

    public void addListener(MoveListener listener){
        listeners.add(listener);
    }

    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        for(MoveListener listener : listeners)
            listener.movePerformed(at);
    }
}