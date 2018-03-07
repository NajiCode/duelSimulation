package model;

public class Highlander extends Fighter {
    public static final int HIT_POINTS = 150;

    public Highlander() {
        super(HIT_POINTS);
        addEquipment("greatSword");
    }
}
