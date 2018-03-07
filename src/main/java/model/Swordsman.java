package model;

public class Swordsman extends Fighter {

    public static final int HIT_POINTS = 100;

    public Swordsman() {
        super(HIT_POINTS);
        this.offensive  = equipmentFactory.create("1handSword");
    }
}
