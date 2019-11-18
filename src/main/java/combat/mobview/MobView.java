package combat.mobview;

import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import util.Point;

import java.util.Map;

public class MobView {
    private float x, y, width;
    private Map<BodyPart, Point> offsets;
    private Map<PartType, BodyPart> parts;

    private boolean flipped;

    MobView(float x, float y, Map<BodyPart, Point> offsets, Map<PartType, BodyPart> parts){
        this.offsets = offsets;
        this.parts = parts;

        this.x = x;
        this.y = y;

        width = calcWidth();
        flipped = false;
    }

    public Rectangle getBoundingRectangle(){
        float maxX=0, minX=0, maxY=0, minY=0;
        for(BodyPart part : parts.values()){
            if(offsets.get(part).x + part.getWidth() > maxX)
                maxX = offsets.get(part).x + part.getWidth();
            if(offsets.get(part).y + part.getHeight() > maxY)
                maxY = offsets.get(part).y + part.getHeight();

            if(offsets.get(part).x < minX)
                minX = offsets.get(part).x;
            if(offsets.get(part).y < minY)
                minY = offsets.get(part).y;
        }
        return new Rectangle(x + minX,y + minY, maxX - minX, maxY - minY);
    }

    private float calcWidth(){
        float maxX=0, minX=0;
        for(BodyPart part : parts.values()){
            if(offsets.get(part).x + part.getWidth() > maxX)
                maxX = offsets.get(part).x + part.getWidth();

            if(offsets.get(part).x < minX)
                minX = offsets.get(part).x;
        }

        return maxX - minX;
    }

    public void flip(){
        flipped = !flipped;
    }

    public void render(GameContainer gc, Graphics g){
        for(PartType type : parts.keySet()){
            BodyPart bp = parts.get(type);
            if(flipped)
                g.drawImage(bp.getImage().getFlippedCopy(true, false),
                        x - offsets.get(bp).x - bp.getImage().getWidth() + width, y + offsets.get(bp).y);
            else
                g.drawImage(bp.getImage(),x + offsets.get(bp).x, y + offsets.get(bp).y);
        }
        g.drawOval(x, y, 5, 5);
        g.draw(getBoundingRectangle());
    }
}
