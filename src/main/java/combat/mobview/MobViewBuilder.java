package combat.mobview;

import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import upgrade.bodyparts.BodyConcreteBodyPart;
import util.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MobViewBuilder {
    private float x, y, overallOffsetX, overallOffsetY;
    private Map<BodyPart, Point> offsets;
    private Map<PartType, BodyPart> parts;
    private BodyConcreteBodyPart body;

    public MobViewBuilder(BodyConcreteBodyPart body, int x, int y){
        offsets = new HashMap<>();
        parts = new TreeMap<>();

        this.x = x;
        this.y = y;

        overallOffsetX = 0;
        overallOffsetY = 0;

        this.body = body;
        parts.put(PartType.BODY, body);
        offsets.put(body, new Point(0, 0));
    }

    public void addPart(PartType type, BodyPart part){
        parts.put(type, part);

        float newX = body.getAttachPoints().get(type).x - parts.get(type).getAttachPoints().get(PartType.BODY).x;
        float newY = body.getAttachPoints().get(type).y - parts.get(type).getAttachPoints().get(PartType.BODY).y;

        Point newPoint = new Point(newX, newY);
        offsets.put(parts.get(type), newPoint);

        overallOffsetX = Math.min(newX, overallOffsetX);
        overallOffsetY = Math.min(newY, overallOffsetY);
    }

    public MobView finalise(){
        offsets.replaceAll((b, v) -> new Point(offsets.get(b).x - overallOffsetX, offsets.get(b).y - overallOffsetY));
        return new MobView(x, y, offsets, parts);
    }
}
