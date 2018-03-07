package model;

public class OneHandAxe extends Offensive {

    public static final int DAMAGE = 6;

    public OneHandAxe() {
        this.damage = DAMAGE;
    }

    @Override
    public boolean canBeUsed() {
        return true;
    }
}
