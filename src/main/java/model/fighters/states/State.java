package model.fighters.states;

import model.equipments.Equipment;
import model.fighters.Fighter;

public interface State {

    void addEquipment(String type, Fighter fighter);

    void blow(Fighter fighter1,Fighter fighter2,Equipment offensive);
}
