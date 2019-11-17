package combat;

import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import upgrade.bodyparts.BodyConcreteBodyPart;
import util.Point;

import java.util.*;

public class MobView {
    private int x, y;
    private Map<BodyPart, Point> offsets;
    private Map<PartType, BodyPart> parts;
    private BodyConcreteBodyPart body;

    public MobView(BodyConcreteBodyPart body, int x, int y){
        offsets = new HashMap<>();
        parts = new TreeMap<>();

        this.x = x;
        this.y = y;

        this.body = body;
        parts.put(PartType.BODY, body);
        offsets.put(body, new Point(0, 0));
    }

    public void addPart(PartType type, BodyPart part){
        parts.put(type, part);

        Point newPoint = new Point(
                body.getAttachPoints().get(type).x - parts.get(type).getAttachPoints().get(PartType.BODY).x,
                body.getAttachPoints().get(type).y - parts.get(type).getAttachPoints().get(PartType.BODY).y
        );
        offsets.put(parts.get(type), newPoint);
    }

    public void render(GameContainer gc, Graphics g){
        for(PartType type : parts.keySet()){
            BodyPart bp = parts.get(type);
            g.drawImage(bp.getImage().getFlippedCopy(true, false),
                    x - offsets.get(bp).x - bp.getImage().getWidth(), y + offsets.get(bp).y);
        }
    }
}
