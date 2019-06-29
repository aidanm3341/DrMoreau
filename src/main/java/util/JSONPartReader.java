package util;

import combat.Attack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.BodyBodyPart;
import upgrade.bodyparts.BodyConnectors;
import upgrade.bodyparts.BodyPart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class JSONPartReader {

    public static void writePart(BodyPart part) throws IOException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonPart = new JSONObject();
        jsonPart.put("name", part.getName());
        jsonPart.put("type", part.getType());
        jsonPart.put("hp", part.getHp());
        JSONObject attack = new JSONObject();
        attack.put("name", part.getAttack().getName());
        attack.put("damage", part.getAttack().getDmg(1));
        jsonPart.put("attack", attack);
        JSONObject attachPoint = new JSONObject();
        attachPoint.put("x", part.getAttachPoint().getX());
        attachPoint.put("y", part.getAttachPoint().getY());
        jsonPart.put("point", attachPoint);


        jsonArray.add(jsonPart);

        FileWriter writer = new FileWriter("resources/bodyparts.json");
        writer.write(jsonArray.toJSONString());
        writer.flush();
    }

    public static HashMap<String, BodyPart> readParts() throws SlickException {
        JSONParser parser = new JSONParser();
        HashMap<String, BodyPart> partsHash = new HashMap<>();

        try {

            FileReader reader = new FileReader("resources/bodyparts.json");

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
                    p = new BodyBodyPart(name, type, hp, connectors);
                }
                else {
                    Point point = pointExtractor(pointObj);
                    p = new BodyPart(name, type, attack, hp, point);
                }



                partsHash.put(name, p);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return partsHash;
    }

    private static Point pointExtractor(JSONObject obj)
    {
        return new Point(((Long) obj.get("x")).intValue(), ((Long) obj.get("y")).intValue());
    }
}
