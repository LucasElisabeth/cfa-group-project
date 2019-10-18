package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

import nl.codeforall.cannabits.hornpub.Attackable;
import nl.codeforall.cannabits.hornpub.gameobjects.GameObject;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public abstract class Fighter extends GameObject implements Attackable {
    protected int healthPoints;
    protected FighterType fighterType;
    protected String name;
    protected int movesLeft;

    Fighter(FighterType fighterType, GridPosition gridPosition) {
        super(gridPosition);
        this.fighterType = fighterType;
        healthPoints = fighterType.healthPoints;
        movesLeft = fighterType.getMoveRange();
    }

    public void move() {
        if (movesLeft > 0) {
            //stuff
            movesLeft--;
        }
    }

    public void attack(Attackable attackable) {
        attackable.takeDamage(fighterType.getAttackDamage());
    }

    public void takeDamage(int attackDamage) {
        if (!isDestroyed()) {
            fighterType.healthPoints -= attackDamage / (int) (fighterType.getDefence() * 0.3);
        }
    }

    public boolean isDestroyed() {
        return healthPoints <= 0;
    }

    @Override
    public String toString() {
        return fighterType.toString();
    }
}
