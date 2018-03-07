package model;

import factory.EquipmentFactory;

import java.util.ArrayList;
import java.util.List;

public class Fighter {
    protected Integer hitPoints;
    protected List<Equipment> equipments;

    protected EquipmentFactory equipmentFactory;

    protected Fighter(int hitPoints) {
        this.hitPoints = hitPoints;
        this.equipments = new ArrayList<>();
        this.equipmentFactory = new EquipmentFactory();
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
        for (Equipment equipment : equipments){
            if (equipment instanceof Offensive) {
                Offensive offensiveEquipment = (Offensive)equipment;
                offensiveEquipment.applyOn(fighter);
            }
        }
    }

    private boolean someOneIsDead(Fighter fighter) {
        if(this.hitPoints==0 || fighter.hitPoints==0){
            return true;
        }
        return false;
    }

    public void decreaseHitPoints(int damage,Offensive offensive) {
        List<Equipment> equipmentsTobeRemoved = new ArrayList<>();

        for(Equipment equipment : equipments){
            if(equipment instanceof Defensive){
                Defensive defensiveEquipment = (Defensive)equipment;
                int previousDamage = damage;
                damage = defensiveEquipment.reduceDamage(damage);
                if(defensiveEquipment.isDestroyedBy(offensive)){
                    equipmentsTobeRemoved.add(equipment);
                }
                if (previousDamage==damage){
                    break;
                }
            }
        }

        removeEquipments(equipmentsTobeRemoved);
        hitPoints-=damage;
        if(hitPoints<0){
            hitPoints = 0;
        }
    }

    private void removeEquipments(List<Equipment> equipmentsTobeRemoved) {
        for (Equipment equipment : equipmentsTobeRemoved){
            equipments.remove(equipment);
        }
    }

    public Integer hitPoints() {
        return  hitPoints;
    }

    protected void addEquipment(String type){
        Equipment equipment = equipmentFactory.create(type);
        this.equipments.add(equipment);
        if (equipment instanceof Defensive){
            Defensive defensive = (Defensive)equipment;
            for(Equipment e : equipments){
                if(e instanceof Offensive){
                    Offensive offensive = (Offensive) e;
                    offensive.changeDamage(defensive);
                }
            }
        }
    }
    private void putPoisonOnWeapen(){
        for(Equipment e : equipments){
            if(e instanceof Offensive){
                Offensive offensive = (Offensive) e;
                ExtratEquipment poison = new Poison();
                offensive.putExtraEffect(poison);
            }
        }
    }
}
