package model;

public class Swordsman extends Fighter {

    public static final int HIT_POINTS = 100;

    public Swordsman() {
        super(HIT_POINTS);
        addEquipment("1handSword");
    }

    public Swordsman equip(String type) {
        addEquipment(type);
        return this;
    }
}
