package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

import com.sun.source.tree.WhileLoopTree;
import nl.codeforall.cannabits.hornpub.Attackable;
import nl.codeforall.cannabits.hornpub.gameobjects.GameObject;

public abstract class Fighter extends GameObject implements Attackable {
    protected FighterType fighterType;
    protected String name;

    Fighter(FighterType fighterType) {
        this.fighterType = fighterType;
    }

    public void move() {

    }

    public void attack(Attackable attackable) {
        attackable.takeDamage(fighterType.getAttackDamage());
    }

    public void takeDamage(int attackDamage) {
        if (fighterType.healthPoints > 0) {
            fighterType.healthPoints -= attackDamage / (int) (fighterType.getDefence() * 0.3);
            return;
        }

    }

    public boolean isDestroyed() {
        return false;
    }

//    public int health() {
//        return fighterType.getHealthPoints();
//    }
}
