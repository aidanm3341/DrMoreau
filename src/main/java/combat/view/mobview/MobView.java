package combat.view.mobview;

import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import util.Point;

import java.util.Map;

public class MobView {
    private PhysicalAttributes attributes;
    private float width;
    private Map<IBodyPart, Point> offsets;
    private Map<PartType, IBodyPart> parts;

    private boolean flipped;

    MobView(Map<IBodyPart, Point> offsets, Map<PartType, IBodyPart> parts){
        this.offsets = offsets;
        this.parts = parts;

        this.attributes = new PhysicalAttributes(0, 0);

        width = calcWidth();
        flipped = false;
    }

    public Rectangle getBoundingRectangle(){
        float maxX=0, minX=0, maxY=0, minY=0;
        for(IBodyPart part : parts.values()){
            if(offsets.get(part).x + part.getWidth() > maxX)
                maxX = offsets.get(part).x + part.getWidth();
            if(offsets.get(part).y + part.getHeight() > maxY)
                maxY = offsets.get(part).y + part.getHeight();

            if(offsets.get(part).x < minX)
                minX = offsets.get(part).x;
            if(offsets.get(part).y < minY)
                minY = offsets.get(part).y;
        }
        return new Rectangle(attributes.x + minX,attributes.y + minY, maxX - minX, maxY - minY);
    }

    private float calcWidth(){
        float maxX=0, minX=0;
        for(IBodyPart part : parts.values()){
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

    public void render(GameContainer gc, Graphics g) throws SlickException {
        for(PartType type : parts.keySet()){
            IBodyPart bp = parts.get(type);
            if(flipped)
                g.drawImage(bp.getImage().getFlippedCopy(true, false),
                        attributes.x - offsets.get(bp).x - bp.getImage().getWidth() + width, attributes.y + offsets.get(bp).y);
            else
                g.drawImage(bp.getImage(),attributes.x + offsets.get(bp).x, attributes.y + offsets.get(bp).y);
        }
//        g.drawOval(x, y, 5, 5);
//        g.draw(getBoundingRectangle());
    }

    public PhysicalAttributes getAttributes(){
        return attributes;
    }

    public void setXAndHomeX(float x){
        attributes.x = x;
        attributes.homeX = x;
    }

    public void setYandHomeY(float y){
        attributes.y = y;
        attributes.homeY = y;
    }
}
