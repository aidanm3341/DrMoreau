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

//    public PositionedImage getFlippedCopy(Boolean flipHorizontal, Boolean flipVertical)
//    {
//        return new PositionedImage(image.getFlippedCopy(flipHorizontal, flipVertical), x, y);
//    }

    public void flipH()
    {
        image = image.getFlippedCopy(true, false);
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

    public float getWidth(){return image.getWidth();}

    public float getHeight(){return image.getHeight();}
}
