package model;

public abstract class Defensive implements Equipment{

    public abstract int reduceDamage(int damage);
    public abstract boolean isDestroyedBy(Offensive offensive);
}
