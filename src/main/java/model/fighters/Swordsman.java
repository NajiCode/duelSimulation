package model.fighters;

public class Swordsman extends Fighter {

    public static final int HIT_POINTS = 100;

    public Swordsman() {
        super(HIT_POINTS);
        addEquipment("1handSword");
    }

    public Swordsman(String type) {
        super(HIT_POINTS,type);
        addEquipment("1handSword");
    }

    public Swordsman equip(String type) {
        state.addEquipment(type,this);
        return this;
    }
}
