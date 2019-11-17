package util;

import combat.Attack;
import data.framework.BodyPart;
import data.framework.BodyPartLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.BodyConcreteBodyPart;
import upgrade.bodyparts.BodyConnectors;
import upgrade.bodyparts.ConcreteBodyPart;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JSONPartReader implements BodyPartLoader {

    public HashMap<String, BodyPart> getBodyParts() throws SlickException {
        JSONParser parser = new JSONParser();
        HashMap<String, BodyPart> partsHash = new HashMap<>();

        try {

            FileReader reader = new FileReader("res/bodyparts.json");

            JSONArray parts = (JSONArray) parser.parse(reader);

            for (Object o : parts) {
                JSONObject obj = (JSONObject) o;

                String name = (String) obj.get("name");
                String type = (String) obj.get("type");

                Attack attack = null;
                if(obj.containsKey("attack")) {
                    JSONObject atkObj = (JSONObject) obj.get("attack");
                    JSONObject atkDmgObj = (JSONObject) atkObj.get("damage");

                    float mult = atkDmgObj.containsKey("multiplier") ? (float) atkDmgObj.get("multiplier") : 1;
                    int add = atkDmgObj.containsKey("additive") ? (int) atkDmgObj.get("additive") : 0;


                    attack = new Attack((String) atkObj.get("name"), mult, add);
                }
                int hp = ((Long) obj.get("hp")).intValue();


                BodyPart p;
                JSONObject pointObj = (JSONObject) obj.get("point");
                if(type.equals("body"))
                {
                    BodyConnectors connectors = new BodyConnectors(pointExtractor((JSONObject) pointObj.get("head")),
                            pointExtractor((JSONObject) pointObj.get("arm_right")),
                            pointExtractor((JSONObject) pointObj.get("arm_left")),
                            pointExtractor((JSONObject) pointObj.get("leg_right")),
                            pointExtractor((JSONObject) pointObj.get("leg_left")),
                            pointExtractor((JSONObject) pointObj.get("tail")));
                    p = new BodyConcreteBodyPart(name, type, hp, connectors, 1);
                }
                else {
                    Point point = pointExtractor(pointObj);
                    p = new ConcreteBodyPart(name, type, attack, hp, point, 1);
                }



                partsHash.put(name, p);
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
