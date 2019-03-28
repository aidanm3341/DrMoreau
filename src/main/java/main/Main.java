package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.MainMenu;
import util.MyFont;
import util.ResourceLoader;

import java.awt.*;
import java.io.IOException;

public class Main extends StateBasedGame {


    // Game state identifiers
    public static final int MAINMENU = 0;
    public static final int FIGHT    = 1;
    public static final int UPGRADE  = 2;
    public static final int TRAVEL   = 3;

    // Application Properties
    public static final int WIDTH   = 1680;
    public static final int HEIGHT  = 920;
    public static final int FPS     = 60;
    public static final double VERSION = 1.0;

    // Class Constructor
    public Main(String appName) {
        super(appName);
    }

    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    public void initStatesList(GameContainer gc) throws SlickException {
        try {
            gc.setDefaultFont(MyFont.createFont(100));

        } catch (IOException e) { e.printStackTrace(); } catch (FontFormatException e) { e.printStackTrace(); }


        ResourceLoader.loadImages();
        // The first state added will be the one that is loaded first, when the application is launched
        this.addState(new MainMenu());
        MainController main = new MainController(gc, this);
        main.init(gc);
    }



    // main.Main Method
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main("Dr.Moreau v" + VERSION));
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(false);
            app.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}