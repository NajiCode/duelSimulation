package model.fighters.states;

import model.equipments.Equipment;
import model.fighters.Fighter;
import model.equipments.offensive.Offensive;

public class Normal implements State {

    @Override
    public void addEquipment(String type, Fighter fighter) {
        fighter.addEquipment(type);
    }

    @Override
    public void blow(Fighter fighter1, Fighter fighter2, Equipment offensive) {
        Offensive offensiveEquipment = (Offensive)offensive;
        offensiveEquipment.applyOn(fighter2);
    }
}
