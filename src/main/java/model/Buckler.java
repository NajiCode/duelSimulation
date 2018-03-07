package model;

public class Buckler extends Defensive {
    private boolean isActive;
    private int nbrOfHits;
    public Buckler() {
        this.isActive = true;
        this.nbrOfHits = 0;
    }

    @Override
    public int reduceDamage(int damage) {
        if(isActive){
            isActive = false;
            return 0;
        }else {
            isActive = true;
            return damage;
        }
    }
    public boolean isDestroyedBy(Offensive offensive){
        if(isActive && offensive instanceof OneHandAxe){
            nbrOfHits++;
            if (nbrOfHits>=3){
                return true;
            }
        }
        return false;
    }

    @Override
    public int pointsToReduceOnAttack() {
        return 0;
    }
}
