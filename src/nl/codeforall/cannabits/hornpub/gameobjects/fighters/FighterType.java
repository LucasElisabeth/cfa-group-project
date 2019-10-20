package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

public enum FighterType {
    ANIMEGIRL(1, 50, 25, 3,3),
    UNICORN_RIDING_CAT(150,30,20,5,2);

    protected int healthPoints;
    private int attackDamage;
    private int defence;
    protected int moveRange;
    protected int attackRange;

    FighterType(int healthPoints, int attackDamage, int defence, int moveRange, int attackRange) {
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.moveRange = moveRange;
        this.attackRange = attackRange;
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
