package model;

public class GreatSword extends Offensive {

    public static final int DAMAGE = 12;

    public GreatSword() {
        this.damage = DAMAGE;
        this.nbrOfAttacks = 0;
    }

    @Override
    public boolean canBeUsed() {
        if(nbrOfAttacks==2){
            nbrOfAttacks = 0;
            return false;
        }else {
            nbrOfAttacks++;
            return true;
        }
    }
}
