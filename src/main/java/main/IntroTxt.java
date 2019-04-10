package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;
import util.ResourceLoader;

public class IntroTxt extends Screen implements ComponentListener {
    public int getID() { return Main.INTROTXT; }

    private MainController main;
    private MouseOverArea bg;
    private String txt;

    public IntroTxt(MainController main){
        this.main = main;
        this.txt = "The distant thrum of medical equipment rouses you to consciousness, as you open your eyes you take in your\n"+
                "surroundings. You realize you are lying on a cold steel table in a dark, disheveled room, scattered with medical \n"+
                "equipment and animal anatomy diagrams. Standing in front of you is a tall, gauntly man dressed as a surgeon. \n\n"+
                "He introduces himself as Dr. Moreau, a name you find familiar but cannot place, and offers to get you food and \n"+
                "water. As you wait for his return you remember your cruise ship crashing along with where you have heard the \n"+
                "name Dr. Moreau. A famous surgeon who was driven out of England for his grotesque experiments on animals \n"+
                "to generate beastly hybrids. All of sudden a sudden explosion resonates throughout the room. You go to open the \n"+
                "door and to and enter into another room that is completely destroyed. In a corner of the room is a small animal \n"+
                "of sorts, a hybrid, which takes an instance liking to you. \n\n" +
                "Dr. Moreau through his vivisection experiments have created monstrous hybrids that have escaped the lab. It is \n"+
                "up to you and your sidekick to fight them and escape Dr. Moreau’s island...";
    }

    public void init(GameContainer gc, StateBasedGame sbg) {
        bg = new MouseOverArea(gc, ResourceLoader.getImage("blackground"), 0, 0);
        bg.addListener(this);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.render(gc, g);
        g.setFont(gc.getDefaultFont());
        g.scale(0.27f, 0.27f);
        g.setColor(new Color(227, 255, 86));
        g.drawString(txt, gc.getWidth()/2 - 570, 700);
        g.
    }

    public void componentActivated(AbstractComponent abstractComponent) {
        main.enterState(Main.INTRO);
    }
}
