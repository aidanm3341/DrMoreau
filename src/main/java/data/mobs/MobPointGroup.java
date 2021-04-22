package data.mobs;

import data.framework.PartType;
import util.Point;

import java.util.Map;

public record MobPointGroup(Point headAttachPoint, Point armAttachPoint, Point legAttachPoint, Point tailAttachPoint, Map<PartType, Point> bodyAttachPoints) {
//
//
//    public Point getHeadAttachPoint() {
//        return headAttachPoint;
//    }
//
//    public Point getArmAttachPoint() {
//        return armAttachPoint;
//    }
//
//    public Point getLegAttachPoint() {
//        return legAttachPoint;
//    }
//
//    public Point getTailAttachPoint() {
//        return tailAttachPoint;
//    }
//
//    public Map<PartType, Point> getBodyAttachPoints() {
//        return bodyAttachPoints;
//    }
//
//    public void setHeadAttachPoint(int x, int y){
//        headAttachPoint = new Point(x, y);
//    }
//
//    public void setArmAttachPoint(int x, int y){
//        armAttachPoint = new Point(x, y);
//    }
//
//    public void setLegAttachPoint(int x, int y){
//        legAttachPoint = new Point(x, y);
//    }
//
//    public void setTailAttachPoint(int x, int y){
//        tailAttachPoint = new Point(x, y);
//    }
//
//    public void setBodyAttachPoints(Map<PartType, Point> bodyAttachPoints) {
//        this.bodyAttachPoints = bodyAttachPoints;
//    }
}
