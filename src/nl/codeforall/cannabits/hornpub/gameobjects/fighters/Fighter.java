package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

import nl.codeforall.cannabits.hornpub.Attackable;
import nl.codeforall.cannabits.hornpub.gameobjects.GameObject;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public abstract class Fighter extends GameObject implements Attackable {
    protected int healthPoints;
    protected FighterType fighterType;
    protected String name;

    public Fighter(FighterType fighterType, GridPosition gridPosition) {
        super(gridPosition);
        this.fighterType = fighterType;
        healthPoints = fighterType.healthPoints;
    }

//    public void move() {
//    }

    public void attack(Attackable attackable) {
        attackable.takeDamage(fighterType.getAttackDamage());
    }

    public void takeDamage(int attackDamage) {
        if (!isDestroyed()) {
            healthPoints -= attackDamage / (int) (fighterType.getDefence() * 0.3);
            System.out.println("Fighter took " + attackDamage + " damage!");
        }
    }

    public GridPosition getPosition(){
        return position;
    }

    public boolean isDestroyed() {
        return healthPoints <= 0;
    }

    public int attackRange(){
        return fighterType.attackRange;
    }

    public int moveRange(){
        return fighterType.moveRange;
    }
    public int getHealthPoints(){
        return healthPoints;
    }

    @Override
    public String toString() {
        return fighterType.toString();
    }
}
