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
        if (!isDestroyed()) {
            fighterType.healthPoints -= attackDamage / (int) (fighterType.getDefence() * 0.3);
        }
    }

    public boolean isDestroyed() {
        return fighterType.healthPoints <= 0;
    }
}
