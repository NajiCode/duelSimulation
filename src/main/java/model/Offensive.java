package model;

public class Offensive implements Equipment {
    protected int damage;

    public void applyOn(Fighter fighter) {
        fighter.decreaseHitPoints(damage);
    }
}
