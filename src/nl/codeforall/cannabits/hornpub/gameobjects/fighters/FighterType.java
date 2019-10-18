package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

public enum FighterType {
    ANIMEGIRL(100, 50, 25, 3),
    UNICORN_RIDING_CAT(150,30,20,5);

    protected int healthPoints;
    private int attackDamage;
    private int defence;
    private int moveRange;

    FighterType(int healthPoints, int attackDamage, int defence, int moveRange) {
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.moveRange = moveRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDefence() {
        return defence;
    }

    public int getMoveRange() {
        return moveRange;
    }
}
