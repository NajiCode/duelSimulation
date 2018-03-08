package model.equipments.defensive;


import model.equipments.Equipment;
import model.equipments.offensive.Offensive;

public abstract class Defensive implements Equipment {

    public abstract int reduceDamage(int damage);
    public abstract boolean isDestroyedBy(Offensive offensive);

    public abstract int pointsToReduceOnAttack();
}
