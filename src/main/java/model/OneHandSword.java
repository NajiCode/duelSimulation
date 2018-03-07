package model;

public class OneHandSword extends Offensive {

    public static final int DAMAGE = 5;

    public OneHandSword() {
        this.damage = DAMAGE;
    }

    @Override
    public boolean canBeUsed() {
        return true;
    }
}
