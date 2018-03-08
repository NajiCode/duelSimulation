package model.fighters;

public class Highlander extends Fighter {
    public static final int HIT_POINTS = 150;

    public Highlander() {
        super(HIT_POINTS);
        addEquipment("greatSword");
    }

    public Highlander(String type) {
        super(HIT_POINTS,type);
        addEquipment("greatSword");
    }
}
