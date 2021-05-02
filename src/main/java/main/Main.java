package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;
import screens.MainMenu;
import util.MyFont;
import util.ResourceLoader;

public class Main extends StateBasedGame {

    // Game state identifiers
    public static final int MAINMENU = 0;
    public static final int INTRO    = 1;
    public static final int FIGHT    = 2;
    public static final int UPGRADE  = 3;
    public static final int TRAVEL   = 4;
    public static final int GAMEOVER = 5;
    public static final int VICTORY  = 6;
    public static final int INTROTXT = 7;

    // Application Properties
    public static final int WIDTH   = 1680;//fullscreen = 1650;
    public static final int HEIGHT  = 920;//fullscreen = 1050;
    public static final int FPS     = 60;
    public static final double VERSION = 1.0;

    // Class Constructor
    public Main(String appName) {
        super(appName);
    }

    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setDefaultFont(new MyFont(100).getUniFont());


        ResourceLoader.loadImages();
        // The first state added will be the one that is loaded first, when the application is launched
        MainController main = new MainController(gc, this);
        this.addState(new MainMenu(main));
        main.init(gc);

    }

    public void enterState(int id, Transition x, Transition y)
    {
        super.enterState(id, x, y);
    }



    // main.Main Method
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new ScalableGame(new Main("Dr.Moreau v" + VERSION),
                    WIDTH, HEIGHT, true));
            app.setDisplayMode((int) (WIDTH*0.9f), (int) (HEIGHT*0.9f), false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(false);
            app.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}