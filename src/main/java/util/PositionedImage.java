package util;

import org.newdawn.slick.Image;

public class PositionedImage {

    private Image image;
    private float x, y;

    public PositionedImage(Image image, float x, float y){
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
