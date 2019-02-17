package animal;

public enum PartType {
    BODY(1), HEAD(3), ARM(2), ARM2(0), LEG(2), LEG2(0), TAIL(2);

    private int zIndex;

    PartType(int zIndex)
    {
        this.zIndex = zIndex;
    }

    public int getZIndex(){
        return zIndex;
    }
}
