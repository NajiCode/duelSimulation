package model;

public abstract class Offensive implements Equipment {
    protected int damage;
    protected int nbrOfAttacks;

    public void applyOn(Fighter fighter) {
        if (canBeUsed()) {
            fighter.decreaseHitPoints(damage,this);
        }
    }

    public abstract boolean canBeUsed();

    public void changeDamage(Defensive defensive){
        int points = defensive.pointsToReduceOnAttack();
        damage-=points;
    }
}
