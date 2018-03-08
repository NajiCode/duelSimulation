package model.equipments.extras;

public class DoubleDamage implements ExtratEquipment {

    private int damage;

    public DoubleDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int extratDamageToApply() {
        return damage;
    }

    @Override
    public boolean isConsumed() {
        return false;
    }
}
