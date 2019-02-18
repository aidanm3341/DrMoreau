package screens;

import main.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public abstract class Screen extends BasicGameState {

    private Color bg;
    private StateBasedGame sbg;

    public abstract int getID();

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        bg = new Color(10, 10, 25);
    }

    public  void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setColor(bg);
        g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException{}

    protected void enterState(int ID)
    {
        sbg.enterState(ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }
}
