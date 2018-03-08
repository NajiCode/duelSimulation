package model.fighters.states;

import model.equipments.Equipment;
import model.fighters.Fighter;
import model.equipments.offensive.Offensive;

public class Veteran implements State {
    private boolean isBerserk;


    @Override
    public void addEquipment(String type, Fighter fighter) {
        fighter.addEquipment(type);
    }

    @Override
    public void blow(Fighter fighter1,Fighter fighter2, Equipment offensive) {
        if(!isBerserk && fighter1.areHitPointsUnder(30)){
            fighter1.putDoubleDamageOnWeapon();
            isBerserk = true;
        }

        Offensive offensiveEquipment = (Offensive)offensive;
        offensiveEquipment.applyOn(fighter2);
    }
}
