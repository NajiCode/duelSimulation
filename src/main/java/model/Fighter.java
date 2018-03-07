package model;

public class Fighter {
    protected Integer hitPoints;
    protected Equipment offensive;

    protected EquipmentFactory equipmentFactory;
    protected Fighter(int hitPoints) {
        this.hitPoints = hitPoints;
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
        offensive.applyOn(fighter);
    }

    private boolean someOneIsDead(Fighter fighter) {
        if(this.hitPoints==0 || fighter.hitPoints==0){
            return true;
        }
        return false;
    }

    public void decreaseHitPoints(int damage) {
        hitPoints-=damage;
        if(hitPoints<0){
            hitPoints = 0;
        }
    }

    public Integer hitPoints() {
        return  hitPoints;
    }
}
