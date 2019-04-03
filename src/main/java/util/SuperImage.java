package util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class SuperImage {

    private ArrayList<PositionedImage> images;
    private Boolean isFlippedH;

    public SuperImage()
    {
        images = new ArrayList<>();
        isFlippedH = false;
    }

    public void addImage(PositionedImage image)
    {
        images.add(image);
    }

    public void removeImage(PositionedImage image){images.remove(image);}

    public void flipH(boolean isFlippedH)
    {
        this.isFlippedH = isFlippedH;
        for(PositionedImage img : images)
            img.flipH();


    }

    private float calcX(float x, PositionedImage img)
    {
        if(!isFlippedH)
            return x + img.getX();
        else
            return x - img.getX() - img.getWidth();
    }

    public void render(float x, float y, Graphics g)
    {
        for(PositionedImage img : images){
            g.drawImage(img.getImage(), calcX(x, img), y + img.getY());
        }

    }
}

