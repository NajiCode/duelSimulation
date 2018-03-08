package model.equipments.defensive;

import model.equipments.offensive.Offensive;

public class Armor extends Defensive {

    public static final int PROTECTED_POINTS = 3;
    public static final int REDUCED_POINTS_ON_ATTACK = 1;

    @Override
    public int reduceDamage(int damage) {
        return damage - PROTECTED_POINTS;
    }

    @Override
    public boolean isDestroyedBy(Offensive offensive) {
        return false;
    }

    @Override
    public int pointsToReduceOnAttack() {
        return REDUCED_POINTS_ON_ATTACK;
    }
}
