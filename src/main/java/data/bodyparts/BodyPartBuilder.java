package data.bodyparts;

import combat.abilities.Ability;
import combat.abilities.AbilityFactory;
import combat.stats.Stats;
import combat.view.animation.AttackAnimation;
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class BodyPartBuilder {

    private String name;
    private Stats stats;
    private Ability ability;
    private Map<PartType, Point> attachPoints;

    public BodyPartBuilder() {
        reset();
    }

    public void reset(){
        name = "";
        stats = new Stats();
        ability = new AbilityFactory(AttackAnimation.DIRECTION.RIGHT).nullAbility();
        attachPoints = new HashMap<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void addAllAttachPoints(Map<PartType, Point> attachPoints) {
        this.attachPoints.putAll(attachPoints);
    }

    public void addAttachPoint(PartType type, Point point){
        this.attachPoints.put(type, point);
    }

    public IBodyPart finish(){
        IBodyPart part = new BodyPart(name, stats, ability, attachPoints);
        reset();
        return part;
    }
}
