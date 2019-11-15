package screens;

import main.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Screen extends BasicGameState {

    private Color bg;

    public abstract int getID();

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        bg = new Color(10, 10, 25);
    }

    public  void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setColor(bg);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException{}
}
