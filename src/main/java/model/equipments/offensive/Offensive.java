package model.equipments.offensive;

import model.equipments.Equipment;
import model.equipments.defensive.Defensive;
import model.equipments.extras.ExtratEquipment;
import model.fighters.Fighter;

public abstract class Offensive implements Equipment {
    protected int damage;
    protected int nbrOfAttacks;
    protected ExtratEquipment extratEffect;

    public void applyOn(Fighter fighter) {

        if (canBeUsed()) {
            int damageToApply = damage;
            if(extratEffect!=null){
                damageToApply+=extratEffect.extratDamageToApply();
                if(extratEffect.isConsumed()){
                    extratEffect = null;
                }
            }
            fighter.decreaseHitPoints(damageToApply,this);
        }
    }

    public abstract boolean canBeUsed();

    public void changeDamage(Defensive defensive){
        int points = defensive.pointsToReduceOnAttack();
        damage-=points;
    }

    public void putExtraEffect(ExtratEquipment poison) {
        this.extratEffect = poison;
    }

    public int getDamage() {
        return damage;
    }
}
