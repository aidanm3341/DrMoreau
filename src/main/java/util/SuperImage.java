package util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class SuperImage {

    private ArrayList<PositionedImage> images;
    //private float x, y;

    public SuperImage()//float x, float y)
    {
        images = new ArrayList<>();
        //this.x = x;
        //this.y = y;
    }

    public void addImage(PositionedImage image)
    {
        images.add(image);
    }

    public void render(float x, float y, Graphics g)
    {
        for(PositionedImage img : images){
            g.drawImage(img.getImage(), x + img.getX(), y + img.getY());
        }

    }
}

