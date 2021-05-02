package combat.view.mobview;

import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import util.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MobViewBuilder {
    private float overallOffsetX, overallOffsetY;
    private PhysicalAttributes attributes;
    private Map<IBodyPart, Point> offsets;
    private Map<PartType, IBodyPart> parts;
    private IBodyPart body;

    public MobViewBuilder(IBodyPart body, PhysicalAttributes attributes){
        offsets = new HashMap<>();
        parts = new TreeMap<>();

        this.attributes = attributes;

        overallOffsetX = 0;
        overallOffsetY = 0;

        this.body = body;
        parts.put(PartType.BODY, body);
        offsets.put(body, new Point(0, 0));
    }

    public void addPart(PartType type, IBodyPart part){
        parts.put(type, part);

        float newX = body.getAttachPointFor(type).x - parts.get(type).getAttachPointFor(PartType.BODY).x;
        float newY = body.getAttachPointFor(type).y - parts.get(type).getAttachPointFor(PartType.BODY).y;

        Point newPoint = new Point(newX, newY);
        offsets.put(parts.get(type), newPoint);

        overallOffsetX = Math.min(newX, overallOffsetX);
        overallOffsetY = Math.min(newY, overallOffsetY);
    }

    public MobView finalise(boolean flipped){
        offsets.replaceAll((b, v) -> new Point(offsets.get(b).x - overallOffsetX, offsets.get(b).y - overallOffsetY));
        MobView view = new MobView(attributes, offsets, parts);
        if(flipped)
            view.flip();
        return view;
    }
}
