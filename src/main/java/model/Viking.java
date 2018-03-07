package model;

public class Viking extends Fighter {

    public static final int HIT_POINTS = 120;

    public Viking() {
        super(HIT_POINTS);
        addEquipment("axe");
    }

    public Viking equip(String type) {
        addEquipment(type);
        return this;
    }
}
