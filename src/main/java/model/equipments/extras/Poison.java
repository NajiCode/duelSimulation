package model.equipments.extras;

public class Poison implements ExtratEquipment {
    private final int damage = 20;
    private int nbrOfUse;

    public Poison() {
        this.nbrOfUse = 0;
    }

    @Override
    public int extratDamageToApply() {
        nbrOfUse++;
        return damage;
    }

    @Override
    public boolean isConsumed() {
        if (nbrOfUse==2){
            return true;
        }
        return false;
    }
}
