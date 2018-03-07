package model;

public class Offensive implements Equipment {
    protected int damage;

    public void applyOn(Fighter fighter, Offensive offensive) {
        fighter.decreaseHitPoints(damage,offensive);
    }
}
