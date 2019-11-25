package data;

import combat.Ability;
import data.framework.BodyPart;
import data.framework.BodyPartLoader;
import data.framework.PartType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.newdawn.slick.SlickException;
import util.Point;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONPartReader implements BodyPartLoader {

    public HashMap<String, BodyPart> getBodyParts() throws SlickException {
        JSONParser parser = new JSONParser();
        HashMap<String, BodyPart> partsHash = new HashMap<>();

        try {

            FileReader reader = new FileReader("resources/bodyparts.json");

            JSONArray parts = (JSONArray) parser.parse(reader);

            for (Object o : parts) {
                JSONObject obj = (JSONObject) o;

                String name = (String) obj.get("name");
                String type = (String) obj.get("type");

                Ability attack = null;
                if(obj.containsKey("attack")) {
                    JSONObject atkObj = (JSONObject) obj.get("attack");
                    JSONObject atkDmgObj = (JSONObject) atkObj.get("damage");

                    float mult = atkDmgObj.containsKey("multiplier") ? (float) atkDmgObj.get("multiplier") : 1;
                    int add = atkDmgObj.containsKey("additive") ? (int) atkDmgObj.get("additive") : 0;


                    //attack = new Attack((String) atkObj.get("name"), mult, add);
                }
                int hp = ((Long) obj.get("hp")).intValue();


                BodyPart p;
                JSONArray points = (JSONArray) obj.get("points");
                Map<PartType, Point> attachPoints = new HashMap<>();
                for(Object ob : points){
                    JSONObject point = (JSONObject) ob;
                    for(Object ob2 : point.keySet()){   //should only be 1 thing
                        String partType = (String) ob2;
                        point.get(partType);

                        PartType thePartType;
                        switch (partType){
                            case "body":
                                thePartType = PartType.BODY; break;
                            case "head":
                                thePartType = PartType.HEAD; break;
                            case "arm_left":
                                thePartType = PartType.LEFT_ARM; break;
                            case "arm_right":
                                thePartType = PartType.RIGHT_ARM; break;
                            case "leg_left":
                                thePartType = PartType.LEFT_LEG; break;
                            case "leg_right":
                                thePartType = PartType.RIGHT_LEG; break;
                            case "tail":
                                thePartType = PartType.TAIL; break;
                            default:
                                thePartType = PartType.BODY;
                        }

                        attachPoints.put(thePartType, pointExtractor((JSONObject) point.get(partType)));
                    }
                }
//                if(type.equals("body"))
//                {
//                    BodyConnectors connectors = new BodyConnectors(pointExtractor((JSONObject) pointObj.get("head")),
//                            pointExtractor((JSONObject) pointObj.get("arm_right")),
//                            pointExtractor((JSONObject) pointObj.get("arm_left")),
//                            pointExtractor((JSONObject) pointObj.get("leg_right")),
//                            pointExtractor((JSONObject) pointObj.get("leg_left")),
//                            pointExtractor((JSONObject) pointObj.get("tail")));
//                    p = new BodyConcreteBodyPart(name, hp, connectors, 1);
//                }
//                else {
//                    Point point = pointExtractor(pointObj);
//                    p = new ConcreteBodyPart(name, attack, hp, point, 1);
//                }

                //partsHash.put(name, new ConcreteBodyPart(name, attack, hp, attachPoints));
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return partsHash;
    }

    private static Point pointExtractor(JSONObject obj)
    {
        return new Point(((Long) obj.get("x")).intValue(), ((Long) obj.get("y")).intValue());
    }
}
