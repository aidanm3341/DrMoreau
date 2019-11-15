package main;

import combat.MobData;
import data.DatabaseEditor;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;
import screens.MainMenu;
import util.MyFont;
import util.ResourceLoader;

import java.awt.*;
import java.io.IOException;

public class Main extends StateBasedGame {

    // Game state identifiers
    public static final int MAINMENU = 0;
    public static final int INTRO    = 1;
    public static final int FIGHT    = 2;
    public static final int UPGRADE  = 3;
    public static final int TRAVEL   = 4;
    public static final int CONFIRM  = 5;
    public static final int GAMEOVER = 6;
    public static final int VICTORY  = 7;
    public static final int INTROTXT = 8;

    // Application Properties
    public static final int WIDTH   = 1650;//1280;//1680;
    public static final int HEIGHT  = 1050;//720;//920;
    public static final int FPS     = 60;
    public static final double VERSION = 1.0;

    private GameContainer gc;

    // Class Constructor
    public Main(String appName) {
        super(appName);
    }

    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    public void initStatesList(GameContainer gc) throws SlickException {
        this.gc = gc;
        try {
            gc.setDefaultFont(MyFont.createFont(100));

        } catch (IOException | FontFormatException e) { e.printStackTrace(); }


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
//            DatabaseEditor d = new DatabaseEditor();
//            try {
//                d.insert();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            DisplayMode[] modes = new DisplayMode[0];
            try {
                modes = Display.getAvailableDisplayModes();
            } catch (LWJGLException e) {
                e.printStackTrace();
            }

            for (int i=0;i<modes.length;i++) {
                DisplayMode current = modes[i];
                System.out.println(current.getWidth() + "x" + current.getHeight() + "x" +
                        current.getBitsPerPixel() + " " + current.getFrequency() + "Hz");
            }


            //AppGameContainer app = new AppGameContainer(new Main("Dr.Moreau v" + VERSION));
            AppGameContainer app = new AppGameContainer(new ScalableGame(new Main("Dr.Moreau v" + VERSION),
                    WIDTH, HEIGHT, true));
            app.setDisplayMode(WIDTH, HEIGHT, true);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(false);
            app.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}