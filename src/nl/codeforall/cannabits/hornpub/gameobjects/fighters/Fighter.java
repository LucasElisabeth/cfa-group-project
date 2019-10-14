package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

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

    }

    public void takeDamage(int hit) {

    }

    public boolean isDestroyed() {
        return false;
    }
}
