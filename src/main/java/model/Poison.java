package model;

public class Poison implements ExtratEquipment {
    private final int damage = 20;

    @Override
    public int extratDamageToApply() {
        return damage;
    }
}
