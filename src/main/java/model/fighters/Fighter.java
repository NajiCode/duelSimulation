package model.fighters;

import factory.EquipmentFactory;
import factory.StateFactory;
import model.equipments.Equipment;
import model.equipments.defensive.Defensive;
import model.equipments.extras.DoubleDamage;
import model.equipments.extras.ExtratEquipment;
import model.equipments.extras.Poison;
import model.equipments.offensive.Offensive;
import model.fighters.states.State;

import java.util.ArrayList;
import java.util.List;

public class Fighter {
    protected Integer initialHitPoitnts;
    protected Integer hitPoints;
    protected List<Equipment> defensives;
    protected Equipment offensive;
    protected State state;

    protected EquipmentFactory equipmentFactory;
    protected StateFactory stateFactory;

    protected Fighter(int hitPoints) {
        this.initialHitPoitnts = hitPoints;
        this.hitPoints = hitPoints;
        this.defensives = new ArrayList<>();
        this.equipmentFactory = new EquipmentFactory();
        this.stateFactory = new StateFactory();
        this.state = stateFactory.create("Normal");
    }

    public Fighter(int hitPoints,String type) {
        this(hitPoints);
        this.state = stateFactory.create(type);
    }

    public void engage(Fighter fighter) {

        while (true){
            this.blow(fighter);
            if(someOneIsDead(fighter)){
             break;
            }
            fighter.blow(this);
            if(someOneIsDead(fighter)){
                break;
            }
        }
    }

    private void blow(Fighter fighter) {
        state.blow(this,fighter,offensive);
    }

    private boolean someOneIsDead(Fighter fighter) {
        if(this.hitPoints==0 || fighter.hitPoints==0){
            return true;
        }
        return false;
    }

    public void decreaseHitPoints(int damage, Offensive offensive) {
        List<Equipment> equipmentsTobeRemoved = new ArrayList<>();
        for(Equipment defensive : defensives){
            Defensive defensiveEquipment = (Defensive)defensive;
            int previousDamage = damage;
            damage = defensiveEquipment.reduceDamage(damage);
            if(defensiveEquipment.isDestroyedBy(offensive)){
                equipmentsTobeRemoved.add(defensive);
            }

        }

        removeEquipments(equipmentsTobeRemoved);
        if(damage>0){
            hitPoints-=damage;
        }
        if(hitPoints<0){
            hitPoints = 0;
        }
    }

    private void removeEquipments(List<Equipment> equipmentsTobeRemoved) {
        for (Equipment equipment : equipmentsTobeRemoved){
            defensives.remove(equipment);
        }
    }

    public Integer hitPoints() {
        return  hitPoints;
    }

    public void addEquipment(String type){
        Equipment equipment = equipmentFactory.create(type);
        if(equipment instanceof Offensive){
            offensive = equipment;
        }else {
            defensives.add(equipment);
            Defensive defensive = (Defensive)equipment;
            Offensive offensive1 = (Offensive) offensive;
            offensive1.changeDamage(defensive);
        }

    }

    public void putPoisonOnWeapen(){
        Offensive offensive1 = (Offensive) offensive;
        ExtratEquipment poison = new Poison();
        offensive1.putExtraEffect(poison);
    }

    public void putDoubleDamageOnWeapon() {
        Offensive offensive1 = (Offensive) offensive;
        ExtratEquipment doubleDamage = new DoubleDamage(offensive1.getDamage());
        offensive1.putExtraEffect(doubleDamage);
    }

    public boolean areHitPointsUnder(int percent) {
        int currentPercent = hitPoints*100/initialHitPoitnts;
        if(currentPercent<percent){
            return true;
        }
        return false;
    }

    public void setState(State state) {
        this.state = state;
    }
}
